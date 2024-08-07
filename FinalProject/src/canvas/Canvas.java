package canvas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

class Canvas extends JPanel {
	private Rectangle shape;
	private ArrayList<NamedRectangle> shapes;
	private Inspector inspector;
	private NamedRectangle selected;
	private ShapeList list;
	private Color defaultStrokeColor;
	private Color defaultFillColor;
	private float defaultStrokeWidth;
	
	public Canvas() {
		defaultStrokeColor = Color.BLACK;
		defaultFillColor = Color.LIGHT_GRAY;
		defaultStrokeWidth = 3.0f;
		shapes = new ArrayList<NamedRectangle>();
		setBackground(Color.WHITE);

		MouseListener listen = new MouseListener();
		addMouseListener(listen);
		addMouseMotionListener(listen);
	}
	
	public void setInspector(Inspector i) {
		this.inspector = i;
	}
	
	public void setShapeList(ShapeList list) {
		this.list = list;
	}
	
	public NamedRectangle getSelected() {
		return selected;
	}
	
	public void updateShape(int x, int y, int width, int height) {
		selected.getRectangle().setBounds(x, y, width, height);
		repaint();
	}
	
	public ArrayList<NamedRectangle> getShapes() {
		return shapes;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		for (NamedRectangle r : shapes){
			g2d.setStroke(new BasicStroke(r.getStrokeWidth()));
			g2d.setColor(r.getFillColor());
			g2d.fill(r.getRectangle());
			g2d.setColor(r.getStrokeColor());
			g2d.draw( r.getRectangle() );
		}

		if (shape != null){
			g2d.setStroke(new BasicStroke(defaultStrokeWidth));
			g2d.setColor(defaultFillColor);
			g2d.fill(shape);
			g2d.setColor(defaultStrokeColor);
			g2d.draw( shape );
		}
	}
	
	class MouseListener extends MouseInputAdapter {
		private Point startPoint;

		public void mousePressed(MouseEvent e){
			startPoint = e.getPoint();
			shape = new Rectangle();
			if(selected != null) selected.setSelected(false);
			selected = null;
			
			// temporarily selecting shape here
			for(int i = shapes.size() - 1; i >= 0; i--) {
				NamedRectangle r = shapes.get(i);
				if(r.getRectangle().contains(startPoint)) {
					selected = r;
					r.setSelected(true);
					inspector.updateFields(r.getRectangle());
					break;
				}
			}
			repaint();
		}

		public void mouseDragged(MouseEvent e){
			int x = Math.min(startPoint.x, e.getX());
			int y = Math.min(startPoint.y, e.getY());
			int width = Math.abs(startPoint.x - e.getX());
			int height = Math.abs(startPoint.y - e.getY());

			shape.setBounds(x, y, width, height);
			repaint();
		}

		public void mouseReleased(MouseEvent e){
			if (shape.width != 0 || shape.height != 0){
				NamedRectangle rect = new NamedRectangle(defaultStrokeColor, defaultFillColor, defaultStrokeWidth, shape);
				shapes.add(rect);
				list.updateList();
			}

			shape = null;
			if(selected == null) {
				inspector.clearFields();
			}
		}
	}
}