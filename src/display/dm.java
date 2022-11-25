package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class dm extends JFrame{
    private final static ArrayList<String> room_id = new ArrayList<String>();
    private JPanel main;
    private JButton createRoom;
    private JScrollPane roomPanel;
    private JPanel room;

    public dm(){
        // 방 목록 업데이트
        // client에서 방목록을 불러오기 room_id

        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,850,1000);
        //
        roomPanel.getVerticalScrollBar().setUnitIncrement(15);

        GridBagLayout Gbag = new GridBagLayout();
        room.setLayout(Gbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        for(int i = 0;i<room_id.size();i++){
            roomPanel pane = new roomPanel(room_id.get(i));
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipadx = 850;
            gbc.ipady = 100;
            gbc.gridx = 0;
            gbc.gridy = i;
            Gbag.setConstraints(pane,gbc);
            room.add(pane);
            room.updateUI();
        }
        roomPanel.setViewportView(room);
        roomPanel.setVisible(true);
        room.setVisible(true);
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
