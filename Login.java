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

public class Login extends JFrame implements MouseListener, ActionListener {
	JLabel heading, idLabel, passLabel;
	JTextField idF;
	JPasswordField passF;
	JButton loginBtn, backBtn, signupBtn;
	JPanel panel;
	Color myColor;
	Font font;

	MainMenu mi;
	Signup si;
	Home hi;

	User user[];

	public Login() {
		super("Login and SignUp");
		this.setSize(765, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		user = new User[100];
		this.hi = hi;

		Color myColor = new Color(93, 226, 168);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Admin Login ");
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
		backBtn.setBounds(335, 330, 80, 30);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(325, 290, 100, 30);
		signupBtn.addMouseListener(this);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);

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
				BufferedReader bufferedrReader = new BufferedReader(new FileReader("user.txt"));
				int totalLine = 0;

				while (bufferedrReader.readLine() != null)
					totalLine++;
				bufferedrReader.close();

				for (int i = 0; i < totalLine; i++) {
					String line1 = Files.readAllLines(Paths.get("user.txt")).get(i + 1);

					if (line1.equals(l1)) {
						String line2 = Files.readAllLines(Paths.get("user.txt")).get(i + 2);
						if (line2.equals(l2)) {
							JOptionPane.showMessageDialog(null, "Login Success");
							MainMenu mk = new MainMenu();
							mk.setVisible(true);
							this.setVisible(false);
							break;
						} else {
						}
					} else {

					}

				}

			} catch (Exception e) {
				showMessageDialog(null, "Invalid Username or password!");
			}

		}

		else if (signupBtn.getText().equals(command)) {
			Signup goToSignup = new Signup();
			goToSignup.setVisible(true);
			this.setVisible(false);
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