import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtId;
    private JButton OKButton;
    private JPanel mainPanel;
    private JButton signup;
    private JPasswordField enpassword;

    private int session;

    private loginregister loginmanager= new loginregister();


    public Login() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email= txtId.getText();
                char[] char_password= enpassword.getPassword();
                String password= new String(char_password);
                System.out.println("email: " + email + "\tPWD: " + password + "\n");
                int session=loginmanager.login(email,password);
                if(session==-1){
                    System.out.println("Wrong id and password");
                }else{
                    ViewStudent screen= new ViewStudent();
                    dispose();
                }

            }
        });
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Signup sign = new Signup();
            }
        });

        setContentPane(mainPanel);

        setSize(350, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AI-DB Instagram LogIn System");
        setVisible(true);
    }
}

