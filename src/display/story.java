package display;

import function.ImgSetSize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class story extends JFrame{
    private JTextArea 메시지보내기;
    private JPanel dm;
    private JButton option;
    private JButton exit;
    private JButton likebt;
    private JButton dmbt;
    private JButton id;
    private JPanel like;
    public JPanel main;
    private JButton story;
    private JLabel profile;
    private JButton homeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JButton userHomeButton;
    private JPanel bottom;

    public story(int session_id,String user_id){
        ImgSetSize dm_size = new ImgSetSize("src/IMG/dm.jpg", 50, 50);
        dmbt.setIcon(dm_size.getImg());

        ImgSetSize like = new ImgSetSize("src/IMG/notification.jpg", 50, 50);
        likebt.setIcon(like.getImg());

        ImgSetSize testpng = new ImgSetSize("src/IMG/storytest.png", 560, 640);
        story.setIcon(testpng.getImg());

        ImgSetSize testprofile = new ImgSetSize("src/IMG/testprofile.png", 50, 50);
        profile.setIcon(testprofile.getImg());

        ImgSetSize optionbt = new ImgSetSize("src/IMG/testprofile.png", 50, 50);
        option.setIcon(optionbt.getImg());

        ImgSetSize exitbt = new ImgSetSize("src/IMG/testprofile.png", 50, 50);
        exit.setIcon(exitbt.getImg());

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
                mainFeed a = new mainFeed(session_id,user_id);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }

}
