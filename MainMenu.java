import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class MainMenu extends JFrame implements MouseListener,ActionListener
{
	JLabel heading;
	JButton proceedBtn,backBtn;
	JRadioButton m1, m2, m3;
	ButtonGroup mainMenu1;
	JPanel panel;
	Color myColor;
	Font myFont;
	Login li;
	StudentMenu si;


	public MainMenu()
	{
		super("Main Menu");
		this.setSize(765,490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.li=li;

		myColor = new Color(93,226,168);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

		heading = new JLabel("Select an option:");
		heading.setBounds(350,140,100,50);
		panel.add(heading);

		m1 = new JRadioButton("Student");
		m1.setBounds(350,200,100,20);
		m1.setOpaque(false);
		panel.add(m1);

		m2 = new JRadioButton("Teacher");
		m2.setBounds(350,220,100,20);
		m2.setOpaque(false);
		panel.add(m2);

		m3 = new JRadioButton("Employee");
		m3.setBounds(350,240,100,20);
		m3.setOpaque(false);
		panel.add(m3);

		mainMenu1 = new ButtonGroup();
		mainMenu1.add(m1);
		mainMenu1.add(m2);
		mainMenu1.add(m3);

		proceedBtn = new JButton("Proceed");
		proceedBtn.setBounds(340, 280, 100, 30);
		proceedBtn.addMouseListener(this);
		proceedBtn.addActionListener(this);
		panel.add(proceedBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(340, 320, 100, 30);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		this.add(panel);
	}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();


		if(proceedBtn.getText().equals(command))
		{
			if(m1.isSelected())
			{
				StudentMenu sk = new StudentMenu();
				sk.setVisible(true);
				this.setVisible(false);
			}
			if(m2.isSelected())
			{
				TeacherMenu tk = new TeacherMenu();
				tk.setVisible(true);
				this.setVisible(false);
			}
			if(m3.isSelected())
			{
				EmployeeMenu ek = new EmployeeMenu();
				ek.setVisible(true);
				this.setVisible(false);
			}
			else{}
		}
		else if(ae.getSource()==backBtn){
			Login logIn = new Login();
			logIn.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}

	public static void main(String[] args) {

		MainMenu home = new MainMenu();
		home.setVisible(true);
	}

}