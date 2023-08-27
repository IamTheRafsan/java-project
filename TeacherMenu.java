import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class TeacherMenu extends JFrame implements MouseListener, ActionListener {
	JLabel heading;
	JButton proceedBtn, backBtn;
	JRadioButton s1, s2, s3;
	ButtonGroup teacherMenu1;
	JPanel panel;
	Color myColor;
	Font myFont;
	MainMenu mi;
	AddTeacher ai;
	RemoveTeacher ri;
	FindTeacher fi;

	public TeacherMenu() {
		super("Teacher Menu");
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

		s1 = new JRadioButton("Add new Teacher");
		s1.setBounds(340, 200, 200, 20);
		s1.setOpaque(false);
		panel.add(s1);

		s2 = new JRadioButton("Remove Teacher");
		s2.setBounds(340, 225, 200, 20);
		s2.setOpaque(false);
		panel.add(s2);

		s3 = new JRadioButton("Find a Teacher");
		s3.setBounds(340, 250, 200, 20);
		s3.setOpaque(false);
		panel.add(s3);

		teacherMenu1 = new ButtonGroup();
		teacherMenu1.add(s1);
		teacherMenu1.add(s2);
		teacherMenu1.add(s3);

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
				AddTeacher adtea = new AddTeacher();
				adtea.setVisible(true);
				this.setVisible(false);
			}
			if (s2.isSelected()) {
				RemoveTeacher retea = new RemoveTeacher();
				retea.setVisible(true);
				this.setVisible(false);
			}
			if (s3.isSelected()) {
				FindTeacher findtea = new FindTeacher();
				findtea.setVisible(true);
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