import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class StudentLogin extends JFrame implements MouseListener, ActionListener {
	JLabel heading, idLabel, passLabel;
	JTextField idF;
	JPasswordField passF;
	JButton loginBtn, backBtn;
	JPanel panel;
	Color myColor;
	Font font;

	Home hi;

	public StudentLogin() {
		super("Student Login");
		this.setSize(765, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.hi = hi;

		Color myColor = new Color(93, 226, 168);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Student Login ");
		heading.setBounds(335, 80, 160, 30);
		heading.setBackground(Color.cyan);
		panel.add(heading);

		idLabel = new JLabel("id: ");
		idLabel.setBounds(270, 150, 160, 30);
		idLabel.setBackground(Color.BLACK);
		panel.add(idLabel);

		idF = new JTextField();
		idF.setBounds(370, 150, 100, 30);
		panel.add(idF);

		passLabel = new JLabel("Password: ");
		passLabel.setBounds(270, 190, 100, 30);
		panel.add(passLabel);

		passF = new JPasswordField();
		passF.setBounds(370, 190, 100, 30);
		panel.add(passF);

		loginBtn = new JButton("Login");
		loginBtn.setBounds(335, 250, 80, 30);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(335, 290, 80, 30);
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

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (loginBtn.getText().equals(command)) {
			String l1 = idF.getText().toString();
			String l2 = passF.getText().toString();

			try {
				BufferedReader bufferedrReader = new BufferedReader(new FileReader("student.txt"));
				int totalLine = 0;

				while (bufferedrReader.readLine() != null)
					totalLine++;
				bufferedrReader.close();

				for (int i = 0; i < totalLine; i++) {
					String line1 = Files.readAllLines(Paths.get("student.txt")).get(i);
					if (line1.equals(l1)) {
						String line2 = Files.readAllLines(Paths.get("student.txt")).get(i + 1);
						if (line2.equals(l2)) 
						{
							JOptionPane.showMessageDialog(null, "Login Success");


							try {
								BufferedReader bufferedrReaderk = new BufferedReader(new FileReader("studentinfo.txt"));
								int totalLinek = 0;
				
								while (bufferedrReaderk.readLine() != null)
									totalLinek++;
								bufferedrReaderk.close();
				
								for (int j = 0; j < totalLinek; j++) {
									String line4 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j+1);
									if (line4.equals(l1)) {
										
				
				
											
				
				
											String line3 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j);
											//String line4 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j + 1);
											String line5 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j + 2);
											String line6 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j + 3);
											String line7 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j + 4);
											String line8 = Files.readAllLines(Paths.get("studentinfo.txt")).get(j + 5);
											JOptionPane.showMessageDialog(null,
													"Name: " + line3 + "\nID: " + line4 + "\nCGPA: " + line7 + "\nSession: " +
															line8);
											break;
												
										}
				
									
				
								}
				
							} catch (Exception e) {
								showMessageDialog(null, "Invalid Username or password!");
							}
				


							//String line3 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i);
							//String line4 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i + 1);
							//String line5 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i + 2);
							//String line6 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i + 3);
							//String line7 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i + 4);
							//String line8 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i + 5);
							//JOptionPane.showMessageDialog(null,
							//		"Name: " + line3 + "\nID: " + line4 + "\nCGPA: " + line7 + "\nSession: " +
							//				line8);
							//break;
								
						}

					}

				}

			} catch (Exception e) {
				showMessageDialog(null, "Invalid Username or password!");
			}

		}

		else if (backBtn.getText().equals(command)) {
			Home hom = new Home();
			hom.setVisible(true);
			this.setVisible(false);
		}

		else {
		}
	}

}