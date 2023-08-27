import java.lang.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddStudent extends JFrame implements MouseListener, ActionListener {
	JLabel headingLabel, nameLabel, idLabel, fatherLabel, motherLabel, courseLabel, cgpaLabel, sessionLabel;
	JTextField nameF, idF, fatherF, motherF, cgpaF, sessionF;
	JButton addBtn, backBtn;
	JRadioButton s1, s2, s3;
	ButtonGroup courseGrp;
	Student s;
	JPanel panel;
	Color myColor;

	StudentMenu si;
	RemoveStudent ri;

	Student student[];

	public AddStudent() {
		super("Add New Student");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.si = si;

		student = new Student[100];
		Color myColor = new Color(93, 226, 168);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		headingLabel = new JLabel("Put all the information:");
		headingLabel.setBounds(395, 80, 300, 30);
		panel.add(headingLabel);

		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(370, 140, 100, 30);
		panel.add(nameLabel);

		nameF = new JTextField();
		nameF.setBounds(470, 140, 100, 30);
		panel.add(nameF);

		idLabel = new JLabel("Id: ");
		idLabel.setBounds(370, 180, 100, 30);
		panel.add(idLabel);

		idF = new JTextField();
		idF.setBounds(470, 180, 100, 30);
		panel.add(idF);

		fatherLabel = new JLabel("Father: ");
		fatherLabel.setBounds(370, 220, 100, 30);
		panel.add(fatherLabel);

		fatherF = new JTextField();
		fatherF.setBounds(470, 220, 100, 30);
		panel.add(fatherF);

		motherLabel = new JLabel("Mother: ");
		motherLabel.setBounds(370, 260, 100, 30);
		panel.add(motherLabel);

		motherF = new JTextField();
		motherF.setBounds(470, 260, 100, 30);
		panel.add(motherF);

		courseLabel = new JLabel("Course: ");
		courseLabel.setBounds(370, 300, 100, 30);
		panel.add(courseLabel);

		s1 = new JRadioButton("CSE");
		s1.setBounds(470, 300, 100, 20);
		s1.setOpaque(false);
		panel.add(s1);

		s2 = new JRadioButton("EEE");
		s2.setBounds(470, 330, 100, 20);
		s2.setOpaque(false);
		panel.add(s2);

		s3 = new JRadioButton("IPE");
		s3.setBounds(470, 360, 100, 20);
		s3.setOpaque(false);
		panel.add(s3);

		courseGrp = new ButtonGroup();
		courseGrp.add(s1);
		courseGrp.add(s2);
		courseGrp.add(s3);

		cgpaLabel = new JLabel("Cgpa: ");
		cgpaLabel.setBounds(370, 400, 100, 20);
		panel.add(cgpaLabel);

		cgpaF = new JTextField();
		cgpaF.setBounds(470, 400, 100, 30);
		panel.add(cgpaF);

		sessionLabel = new JLabel("Session: ");
		sessionLabel.setBounds(370, 440, 100, 20);
		panel.add(sessionLabel);

		sessionF = new JTextField();
		sessionF.setBounds(470, 440, 100, 30);
		panel.add(sessionF);

		addBtn = new JButton("ADD");
		addBtn.setBounds(365, 490, 100, 30);
		addBtn.addMouseListener(this);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(475, 490, 100, 30);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		this.add(panel);
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	public void addStudent(Student s) {
		int flag = 0;
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {
				student[i] = s;
				flag = 1;
				break;
			}
		}

	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (addBtn.getText().equals(command)) {
			String u1 = nameF.getText();
			String u2 = idF.getText();
			String u3 = fatherF.getText();
			String u4 = motherF.getText();
			String u5 = cgpaF.getText();
			String u6 = sessionF.getText();
			String u7 = "";

			if (s1.isSelected()) {
				u7 = s1.getText();
			} else if (s2.isSelected()) {
				u7 = s2.getText();
			} else if (s3.isSelected()) {
				u7 = s3.getText();
			} else {
			}

			if (u1.equals("") || u2.equals("") || u3.equals("") || u4.equals("") || u5.equals("") || u6.equals("")
					|| u7.equals("")) {
				showMessageDialog(null, "Student insertion failed!");

			}

			else {
				Student s = new Student();
				s.setName(u1);
				s.setId(u2);
				s.setFather(u3);
				s.setMother(u4);
				s.setCgpa(u5);
				s.setSession(u6);
				s.setCourse(u7);

				addStudent(s);
				//showMessageDialog(null, "Student Added!");
				try {
					FileWriter fileWriter = new FileWriter("studentinfo.txt", true);
					fileWriter.write(nameF.getText() + "\n");
					fileWriter.write(idF.getText() + "\n");
					fileWriter.write(fatherF.getText() + "\n");
					fileWriter.write(motherF.getText() + "\n");
					fileWriter.write(cgpaF.getText() + "\n");
					fileWriter.write(sessionF.getText() + "\n");
					fileWriter.close();
					JOptionPane.showMessageDialog(null, "Student Added!!");

				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Student Addition failed");
				}

			}
		}

		else if (backBtn.getText().equals(command)) {
			StudentMenu xk = new StudentMenu();
			xk.setVisible(true);
			this.setVisible(false);
		} else {
		}
	}

	// rem

	public void removeStudent(Student s) {
		for (int i = 0; i < student.length; i++) {
			int flag = 0;
			if (student[i].getName().equals(s)) {
				student[i] = null;
				flag = 1;
				break;
			} else {
			}
		}

	}

	public Student getStudent(String id) {
		Student s = null;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null) {
				if (student[i].getId().equals(id)) {
					s = student[i];
					break;
				}
			}
		}
		return s;
	}

}