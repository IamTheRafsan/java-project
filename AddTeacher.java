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

public class AddTeacher extends JFrame implements MouseListener, ActionListener {
	JLabel headingLabel, nameLabel, idLabel, fatherLabel, motherLabel, departmentLabel, educationLabel, salaryLabel;
	JTextField nameF, idF, fatherF, motherF, departmentF, educationF, salaryF;
	JButton addBtn, backBtn;
	JRadioButton t1, t2, t3;
	ButtonGroup courseGrp;
	JPanel panel;
	Color myColor;

	TeacherMenu te;


	Teacher teacher[];

	public AddTeacher() {
		super("Add New Teacher");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.te = te;

		teacher = new Teacher[100];
		Color myColor = new Color(93,226,168);

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

		departmentLabel = new JLabel("Department: ");
		departmentLabel.setBounds(370, 300, 100, 30);
		panel.add(departmentLabel);

		t1 = new JRadioButton("FST");
		t1.setBounds(470, 300, 100, 20);
		t1.setOpaque(false);
		panel.add(t1);

		t2 = new JRadioButton("FE");
		t2.setBounds(470, 330, 100, 20);
		t2.setOpaque(false);
		panel.add(t2);

		t3 = new JRadioButton("FBA");
		t3.setBounds(470, 360, 100, 20);
		t3.setOpaque(false);
		panel.add(t3);

		courseGrp = new ButtonGroup();
		courseGrp.add(t1);
		courseGrp.add(t2);
		courseGrp.add(t3);

		educationLabel = new JLabel("Education: ");
		educationLabel.setBounds(370, 400, 100, 30);
		panel.add(educationLabel);

		educationF = new JTextField();
		educationF.setBounds(470, 400, 100, 30);
		panel.add(educationF);

        salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(370, 440, 100, 30);
		panel.add(salaryLabel);

		salaryF = new JTextField();
		salaryF.setBounds(470, 440, 100, 30);
		panel.add(salaryF);

		addBtn = new JButton("ADD");
		addBtn.setBounds(365, 530, 100, 30);
		addBtn.addMouseListener(this);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(490, 530, 100, 30);
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

	public void addTeacher(Teacher t) {
		int flag = 0;
		for (int i = 0; i < teacher.length; i++) {
			if (teacher[i] == null) {
				teacher[i] = t;
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
			String u5 = educationF.getText();
            String u6 = salaryF.getText();
			String u7 = "";

			if (t1.isSelected()) {
				u7 = t1.getText();
			} else if (t2.isSelected()) {
				u7 = t2.getText();
			} else if (t3.isSelected()) {
				u7 = t3.getText();
			} else {
			}

			if (u1.equals("") || u2.equals("")|| u3.equals("") || u4.equals("") || u5.equals("") || u6.equals("") || u7.equals("")) {
				showMessageDialog(null, "Teacher insertion failed!");

			}

			else {
				Teacher t = new Teacher();
				t.setName(u1);
				t.setId(u2);
				t.setFather(u3);
				t.setMother(u4);
				t.setEducation(u5);
                t.setSalary(u6);
				t.setDepartment(u7);

				addTeacher(t);
				//showMessageDialog(null, "Teacher Added!");
				try {
					FileWriter fileWriter = new FileWriter("Teacherinfo.txt", true);
					fileWriter.write(nameF.getText() + "\n");
					fileWriter.write(idF.getText() + "\n");
					fileWriter.write(fatherF.getText() + "\n");
					fileWriter.write(motherF.getText() + "\n");
					fileWriter.write(educationF.getText() + "\n");
                    fileWriter.write(salaryF.getText() + "\n");
					fileWriter.close();
					JOptionPane.showMessageDialog(null, "Teacher Added!!");

				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Teacher Addition failed");
				}

			}
		}

		else if (backBtn.getText().equals(command)) {
			TeacherMenu xk = new TeacherMenu();
			xk.setVisible(true);
			this.setVisible(false);
		} else {
		}
	}

	// rem

	public void removeTeacher(Teacher t) {
		for (int i = 0; i < teacher.length; i++) {
			int flag = 0;
			if (teacher[i].getName().equals(t)) {
				teacher[i] = null;
				flag = 1;
				break;
			} else {
			}
		}

	}

	public Teacher getTeacher(String id) {
		Teacher t = null;
		for (int i = 0; i < teacher.length; i++) {
			if (teacher[i] != null) {
				if (teacher[i].getId().equals(id)) {
					t = teacher[i];
					break;
				}
			}
		}
		return t;
	}

}