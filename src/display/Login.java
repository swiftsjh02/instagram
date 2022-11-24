package display;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import function.*;

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

        setContentPane(mainPanel);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,850,1000);
        setTitle("AI-DB Instagram LogIn System");
        setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= txtId.getText();
                String password= txtpwd.getText();
                System.out.println("ID: " + id + "\tPWD: " + password + "\n");
                loginregister manager = new loginregister();
                int session_id = manager.login(id,password);
                if(session_id!=-1){
                    mainFeed a = new mainFeed(session_id);
                    setVisible(false);
                    a.setVisible(true);
                }
                else{
                    System.out.println("x");
                }
            }
        });
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Signup sign = new Signup();
                setVisible(false);
                sign.setVisible(true);
            }
        });
    }
}

