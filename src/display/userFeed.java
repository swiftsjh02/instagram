package display;
import javax.swing.*;
import function.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                mainFeed a = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        reelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }
}
