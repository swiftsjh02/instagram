package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import function.*;
import chatting.*;
public class invite extends JFrame{
    private final static ArrayList<Integer> List= new ArrayList<>();
    private JPanel main;
    private JButton create;
    private JScrollPane invite_scroll;
    private JPanel scoll;

    public invite(){
        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<Integer> friend_list = new ArrayList<Integer>();
        // get_friend_list();
        friend_list.add(12);
        friend_list.add(13);
        friend_list.add(14);
        friend_list.add(15);
        friend_list.add(16);
        friend_list.add(17);
        friend_list.add(18);
        friend_list.add(19);
        friend_list.add(20);
        friend_list.add(21);
        friend_list.add(22);
        friend_list.add(23);
        friend_list.add(24);
        friend_list.add(26);
        friend_list.add(27);
        friend_list.add(28);
        friend_list.add(14);
        friend_list.add(15);
        friend_list.add(16);
        friend_list.add(17);
        friend_list.add(18);
        friend_list.add(19);
        friend_list.add(20);
        friend_list.add(21);
        friend_list.add(22);
        friend_list.add(23);
        friend_list.add(24);
        friend_list.add(26);
        friend_list.add(27);
        friend_list.add(28);
        friend_list.add(14);
        friend_list.add(15);
        friend_list.add(16);
        friend_list.add(17);
        friend_list.add(18);
        friend_list.add(19);
        friend_list.add(20);
        friend_list.add(21);
        friend_list.add(22);
        friend_list.add(23);
        friend_list.add(24);
        friend_list.add(26);
        friend_list.add(27);
        friend_list.add(28);


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
    }

    public class friend extends JPanel{

        private JRadioButton invite_friend;

        private JLabel friend_name;
        private int friend_id;

        public friend(int friend_id){
            this.friend_id = friend_id;

            setLayout(new FlowLayout(FlowLayout.LEFT));

            setSize(850,100);
            invite_friend = new JRadioButton();
            //invite_friend.setSize(50,50);

            friend_name = new JLabel();
            friend_name.setText(String.valueOf(friend_id));
            //friend_name.setSize(100,50);

            add(invite_friend);
            add(friend_name);
            setVisible(true);
            invite_friend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List.add(friend_id);
                }
            });
        }
    }
}
