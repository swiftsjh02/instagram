package display;

import chatting.ListeningThread;
import chatting.chatting_client;
import function.ImgSetSize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class story extends JFrame{
    private JButton option;
    private JButton exit;
    private JButton likebt;
    private JButton dmbt;
    public JPanel main;
    private JButton story;
    private JLabel profile;
    private JButton homeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JPanel bottom;
    private JTextField textField1;
    private JButton story_dm;
    private JButton like;
    private JButton exit;

    public story(int session_id, String user_id, chatting_client client, ListeningThread t1){
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
