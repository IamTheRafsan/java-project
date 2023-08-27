import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class EmployeeMenu extends JFrame implements MouseListener, ActionListener {
	JLabel heading;
	JButton proceedBtn, backBtn;
	JRadioButton s1, s2, s3;
	ButtonGroup employeeMenu1;
	JPanel panel;
	Color myColor;
	Font myFont;
	MainMenu mi;
	AddEmployee ai;
	RemoveEmployee ri;
	FindEmployee fi;

	public EmployeeMenu() {
		super("Employee Menu");
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

		s1 = new JRadioButton("Add new Employee");
		s1.setBounds(340, 200, 200, 20);
		s1.setOpaque(false);
		panel.add(s1);

		s2 = new JRadioButton("Remove Employee");
		s2.setBounds(340, 225, 200, 20);
		s2.setOpaque(false);
		panel.add(s2);

		s3 = new JRadioButton("Find an Employee");
		s3.setBounds(340, 250, 200, 20);
		s3.setOpaque(false);
		panel.add(s3);

		employeeMenu1 = new ButtonGroup();
		employeeMenu1.add(s1);
		employeeMenu1.add(s2);
		employeeMenu1.add(s3);

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
				AddEmployee adem = new AddEmployee();
				adem.setVisible(true);
				this.setVisible(false);
			}
			if (s2.isSelected()) {
				RemoveEmployee reEm = new RemoveEmployee();
				reEm.setVisible(true);
				this.setVisible(false);
			}
			if (s3.isSelected()) {
				FindEmployee findEm = new FindEmployee();
				findEm.setVisible(true);
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