import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {
	static JLabel label;
	TestPanel t;
    
    public Test() {
    	JFrame f = new JFrame("Test");
        f.getContentPane().setLayout(new BorderLayout());
        
        t = new TestPanel();
        t.setBackground(Color.white);
        f.getContentPane().add("Center", t);
 
        label = new JLabel("Drag rectangle around within the area");
        f.getContentPane().add("South", label);
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(550,250));
		f.setVisible(true);
    }
  
	
	public static void main(String[] args) {
		Test t = new Test();
	}
	
	class TestPanel extends JPanel implements MouseListener {
		private RoundRectangle2D r;
		
		public TestPanel() {
			setBackground(Color.white);
            addMouseListener(this);
		}
		
	    public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        BasicStroke stroke = new BasicStroke();
	        g2.setStroke(stroke);
	        g2.draw(new RoundRectangle2D.Double(10, 40, 100, 50, 10, 10));
	    }
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mouseClicked(MouseEvent e) {
			label.setText("clicked at: " + e.getX() + ", " + e.getY());
			r = new RoundRectangle2D.Double(e.getX(), e.getY(), 1, 1, 10, 10);
		}
		
		public void mouseReleased(MouseEvent e) {
			label.setText("released at: " + e.getX() + ", " + e.getY());
//			System.out.println(r.getX());
//			double newWidth = Math.abs(e.getX() - r.getX());
//			double newHeight = Math.abs(e.getY() - r.getY());
//			r.setRoundRect(r.getX(), r.getY(), newWidth, newHeight, 10, 10);
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
	}
}