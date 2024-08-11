package canvas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestCanvas {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createOuterContainer();
			}
		});
	}
	
	private static void createOuterContainer() {
		// instead of connecting everything together here, let the JFrame listen
		// to the Mouse events and, if source is the canvas JPanel, do things
		JFrame f = new JFrame("Test Canvas");
		f.addPropertyChangeListener(new MyListener());
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// Shapes and selection come from Canvas
		Canvas c = new Canvas();
		Inspector inspector = new Inspector();
		ShapeList list = new ShapeList(c);
		c.setInspector(inspector);
		inspector.setCanvas(c);
		c.setShapeList(list);
		
		JPanel sidePanel = new JPanel(new GridLayout(2, 1));
		sidePanel.add(inspector);
		sidePanel.add(list);
		f.getContentPane().add(c, BorderLayout.CENTER);
		f.getContentPane().add(sidePanel, BorderLayout.EAST);
		f.setSize(400, 400);
		f.setVisible(true);
	}
	
	static class MyListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getPropertyName());
		}
		
	}
}