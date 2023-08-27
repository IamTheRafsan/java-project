import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class StudentMenu extends JFrame implements MouseListener, ActionListener {
	JLabel heading;
	JButton proceedBtn, backBtn;
	JRadioButton s1, s2, s3;
	ButtonGroup studentMenu1;
	JPanel panel;
	Color myColor;
	Font myFont;
	MainMenu mi;
	AddStudent ai;
	RemoveStudent ri;
	FindStudent fi;

	public StudentMenu() {
		super("Student Menu");
		this.setSize(765, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.mi = mi;
		this.ai = ai;
		this.ri = ri;
		this.fi = fi;

		Color myColor = new Color(93, 226, 168);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Select an option:");
		heading.setBounds(350, 140, 100, 50);
		panel.add(heading);

		s1 = new JRadioButton("Add new Student");
		s1.setBounds(340, 200, 200, 20);
		s1.setOpaque(false);
		panel.add(s1);

		s2 = new JRadioButton("Remove Student");
		s2.setBounds(340, 225, 200, 20);
		s2.setOpaque(false);
		panel.add(s2);

		s3 = new JRadioButton("Find a student");
		s3.setBounds(340, 250, 200, 20);
		s3.setOpaque(false);
		panel.add(s3);

		studentMenu1 = new ButtonGroup();
		studentMenu1.add(s1);
		studentMenu1.add(s2);
		studentMenu1.add(s3);

		proceedBtn = new JButton("Proceed");
		proceedBtn.setBounds(350, 290, 100, 30);
		proceedBtn.addMouseListener(this);
		proceedBtn.addActionListener(this);
		panel.add(proceedBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(350, 330, 100, 30);
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

		if (proceedBtn.getText().equals(command)) {
			if (s1.isSelected()) {
				AddStudent adstu = new AddStudent();
				adstu.setVisible(true);
				this.setVisible(false);
			}
			if (s2.isSelected()) {
				RemoveStudent restu = new RemoveStudent();
				restu.setVisible(true);
				this.setVisible(false);
			}
			if (s3.isSelected()) {
				FindStudent findStu = new FindStudent();
				findStu.setVisible(true);
				this.setVisible(false);
			} else {
			}
		} else if (ae.getSource() == backBtn) {
			MainMenu main = new MainMenu();
			main.setVisible(true);
			this.setVisible(false);
		} else {
		}

	}

}