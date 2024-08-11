package canvas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShapeList extends JPanel{
	private Canvas c;
	private JList<Rectangle> list;
	private JScrollPane scrollPane;
	private DefaultListModel<Rectangle> listModel;
	
	public ShapeList(Canvas c) {
		this.c = c;
		list = new JList<Rectangle>();
		listModel = new DefaultListModel<Rectangle>();
		ArrayList<NamedRectangle> shapes = c.getShapes();
		for (int i = 0; i < shapes.size(); i++)
		{
		    listModel.addElement(shapes.get(i));
		}
		list.setModel(listModel);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(110, 175));;

		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void updateList() {
		listModel.clear();
		ArrayList<NamedRectangle> shapes = c.getShapes();
		for (int i = 0; i < shapes.size(); i++)
		{
		    listModel.addElement(shapes.get(i));
		}
		list.setModel(listModel);
	}
}