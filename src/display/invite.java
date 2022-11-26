package display;

import chatting.ListeningThread;
import chatting.chatting_client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class invite extends JFrame{
    private final static ArrayList<String> List= new ArrayList<String>();
    private JPanel main;
    private JButton create;
    private JScrollPane invite_scroll;
    private JPanel scoll;
    private JTextField search_friend;
    private JButton searchButton;
    private JLabel invite_list;

    private String user_id;
    private chatting_client client;
    public invite(chatting_client client, String user_id, ListeningThread t1){
        this.client = client;
        this.user_id = user_id;
        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<String> friend_list = new ArrayList<String>();
        // client에서 list 받아오기 get_friend_list();

        friend_list.add("a");
        friend_list.add("apple");
        friend_list.add("aasdss");
        friend_list.add("bkd");
        friend_list.add("ytre");



        invite_scroll.getVerticalScrollBar().setUnitIncrement(15);

        GridBagLayout Gbag = new GridBagLayout();
        scoll.setLayout(Gbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        for(int i = 0;i<friend_list.size();i++){
            friend pane = new friend(friend_list.get(i));
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipadx = 850;
            gbc.ipady = 100;
            gbc.gridx = 0;
            gbc.gridy = i;
            Gbag.setConstraints(pane,gbc);
            scoll.add(pane);
            scoll.updateUI();
        }
        invite_scroll.setViewportView(scoll);
        invite_scroll.setVisible(true);
        scoll.setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = search_friend.getText();
                scoll.removeAll();
                for(int i = 0;i< friend_list.size();i++){
                    if(friend_list.get(i).contains(email)){
                        friend pane = new friend(friend_list.get(i));
                        gbc.fill = GridBagConstraints.BOTH;
                        gbc.ipadx = 850;
                        gbc.ipady = 100;
                        gbc.gridx = 0;
                        gbc.gridy = i;
                        Gbag.setConstraints(pane,gbc);
                        scoll.add(pane);
                        scoll.updateUI();
                    }
                }
                invite_scroll.setViewportView(scoll);
                invite_scroll.setVisible(true);
                scoll.setVisible(true);
            }
        });
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //chatting_client에 List 전달
                client.make_room(1,user_id,List);
                dm a = new dm(client,user_id,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }

    public class friend extends JPanel{

        private JButton invite_friend;
        private JButton remove_friend;
        private JLabel friend_name;
        private String friend_id;

        public friend(String friend_id){
            this.friend_id = friend_id;

            setLayout(new FlowLayout(FlowLayout.LEFT));

            setSize(850,100);
            invite_friend = new JButton("invite");
            //invite_friend.setSize(50,50);

            remove_friend = new JButton("remove");

            friend_name = new JLabel();
            friend_name.setText(String.valueOf(friend_id));
            //friend_name.setSize(100,50);

            add(invite_friend);
            add(remove_friend);
            add(friend_name);
            setVisible(true);
            invite_friend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int same = 0;
                    for(int i = 0;i< List.size();i++){
                        if(List.get(i) == friend_id){
                            same = 1;
                        }
                    }
                    if(same == 0){
                        List.add(friend_id);
                        invite_list.setText(invite_list.getText() + friend_id + " , ");
                    }
                }
            });

            remove_friend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i =0;i<List.size();i++){
                        if(List.get(i) == friend_id){
                            List.remove(i);
                            invite_list.setText(invite_list.getText().replace(friend_id + " , ",""));
                        }
                    }
                }
            });
        }
    }
}
