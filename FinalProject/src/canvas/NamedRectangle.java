package canvas;

import java.awt.Color;
import java.awt.Rectangle;

public class NamedRectangle extends Rectangle {
	final static Color selectedColor = Color.BLUE;
	static int count = 0;
	private String name;
	private Color strokeColor;
	private Color fillColor;
	private float strokeWidth;
	private Rectangle rect;
	private boolean selected;
	
	public NamedRectangle(Color sColor, Color fColor, float strokeWidth, Rectangle r) {
		this.name = "Rectangle " + count++;
		this.strokeColor = sColor;
		this.fillColor = fColor;
		this.strokeWidth = strokeWidth;
		this.rect = r;
		this.selected = false;
	}
	
	public void setStrokeColor(Color c) {
		this.strokeColor = c;
	}
	
	public Color getStrokeColor() {
		if(this.selected) return selectedColor;
		return this.strokeColor;
	}
	
	public void setFillColor(Color c) {
		this.fillColor = c;
	}
	
	public Color getFillColor() {
		return this.fillColor;
	}
	
	public float getStrokeWidth() {
		return this.strokeWidth;
	}
	
	public void setStrokeWidth(float s) {
		this.strokeWidth = s;
	}
	
	public Rectangle getRectangle() {
		return this.rect;
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean s) {
		this.selected = s;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}