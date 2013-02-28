package com.github.gotos.rpgfilenamechanger;

import java.awt.ComponentOrientation;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


/**
 * Simple GUI for the RPGFileNameChanger
 * 
 * @author alina
 *
 */
public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5540946949748987474L;

	private JPanel jContentPane = null;
	private JLabel jLabel_Project = null;
	private JLabel jLabel_old = null;
	private JLabel jLabel_new = null;
	private JTextField jTextField_Project = null;
	private JTextField jTextField_old = null;
	private JTextField jTextField_new = null;
	
	/**
	 * This is the default constructor
	 */
	public GUI() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 150);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setTitle("RPGFileNameChanger");
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_Project  = new JLabel();
			jLabel_Project.setBounds(new Rectangle(10, 10, 75, 20));
			jLabel_Project.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jLabel_Project.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_Project.setText("Project:");

			jLabel_old  = new JLabel();
			jLabel_old.setBounds(new Rectangle(10, 30, 75, 20));
			jLabel_old.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jLabel_old.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_old.setText("Oldname:");
			jLabel_new  = new JLabel();
			jLabel_new.setBounds(new Rectangle(10, 50, 75, 20));
			jLabel_new.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jLabel_new.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_new.setText("Newname:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel_Project, null);
			jContentPane.add(jLabel_old, null);
			jContentPane.add(jLabel_new, null);
			jContentPane.add(getJTextField_Project(), null);
			jContentPane.add(getJTextField_old(), null);
			jContentPane.add(getJTextField_new(), null);
	}
		return jContentPane;
	}
	
	private JTextField getJTextField_Project() {
		if (jTextField_Project == null) {
			jTextField_Project = new JTextField();
			jTextField_Project.setBounds(new Rectangle(105, 10, 175, 20));
			jTextField_Project.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextField_Project;
	}

	private JTextField getJTextField_old() {
		if (jTextField_old == null) {
			jTextField_old = new JTextField();
			jTextField_old.setBounds(new Rectangle(105, 30, 175, 20));
			jTextField_old.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextField_old;
	}
	
	private JTextField getJTextField_new() {
		if (jTextField_new == null) {
			jTextField_new = new JTextField();
			jTextField_new.setBounds(new Rectangle(105, 50, 175, 20));
			jTextField_new.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextField_new;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI thisClass = new GUI();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
	
}
