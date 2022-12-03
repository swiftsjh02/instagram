package display;

import chatting.ListeningThread;
import chatting.chatting_client;

import javax.swing.*;

public class addFeed extends JFrame{
    private JButton share;
    private JButton cancel;
    private JLabel newPost;
    private JLabel music;
    private JLabel location;
    private JLabel other;
    private JLabel facebook;
    private JLabel twitter;
    private JLabel tumblr;
    private JLabel settings;
    private JTextField wordText;
    private JPanel main;
    private JTextField tag;

    addFeed(int session, String user_id, chatting_client client, ListeningThread t1){


        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,850,1000);
    }
}
