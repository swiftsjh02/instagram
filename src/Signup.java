import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame {
    private JPanel panel1;
    private JTextField id;
    private JTextField email;
    private JButton button1;
    private JPasswordField pwd;
    private JTextField fullNameTextField;
    private JTextField mobileNumberOrEmailTextField;

    public Signup(){
        setContentPane(panel1);
        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setBounds(0,0,850,1000);
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
                int status= registermanager.register(emailfromclient,pwd_chartostr);
                if(status==1){
                    Login a = new Login();
                    setVisible(false);
                    a.setVisible(true);
                } else if (status==2) {
                    System.out.println("중복된 아이디가 존재합니다.");
                }
                else{
                    System.out.println("알 수 없는 에러");
                }


            }
        });
    }
}