import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class Signup extends JFrame implements ActionListener, MouseListener {
	JLabel heading, nameLabel, idLabel, passLabel, test, success;
	JTextField nameF, idF;
	JPasswordField passF;
	JButton regBtn, backBtn;
	Color myColor;
	JPanel panel;
	Login Li;
	FileWriter fileWriter;

	User useri[];

	public Signup() {
		super("Sign up");
		this.setSize(765, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.Li = Li;

		useri = new User[5];
		Color myColor = new Color(93,226,168);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Register");
		heading.setBounds(335, 80, 160, 30);
		panel.add(heading);

		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(270, 150, 160, 30);
		panel.add(nameLabel);

		nameF = new JTextField();
		nameF.setBounds(370, 150, 100, 30);
		panel.add(nameF);

		idLabel = new JLabel("Id: ");
		idLabel.setBounds(270, 190, 160, 30);
		panel.add(idLabel);

		idF = new JTextField();
		idF.setBounds(370, 190, 100, 30);
		panel.add(idF);

		passLabel = new JLabel("Password: ");
		passLabel.setBounds(270, 230, 100, 30);
		panel.add(passLabel);

		passF = new JPasswordField();
		passF.setBounds(370, 230, 100, 30);
		panel.add(passF);

		regBtn = new JButton("Register");
		regBtn.setBounds(275, 280, 100, 30);
		regBtn.addMouseListener(this);
		regBtn.addActionListener(this);
		panel.add(regBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(380, 280, 80, 30);
		// backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		success = new JLabel("");
		success.setBounds(150, 260, 120, 30);
		panel.add(success);

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

	public void insertUser(User u) {
		int flag = 0;
		for (int i = 0; i < useri.length; i++) {
			if (useri[i] == null) {
				useri[i] = u;
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			showMessageDialog(null, "User Inserted!");
		} else {
			showMessageDialog(null, "User insertion failed!");
		}

	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		String u1 = nameF.getText();
		String u2 = idF.getText();
		String u3 = passF.getText();

		if (ae.getSource() == regBtn) {
			if (u1.equals("") || u2.equals("") || u3.equals("")) {
				showMessageDialog(null, "Account creation failed!");

			} else {
				User u = new User();
				u.setName(u1);
				u.setId(u2);
				u.setPassword(u3);

				insertUser(u);
				showMessageDialog(null, "Account has been created!");
			}
			try {
				FileWriter fileWriter = new FileWriter("user.txt", true);
				fileWriter.write(nameF.getText() + "\n");
				fileWriter.write(idF.getText() + "\n");
				fileWriter.write(passF.getText() + "\n");
				fileWriter.close();
				JOptionPane.showMessageDialog(null, "File Writen");

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error found");
			}

		}

		if (backBtn.getText().equals(command)) {
			Login lf = new Login();
			lf.setVisible(true);
			this.setVisible(false);
		} else {
		}
	}

}

/*
 * try {
 * File file = new File(".\\Data\\addstudent.txt");
 * if(!file.exists()){
 * file.createNewFile();
 * }
 * FileWriter fileWriter =new FileWriter(file,true);
 * BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
 * PrintWriter printWriter = new PrintWriter(bufferedWriter);
 * 
 * printWriter.println("Name : "+nameF.getText());
 * printWriter.println("ID : "+idF.getText());
 * printWriter.println("Father Name : "+fatherF.getText());
 * printWriter.println("Moher Name : "+motherF.getText());
 * printWriter.println("CGPA : "+cgpaF.getText());
 * //printWriter.println("Course : "+u7);
 * printWriter.close();
 * 
 * 
 * } catch (Exception e) {
 * System.out.println(e);
 * }
 */