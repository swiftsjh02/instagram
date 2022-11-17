import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtId;
    private JTextField txtPwd;
    private JButton OKButton;
    private JPanel mainPanel;
    private JButton signup;


    public Login() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= txtId.getText();
                String password= txtPwd.getText();
                System.out.println("ID: " + id + "\tPWD: " + password + "\n");
                database con=new database();
                if(con.logincheck(id,password)==true){
                    mainFeed view = new mainFeed();
                }
                else{
                    System.out.println("x");
                }
            }
        });
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                Signup sign = new Signup();
            }
        });

        setContentPane(mainPanel);

        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AI-DB Instagram LogIn System");
        setVisible(true);
    }
}

