package canvas;

import java.awt.Color;
import java.awt.Rectangle;

public class NamedRectangle extends Rectangle {
	static int count = 0;
	private String name;
	private Color strokeColor;
	private Rectangle rect;
	
	public NamedRectangle(Color c, Rectangle r) {
		this.name = "Rectangle " + count++;
		this.strokeColor = c;
		this.rect = r;
	}
	
	public void setStrokeColor(Color c) {
		this.strokeColor = c;
	}
	
	public Color getStrokeColor() {
		return this.strokeColor;
	}
	
	public Rectangle getRectangle() {
		return this.rect;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}