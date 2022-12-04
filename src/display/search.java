package display;
import chatting.ListeningThread;
import chatting.chatting_client;
import function.ImgSetSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class search extends JFrame {
    private JButton homeButton;
    private JButton userhomeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JButton searchingButton;
    private JPanel main;
    private JPanel bottom;
    private JPanel top;
    private JPanel post;
    private JScrollPane scroll_post;
    private JPanel scroll;

    public search(int session, String user_id, chatting_client client, ListeningThread t1) {
        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.jpg", 50, 50);
        shopButton.setIcon(shop.getImg());

        ImgSetSize userFeed = new ImgSetSize("src/IMG/userhomefeed.png", 50, 50);
        userhomeButton.setIcon(home.getImg());

        ArrayList<Integer> post_list = new ArrayList<Integer>();
        // get_post_list();
        post_list.add(1);
        post_list.add(2);
        post_list.add(3);
        post_list.add(4);
        post_list.add(5);
        post_list.add(6);
        post_list.add(7);
        post_list.add(8);
        post_list.add(9);
        post_list.add(10);
        post_list.add(11);

        scroll_post.getVerticalScrollBar().setUnitIncrement(15);

        GridBagLayout Gbag = new GridBagLayout();
        scroll.setLayout(Gbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        for(int i = 0;i<post_list.size();i++){
            post pane = new post();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipadx = 200;
            gbc.ipady = 200;
            gbc.gridx = i%3;
            gbc.gridy = i/3;
            Gbag.setConstraints(pane,gbc);
            scroll.add(pane);
            scroll.updateUI();
        }
        scroll_post.setViewportView(scroll);
        scroll_post.setVisible(true);
        scroll.setVisible(true);

        setContentPane(main);
        setSize(850, 1000);
        bottom.setSize(850, 50);
        setBounds(0, 0, 850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search a = new search(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        reelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reels a = new reels(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop a = new shop(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        userhomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFeed a = new userFeed(session,user_id,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        searchingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTag a = new searchTag(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

    }

    public class post extends JPanel{
        private JButton post_num;

        post(){
            setLayout(new GridLayout(1,1));
            setSize(200,200);
            post_num = new JButton();
            post_num.setSize(200,200);
            post_num.setBackground(new Color(255,255,255));
            add(post_num);


            post_num.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
    }

}



