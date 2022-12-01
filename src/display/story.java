package display;

import chatting.ListeningThread;
import chatting.chatting_client;
import function.ImgSetSize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class story extends JFrame{

    public JPanel main;
    private JButton homeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JButton userHomeButton;
    private JPanel bottom;
    private JButton likeButton;
    private JButton dmButton;

    public story(int session_id, String user_id, chatting_client client, ListeningThread t1){

        //bottom button

        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.png", 50, 50);
        shopButton.setIcon(shop.getImg());

//        ImgSetSize userhome = new ImgSetSize("src/IMG/.png", 50, 50);
//        userHomeButton.setIcon(home.getImg());

        setContentPane(main);
        setSize(850,1000);
        bottom.setSize(850,50);
        setBounds(0,0,850,1000);
        setVisible(true);
        //dispose();


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session_id,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }

}
