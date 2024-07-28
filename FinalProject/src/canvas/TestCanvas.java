package canvas;

import java.awt.BorderLayout;

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
		Canvas c = new Canvas();
		JFrame f = new JFrame("Test Canvas");
		Inspector inspector = new Inspector();
		ShapeList list = new ShapeList(c);
		
		c.setInspector(inspector);
		inspector.setCanvas(c);
		c.setShapeList(list);
		
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.getContentPane().add(c);
		
		JPanel sidePanel = new JPanel();
		sidePanel.add(inspector);
		sidePanel.add(list);
		f.getContentPane().add(sidePanel, BorderLayout.EAST);
		f.setSize(400, 400);
		f.setVisible(true);
	}
}