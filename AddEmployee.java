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

public class AddEmployee extends JFrame implements MouseListener, ActionListener {
	JLabel headingLabel, nameLabel, idLabel, fatherLabel, motherLabel, designationLabel, educationLabel, salaryLabel;
	JTextField nameF, idF, fatherF, motherF, designationF, educationF, salaryF;
	JButton addBtn, backBtn;
	JPanel panel;
	Color myColor;

	EmployeeMenu em;

	Employee employee[];

	public AddEmployee() {
		super("Add New Employee");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.em = em;

		employee = new Employee[100];
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

		designationLabel = new JLabel("Designation: ");
		designationLabel.setBounds(370, 300, 100, 30);
		panel.add(designationLabel);

		designationF = new JTextField();
		designationF.setBounds(470, 300, 100, 30);
		panel.add(designationF);

		educationLabel = new JLabel("Education: ");
		educationLabel.setBounds(370, 340, 100, 30);
		panel.add(educationLabel);

		educationF = new JTextField();
		educationF.setBounds(470, 340, 100, 30);
		panel.add(educationF);

		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(370, 380, 100, 30);
		panel.add(salaryLabel);

		salaryF = new JTextField();
		salaryF.setBounds(470, 380, 100, 30);
		panel.add(salaryF);

		addBtn = new JButton("ADD");
		addBtn.setBounds(365, 430, 100, 30);
		addBtn.addMouseListener(this);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(490, 430, 100, 30);
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

	public void addEmployee(Employee e1) {
		int flag = 0;
		for (int i = 0; i < employee.length; i++) {
			if (employee[i] == null) {
				employee[i] = e1;
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
			String u5 = designationF.getText();
			String u6 = educationF.getText();
			String u7 = salaryF.getText();

			/*
			 * if (t1.isSelected()) {
			 * u8 = t1.getText();
			 * } else if (t2.isSelected()) {
			 * u8 = t2.getText();
			 * } else if (t3.isSelected()) {
			 * u8 = t3.getText();
			 * } else {
			 * }
			 */

			if (u1.equals("") || u2.equals("") || u3.equals("") || u4.equals("") || u5.equals("") || u6.equals("")
					|| u7.equals("")) {
				showMessageDialog(null, "Employee insertion failed!");

			}

			else {
				Employee e1 = new Employee();
				e1.setName(u1);
				e1.setId(u2);
				e1.setFather(u3);
				e1.setMother(u4);
				e1.setDesignation(u5);
				e1.setEducation(u6);
				e1.setSalary(u7);

				addEmployee(e1);
				//showMessageDialog(null, "Employee Added!");
				try {
					FileWriter fileWriter = new FileWriter("Employeeinfo.txt", true);
					fileWriter.write(nameF.getText() + "\n");
					fileWriter.write(idF.getText() + "\n");
					fileWriter.write(fatherF.getText() + "\n");
					fileWriter.write(motherF.getText() + "\n");
					fileWriter.write(designationF.getText() + "\n");
					fileWriter.write(educationF.getText() + "\n");
					fileWriter.write(salaryF.getText() + "\n");
					fileWriter.close();
					JOptionPane.showMessageDialog(null, "Employee Added!!");

				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Employee Addition failed");
				}

			}
		}

		else if (backBtn.getText().equals(command)) {
			EmployeeMenu xk = new EmployeeMenu();
			xk.setVisible(true);
			this.setVisible(false);
		} else {
		}
	}

	// rem

	public void removeEmployee(Employee e1) {
		for (int i = 0; i < employee.length; i++) {
			int flag = 0;
			if (employee[i].getName().equals(e1)) {
				employee[i] = null;
				flag = 1;
				break;
			} else {
			}
		}

	}

	public Employee getEmployee(String id) {
		Employee e1 = null;
		for (int i = 0; i < employee.length; i++) {
			if (employee[i] != null) {
				if (employee[i].getId().equals(id)) {
					e1 = employee[i];
					break;
				}
			}
		}
		return e1;
	}

}