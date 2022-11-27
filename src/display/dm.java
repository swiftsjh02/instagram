package display;

import chatting.ListeningThread;
import chatting.chatting_client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class dm extends JFrame{
    private static ArrayList<String> room_id;
    private static ArrayList<String> member_list;
    private JPanel main;
    private JButton createRoom;
    private JScrollPane roomPanel;
    private JPanel room;
    private String user_id;
    private ListeningThread t1;
    private chatting_client client;
    public dm(chatting_client client, String user_id, ListeningThread t1){
        this.t1 = t1;
        this.user_id = user_id;
        this.client = client;

        ArrayList<String> a = new ArrayList<>();
//        a.add("1");
//        a.add("2");
//        client.make_room(1,user_id,a);
        // 방 목록 업데이트
        // client에서 방목록을 불러오기 room_id 형태 arrayList<string>
        client.get_room_list(11,user_id);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        room_id = t1.get_myroom_list();

        for(int i = 0;i<room_id.size();i++){
            System.out.println(room_id.get(i));
        }
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
            client.get_user_list_in_room(13,user_id,room_id.get(i));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
//            room_id = t1.get_myroom_list();
            member_list = t1.get_users_in_room();
            roomPanel pane = new roomPanel(member_list,room_id.get(i));
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipadx = 850;
            gbc.ipady = 100;
            gbc.gridx = 0;
            gbc.gridy = i*100;
            Gbag.setConstraints(pane,gbc);
            room.add(pane);
            room.updateUI();
        }
        roomPanel.setViewportView(room);
        roomPanel.setVisible(true);
        room.setVisible(true);

        //Listener에서 방목록이 추가 되었을때 string 룸 아이디 : idroom
//        if(){
//            room_id.add(idroom);
//            roomPanel pane = new roomPanel(member_list,idroom);
//            gbc.fill = GridBagConstraints.BOTH;
//            gbc.ipadx = 850;
//            gbc.ipady = 100;
//            gbc.gridx = 0;
//            gbc.gridy = i;
//            Gbag.setConstraints(pane,gbc);
//            room.add(pane);
//            room.updateUI();
//        }
        createRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invite a = new invite(client,user_id,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }
    public class roomPanel extends JPanel{

        private  ArrayList<String> member_list = new ArrayList<>();
        private String room_id;

        private JLabel member;

        private JButton in;

        private JButton out;

        public roomPanel(ArrayList<String> member , String id){
            this.member_list = member;
            this.room_id = id;
            this.member = new JLabel();
            String a = new String();
            for(int i =0;i<member_list.size();i++){
                a = a + " " + member_list.get(i);
                System.out.println(member_list.get(i));
            }
            this.member.setText(a);
            this.in = new JButton("in");
            this.out = new JButton("out");

            setLayout(new FlowLayout(FlowLayout.LEFT));
            setSize(850,100);
            this.in.setSize(100,100);
            this.out.setSize(100,100);
            this.member.setSize(750,100);
            add(this.in);
            add(this.out);
            add(this.member);

            in.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chat a = new chat(client,user_id,room_id);
                    a.setVisible(true);
                    dispose();
                }
            });

            out.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    client.exit_room(3,user_id,room_id);
                    dm a = new dm(client, user_id,t1);
                    a.setVisible(true);
                    dispose();
                }
            });
        }
    }
}
