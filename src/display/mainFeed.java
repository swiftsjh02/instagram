package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import function.*;
import chatting.*;


public class mainFeed extends JFrame{

    private JPanel panelBottom;
    private JButton homeButton;
    private JButton userHomeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JPanel main;
    private JLabel icon;
    private JButton add;
    private JButton heart;
    private JButton dm;
    private JPanel topbar;
    private JScrollPane post;

    private JPanel home_main;
    private JPanel home;

    private ListeningThread t1;
    public String user_id;
    public int session_id;


    class JFrameWindowClosingEventHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            JFrame frame = (JFrame)e.getWindow();
            loginregister manager= new loginregister();
            frame.dispose();
            manager.logout(session_id);
            System.out.println("LogOut");
        }
    }

    public mainFeed(int session,String user_id){

        session_id=session;
        this.user_id=user_id;

        chatting_client client = new chatting_client(user_id);
        client.run();
        this.t1 = client.get_listening();
//         client.send_messege();
//         client.invite_room();
//         client.make_room();
//         client.exit_room();
//         client.logout();
//         client.send_file();


        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.jpg", 50, 50);
        shopButton.setIcon(shop.getImg());

       ImgSetSize userhome = new ImgSetSize("src/IMG/userhomefeed.png", 50, 50);
       userHomeButton.setIcon(home.getImg());


        ImgSetSize mainphoto = new ImgSetSize("src/IMG/login.png", 100, 50);
        icon.setIcon(mainphoto.getImg());

        ImgSetSize add_size = new ImgSetSize("src/IMG/addfeed.jpg", 50, 50);
        add.setIcon(add_size.getImg());

        ImgSetSize notification = new ImgSetSize("src/IMG/notification.jpg", 50, 50);
        heart.setIcon(notification.getImg());

        ImgSetSize dm_size = new ImgSetSize("src/IMG/dm.jpg", 50, 50);
        dm.setIcon(dm_size.getImg());


        setContentPane(main);

        setSize(850, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,850,1000);
        setTitle("AI-DB Instagram LogIn System");
        //setVisible(true);
        this.addWindowListener(new JFrameWindowClosingEventHandler());

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                story a = new story(session,user_id);
                setVisible(false);
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

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        heart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        dm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm a = new dm(client,user_id,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });


    }


}

