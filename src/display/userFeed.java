package display;

import function.ImgSetSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class userFeed extends JFrame{
    private JPanel userinformation;
    private JButton homeButton;
    private JButton userHomeButton;
    private JButton reelsButton;
    private JButton searchButton;
    private JButton shopButton;
    private JPanel bottom;
    private JPanel main;
    private JButton button3;
    private JLabel id;
    private JButton profilename;
    private JLabel arrowDown;


    private final static ArrayList<Integer> List= new ArrayList<>();
    private JPanel top;
    private JButton create;
    private JScrollPane post_scroll;
    private JPanel scroll;

    public userFeed(int session){
        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.jpg", 50, 50);
        shopButton.setIcon(shop.getImg());

       ImgSetSize userHome = new ImgSetSize("src/IMG/userhomefeed.png", 50, 50);
       userHomeButton.setIcon(home.getImg());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<Integer> post_list = new ArrayList<Integer>();
        // get_post_list();
        post_list.add(1);
        post_list.add(2);
        post_list.add(3);
        post_list.add(4);
        post_list.add(5);
        post_list.add(6);
        post_list.add(7);

        post_scroll.getVerticalScrollBar().setUnitIncrement(15);

        GridBagLayout Gbag = new GridBagLayout();
        scroll.setLayout(Gbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        for(int i = 0;i<post_list.size();i++){
            post pane = new post(post_list.get(i));
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipadx = 850;
            gbc.ipady = 100;
            gbc.gridx = 0;
            gbc.gridy = i;
            Gbag.setConstraints(pane,gbc);
            scroll.add(pane);
            scroll.updateUI();
        }
        post_scroll.setViewportView(scroll);
        post_scroll.setVisible(true);
        scroll.setVisible(true);


        setContentPane(main);
        setSize(850,1000);
        bottom.setSize(850,50);
        setBounds(0,0,850,1000);
        setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a  = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search a = new search(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        reelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reels a = new reels(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop a = new shop(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        userHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
