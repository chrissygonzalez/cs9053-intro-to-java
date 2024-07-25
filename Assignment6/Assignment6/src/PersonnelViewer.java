import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import personnel.*;

public class PersonnelViewer extends JFrame {
	private ArrayList<Person> personnelList;
	private JComboBox<Person> jComboBox;
	private JFileChooser jFileChooser;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel idLabel;
	private JTextField idField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JLabel genderLabel;
	private JTextField genderField;
	private JButton updateButton;
	private Person selectedPerson;
	
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 200;
	
	public PersonnelViewer() {	
		personnelList = new ArrayList<Person>();
		jFileChooser = new JFileChooser(".");
		createPanel();
		
		JMenuBar menuBar = new JMenuBar();     
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
	      
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void addComboItems() {
		jComboBox.removeAllItems();
		for(Person p : personnelList) {
			jComboBox.addItem(p);
		}
	}
	
	public void setSelectedPerson() {
		if(jComboBox.getItemCount() > 0) {
			selectedPerson = (Person) jComboBox.getSelectedItem();
			idField.setText(Integer.toString(selectedPerson.getId()));;
			nameField.setText(selectedPerson.getName());
			ageField.setText(Integer.toString(selectedPerson.getAge()));
			genderField.setText(String.valueOf(selectedPerson.getGender()));
		}
	}
	
	// Create Menu and MenuItems
	public JMenuItem createFileExitItem(){
		JMenuItem item = new JMenuItem("Exit");      
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				System.exit(0);
	         }
		}      
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}

	public JMenuItem createFileOpenItem() {
		JMenuItem item = new JMenuItem("Open");
		item.addActionListener(new OpenFileListener());
		return item;
	}
	
	public JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		menu.add(createFileOpenItem());
		menu.add(createFileExitItem());
		return menu;
	}

	// Create Fields and Panel
	public JPanel createComboBox() {
		jComboBox = new JComboBox<Person>();
		jComboBox.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				setSelectedPerson();
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(jComboBox);
		return panel;
	}
	
	public JPanel createNameField() {
		nameLabel = new JLabel("Name");
		nameField = new JTextField(25);
	    
	    JPanel panel = new JPanel();
	    panel.add(nameLabel);
	    panel.add(nameField);
	    return panel;
	}
	
	public JPanel createTextFields() {	    
		final int FIELD_WIDTH = 3;
		idLabel = new JLabel("Id");
		idField = new JTextField(FIELD_WIDTH);
		idField.setEditable(false);
		
		ageLabel = new JLabel("Age");
		ageField = new JTextField(FIELD_WIDTH);
		
		genderLabel = new JLabel("Gender");
		genderField = new JTextField(FIELD_WIDTH);
		
		JPanel lPanel = new JPanel();
		lPanel.add(idLabel);
		lPanel.add(idField);
		
		JPanel cPanel = new JPanel();
		cPanel.add(ageLabel);
		cPanel.add(ageField);
		
		JPanel rPanel = new JPanel();
		rPanel.add(genderLabel);
		rPanel.add(genderField);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		panel.add(lPanel);
		panel.add(cPanel);
		panel.add(rPanel);
		return panel;
	}
	
	public JPanel createUpdateButton() {
		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				try {
					selectedPerson.setName(nameField.getText());
					selectedPerson.setAge(Integer.parseInt(ageField.getText()));
					selectedPerson.setGender(genderField.getText().charAt(0));
					setSelectedPerson();
					jComboBox.repaint();
				} catch(NumberFormatException err) {
					ageField.setText(Integer.toString(selectedPerson.getAge()));
					System.out.println("NumberFormatException: " + err.getMessage());
				} catch(StringIndexOutOfBoundsException err) {
					genderField.setText(String.valueOf(selectedPerson.getGender()));
					System.out.println("NumberFormatException: " + err.getMessage());
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(updateButton);
		return panel;
	}
	
    public void createPanel(){
    	JPanel comboBox = createComboBox();
    	JPanel nameField = createNameField();
    	JPanel textFields = createTextFields();
    	JPanel updateButton = createUpdateButton();
    	
    	JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    	centerPanel.add(nameField);
    	centerPanel.add(textFields);
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(new BorderLayout());
      
    	panel.add(comboBox, BorderLayout.NORTH);
    	panel.add(centerPanel, BorderLayout.CENTER);
    	panel.add(updateButton, BorderLayout.SOUTH);
    	add(panel);
    }
	
	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					personnelList.clear();
					selectedPerson = null;
					InputStream fIn = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					InputStreamReader read = new InputStreamReader(fIn);
					BufferedReader in = new BufferedReader(read);
					String ln = in.readLine();

					while (ln != null) {
						Person person = ReadPersonFile.createPerson(ln);
						personnelList.add(person);
						ln = in.readLine();
					}
					in.close();
					addComboItems();
				} catch (IOException error){
					error.printStackTrace();
				} catch (PersonException error) {
					error.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PersonnelViewer pv = new PersonnelViewer();
		pv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pv.setVisible(true);
	}
	
}
