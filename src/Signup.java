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

        setTitle("signup");
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                char[] password= pwd.getPassword();
                String emailfromclient= email.getText();
                System.out.println("email: " + emailfromclient + "\tPWD: " + password + "\n");
                database con=new database();
                String pwd_chartostr = new String(password);
                //database 안에 회원가입 메서드를 불러와야함
                if(con.register(emailfromclient,pwd_chartostr)==false){
                    System.out.println("회원가입 오류");
                }
                else {
                    dispose();
                }
            }
        });
    }
}