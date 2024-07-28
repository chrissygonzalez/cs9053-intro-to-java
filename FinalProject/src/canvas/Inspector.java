package canvas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Inspector extends JPanel {
	private JTextField xField;
	private JTextField yField;
	private JTextField widthField;
	private JTextField heightField;
	private JButton updateButton;
	private Canvas c;
	
	public Inspector() {
		this.setLayout(new GridLayout(5, 1));
		
		JLabel xLabel = new JLabel("x: ");
		xField = new JTextField(5);
		
		JLabel yLabel = new JLabel("y: ");
		yField = new JTextField(5);
		
		JLabel widthLabel = new JLabel("width: ");
		widthField = new JTextField(5);
		
		JLabel heightLabel = new JLabel("height: ");
		heightField = new JTextField(5);
		
		JPanel first = new JPanel();
		first.add(xLabel);
		first.add(xField);
		
		JPanel second = new JPanel();
		second.add(yLabel);
		second.add(yField);
		
		JPanel third = new JPanel();
		third.add(widthLabel);
		third.add(widthField);
		
		JPanel fourth = new JPanel();
		fourth.add(heightLabel);
		fourth.add(heightField);
		
		updateButton = new JButton("Update shape");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSelectedShape();
			}
		});
		
		add(first);
		add(second);
		add(third);
		add(fourth);
		add(updateButton);
	}
	
	public void setCanvas(Canvas c) {
		this.c = c;
	}
	
	public void updateFields(Rectangle r) {
		xField.setText(String.valueOf(r.getX()));
		yField.setText(String.valueOf(r.getY()));
		Dimension size = r.getSize();
		widthField.setText(String.valueOf(size.width));
		heightField.setText(String.valueOf(size.height));
	}
	
	public void clearFields() {
		xField.setText("");
		yField.setText("");
		widthField.setText("");
		heightField.setText("");
	}
	
	public void updateSelectedShape() {
		Double newX = Double.parseDouble(xField.getText());
		Double newY = Double.parseDouble(yField.getText());
		Double newWidth = Double.parseDouble(widthField.getText());
		Double newHeight = Double.parseDouble(heightField.getText());
		
		c.updateShape(newX.intValue(), newY.intValue(), newWidth.intValue(), newHeight.intValue());
	}
}