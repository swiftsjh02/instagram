import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame {
    private JPanel panel1;
    private JTextField id;
    private JTextField email;
    private JButton button1;
    private JPasswordField pwd;

    public Signup(){
        setContentPane(panel1);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        loginregister registermanager= new loginregister();
        setTitle("signup");
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                char[] password= pwd.getPassword();
                String emailfromclient= email.getText();
                System.out.println("ID: " + emailfromclient + "\tPWD: " + password + "\n");
                String pwd_chartostr = new String(password);
                if(registermanager.register(emailfromclient,pwd_chartostr)==1){
                    dispose();
                }
                else{
                    System.out.println("회원가입 실패");
                }


            }
        });
    }
}