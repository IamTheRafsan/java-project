import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Home extends JFrame implements MouseListener, ActionListener {
    ImageIcon school;
    JLabel headingLabel, schoolLabel;
    JButton adminBtn, studentBtn, teacherBtn;
    Color color;
    JPanel panel;
    Login li;
    StudentLogin stlog;
    TeacherLogin tealog;

    public Home() {
        super("Simple University Management System");
        this.setSize(765, 490);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.li = li;
        this.stlog = stlog;
        this.tealog = tealog;

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);


        adminBtn = new JButton("Admin Login");
        adminBtn.setBounds(300, 170, 150, 30);
        adminBtn.addMouseListener(this);
        adminBtn.addActionListener(this);
        panel.add(adminBtn);

        studentBtn = new JButton("Student Login");
        studentBtn.setBounds(300, 220, 150, 30);
        studentBtn.addMouseListener(this);
        studentBtn.addActionListener(this);
        panel.add(studentBtn);

        teacherBtn = new JButton("Teacher Login");
        teacherBtn.setBounds(300, 270, 150, 30);
        teacherBtn.addMouseListener(this);
        teacherBtn.addActionListener(this);
        panel.add(teacherBtn);

        school = new ImageIcon("homeBackground.jpg");
        schoolLabel = new JLabel(school);
        schoolLabel.setBounds(0, 0, 750, 450);
        panel.add(schoolLabel);



        

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

        if (ae.getSource() == adminBtn) {
            Login logIn = new Login();
            logIn.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == studentBtn) {
            StudentLogin stulogIn = new StudentLogin();
            stulogIn.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == teacherBtn) {
            TeacherLogin tealogIn = new TeacherLogin();
            tealogIn.setVisible(true);
            this.setVisible(false);
        } else {
        }
    }

}