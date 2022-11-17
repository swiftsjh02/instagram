import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtId;
    private JButton OKButton;
    private JPanel mainPanel;
    private JButton signup;
    private JLabel Icon;
    private JTextField txtpwd;


    public Login() {
        ImgSetSize mainphoto = new ImgSetSize("src/IMG/login.png", 800, 400);
        Icon.setIcon(mainphoto.getImg());
        Icon.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= txtId.getText();
                String password= txtpwd.getText();
                System.out.println("ID: " + id + "\tPWD: " + password + "\n");
                loginregister manager = new loginregister();
                if(manager.login(id,password)!=-1){
                    mainFeed view = new mainFeed();
                    dispose();
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

        setSize(800, 1100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("AI-DB Instagram LogIn System");
        setVisible(true);
    }
}

