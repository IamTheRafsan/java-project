import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class FindStudent extends JFrame implements MouseListener, ActionListener {
    JLabel headingLabel, nameLabel, idLabel;
    JTextField nameF, idF;
    JButton findBtn, backBtn;
    JPanel panel;
    Color myColor;
    Font myFont;
    StudentMenu si;
    Student s;

    Student student[];

    public FindStudent() {
        super("Find a Student");
        this.setSize(765, 490);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        student = new Student[100];
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

        findBtn = new JButton("Find");
        findBtn.setBounds(270, 230, 100, 30);
        findBtn.addMouseListener(this);
        findBtn.addActionListener(this);
        panel.add(findBtn);

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

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (findBtn.getText().equals(command)) {
            String u1 = nameF.getText();
            String u2 = idF.getText();

            try {
                BufferedReader bufferedrReader = new BufferedReader(new FileReader("studentinfo.txt"));

                int totalLine = 0;

                while (bufferedrReader.readLine() != null)
                    totalLine++;
                bufferedrReader.close();

                for (int i = 0; i < totalLine; i++) {
                    String line1 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i);

                    if (line1.equals(u1)) {
                        String line2 = Files.readAllLines(Paths.get("studentinfo.txt")).get(i + 1);
                        if (line2.equals(u2)) {
                            JOptionPane.showMessageDialog(null, "Student Found");
                            break;
                        }

                    }

                }

            } catch (Exception e) {
                showMessageDialog(null, "Student not Found!");
            }

        } else if (backBtn.getText().equals(command)) {
            StudentMenu xk = new StudentMenu();
            xk.setVisible(true);
            this.setVisible(false);
        } else {
        }
    }

}