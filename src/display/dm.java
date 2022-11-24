package display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dm extends JFrame{
    private JPanel main;
    private JButton createRoom;
    private JScrollPane roomPanel;

    public dm(){
        // 방 목록 업데이트
        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,850,1000);
        //
        createRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invite a = new invite();
                setVisible(false);
                a.setVisible(true);
            }
        });
    }
    public class roomPanel extends JPanel{

        private String room_id;

        private JLabel member;

        private JButton in;

        public roomPanel(String id){
            this.room_id = id;

            this.in = new JButton();



        }
    }
}
