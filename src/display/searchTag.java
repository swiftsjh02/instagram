package display;

import function.ImgSetSize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchTag extends JFrame {
    private JButton homeButton;
    private JButton userHomeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JButton popularButton;
    private JButton locationButton;
    private JButton accountButton;
    private JButton audioButton;
    private JButton tagButton;
    private JPanel bottom;
    private JPanel main;

    public searchTag(int session,String user_id) {
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


        setContentPane(main);
        setSize(850, 1000);
        bottom.setSize(850, 50);
        setBounds(0, 0, 850, 1000);
        setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session,user_id);
                setVisible(false);
                a.setVisible(true);

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search a = new search(session,user_id);
                setVisible(false);
                a.setVisible(true);
            }
        });
        reelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reels a = new reels(session,user_id);
                setVisible(false);
                a.setVisible(true);
            }
        });
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop a = new shop(session,user_id);
                setVisible(false);
                a.setVisible(true);
            }
        });
        userHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFeed a = new userFeed(session,user_id);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }
};