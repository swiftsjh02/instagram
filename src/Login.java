import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Login extends JFrame {
    private JTextField txtId;
    private JTextField txtPwd;
    private JButton OKButton;
    private JPanel mainPanel;


    public Login() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= txtId.getText();
                String password= txtPwd.getText();
                System.out.println("ID: " + id + "\tPWD: " + password + "\n");
                database con=new database();
                if(con.logincheck(id,password)==true){
                    ViewStudent view = new ViewStudent();
                }
                else{
                    System.out.println("x");
                }
            }
        });

        setContentPane(mainPanel);

        setSize(350, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AI-DB Instagram LogIn System");
        setVisible(true);
    }
}

