import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    public Signup(){
        setContentPane(panel1);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        setTitle("signup");
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= textField1.getText();
                String password= textField2.getText();
                System.out.println("ID: " + id + "\tPWD: " + password + "\n");
                database con=new database();

                //database 안에 회원가입 메서드를 불러와야함
                //con.register(id,password);
            }
        });
    }
}