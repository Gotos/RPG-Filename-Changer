package com.github.gotos.rpgfilenamechanger;

import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


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
	private JLabel jLabelProject = null;
	private JLabel jLabelOld = null;
	private JLabel jLabelNew = null;
	private JTextField jTextFieldProject = null;
	private JTextField jTextFieldOld = null;
	private JTextField jTextFieldNew = null;
	private JButton jButtonRun = null;
	
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
			jLabelProject  = new JLabel();
			jLabelProject.setBounds(new Rectangle(10, 10, 75, 20));
			jLabelProject.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jLabelProject.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelProject.setText("Project:");

			jLabelOld  = new JLabel();
			jLabelOld.setBounds(new Rectangle(10, 30, 75, 20));
			jLabelOld.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jLabelOld.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelOld.setText("Oldname:");
			jLabelNew  = new JLabel();
			jLabelNew.setBounds(new Rectangle(10, 50, 75, 20));
			jLabelNew.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jLabelNew.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNew.setText("Newname:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelProject, null);
			jContentPane.add(jLabelOld, null);
			jContentPane.add(jLabelNew, null);
			jContentPane.add(getJTextFieldProject(), null);
			jContentPane.add(getJTextFieldOld(), null);
			jContentPane.add(getJTextFieldNew(), null);
			jContentPane.add(getJButtonRun(), null);
	}
		return jContentPane;
	}
	
	private JTextField getJTextFieldProject() {
		if (jTextFieldProject == null) {
			jTextFieldProject = new JTextField();
			jTextFieldProject.setBounds(new Rectangle(105, 10, 175, 20));
			jTextFieldProject.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextFieldProject;
	}

	private JTextField getJTextFieldOld() {
		if (jTextFieldOld == null) {
			jTextFieldOld = new JTextField();
			jTextFieldOld.setBounds(new Rectangle(105, 30, 175, 20));
			jTextFieldOld.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextFieldOld;
	}
	
	private JTextField getJTextFieldNew() {
		if (jTextFieldNew == null) {
			jTextFieldNew = new JTextField();
			jTextFieldNew.setBounds(new Rectangle(105, 50, 175, 20));
			jTextFieldNew.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return jTextFieldNew;
	}
	
	private JButton getJButtonRun() {
		if (jButtonRun == null) {
			jButtonRun = new JButton();
			jButtonRun.setBounds(new Rectangle(115, 80, 70, 35));
			jButtonRun.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jButtonRun.setText("Run");
			jButtonRun.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Main.run(jTextFieldProject.getText(), jTextFieldOld.getText(), jTextFieldNew.getText());
				}
			});
		}
		return jButtonRun;
	}
	
	/**
	 * @param args Args
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
