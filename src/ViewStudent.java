import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStudent extends JFrame{
    private JTextArea resultView;
    private JPanel viewPanel;
    private JButton closeButton;
    private JButton BtInsert;
    private JButton BtDelete;


    public ViewStudent(){

        setContentPane(viewPanel);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("AI-DB Instagram View");
        setVisible(true);
        BtInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultView.append("hello\n");
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        BtDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultView.setText("");

            }
        });
    }
}

