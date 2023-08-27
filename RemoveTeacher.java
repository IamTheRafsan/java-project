import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import static javax.swing.JOptionPane.showMessageDialog;

public class RemoveTeacher extends JFrame implements MouseListener, ActionListener {
	JLabel headingLabel, nameLabel, idLabel;
	JTextField nameF, idF;
	JButton removeBtn, backBtn;
	JPanel panel;
	Color myColor;
	Font myFont;
	TeacherMenu te;
	AddTeacher ai;
	Teacher t;

	Teacher teacher[];

	public RemoveTeacher() {
		super("Remove a Teacher");
		this.setSize(765, 490);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		teacher = new Teacher[100];

		Color myColor = new Color(93, 226, 168);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        headingLabel = new JLabel("Put the information:");
        headingLabel.setBounds(315, 80, 300, 30);
        panel.add(headingLabel);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(270, 150, 100, 30);
        panel.add(nameLabel);

        nameF = new JTextField();
        nameF.setBounds(370, 150, 100, 30);
        panel.add(nameF);

        idLabel = new JLabel("Id: ");
        idLabel.setBounds(270, 190, 100, 30);
        panel.add(idLabel);

        idF = new JTextField();
        idF.setBounds(370, 190, 100, 30);
        panel.add(idF);

        removeBtn = new JButton("Find");
        removeBtn.setBounds(270, 230, 100, 30);
        removeBtn.addMouseListener(this);
        removeBtn.addActionListener(this);
        panel.add(removeBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(385, 230, 100, 30);
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
    
    

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		if (removeBtn.getText().equals(command)) {
			String u1 = nameF.getText();
			String u2 = idF.getText();

			try {
				BufferedReader bufferedrReader = new BufferedReader(new FileReader("Teacherinfo.txt"));

				int totalLine = 0;

				while (bufferedrReader.readLine() != null)
					totalLine++;
				bufferedrReader.close();

				for (int i = 0; i < totalLine; i++) {
					String line1 = Files.readAllLines(Paths.get("Teacherinfo.txt")).get(i);

					if (line1.equals(u1)) {
						String line2 = Files.readAllLines(Paths.get("Teacherinfo.txt")).get(i + 1);
						if (line2.equals(u2)) {
							JOptionPane.showMessageDialog(null, "Removed Successfully");
							break;

						}
					}
				}

			} catch (Exception e) {
				showMessageDialog(null, "remove unsucessful!");
			}

			/*
			 * for(int i=0;i<student.length;i++)
			 * {
			 * if(u1.equals(student[i].name) && u2.equals(student[i].id))
			 * {
			 * //removeStudent(getStudent(u2));
			 * showMessageDialog(null, "Login Sucessful!");
			 * }
			 * else{showMessageDialog(null, "Invalid Username or password!");}
			 * }
			 */

			/*
			 * if(u1.equals("") || u2.equals(""))
			 * {
			 * showMessageDialog(null, "Student removal failed!");
			 * 
			 * }
			 * else if(u1.equals(student[i].name) && u2.equals(student[i].id))
			 * {
			 * //removeStudent(getStudent(u2));
			 * showMessageDialog(null, "Student Removed!");
			 * 
			 * }
			 * else{showMessageDialog(null, "S Removed!");}
			 */

		} else if (backBtn.getText().equals(command)) {
			TeacherMenu xk = new TeacherMenu();
			xk.setVisible(true);
			this.setVisible(false);
		} else {
		}
	}

	public static void main(String[] args) {
		RemoveTeacher r = new RemoveTeacher();
		r.setVisible(true);
	}
}