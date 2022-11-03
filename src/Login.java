import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtId;
    private JTextField txtPwd;
    private JButton OKButton;
    private JPanel mainPanel;


    public Login() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ID: " + txtId.getText() + "\tPWD: " + txtPwd.getText() + "\n");
                ViewStudent view = new ViewStudent();
            }
        });

        setContentPane(mainPanel);

        setSize(350, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AI-DB Instagram LogIn System");
        setVisible(true);
    }
}

