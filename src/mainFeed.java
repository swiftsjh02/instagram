import javax.swing.*;
import java.awt.*;
import java.beans.Visibility;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class mainFeed extends JFrame{
    private JPanel panelBottom;
    private JButton homeButton;
    private JButton userHomeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextPane TextPane;
    private JPanel main;

    public String session_id=null;

    class JFrameWindowClosingEventHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            JFrame frame = (JFrame)e.getWindow();
            loginregister manager= new loginregister();
            frame.dispose();
            manager.logout(session_id);
            System.out.println("LogOut");
        }
    }

    public mainFeed(String session){
        session_id=session;
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
        setSize(600,1100);
        setVisible(true);
        this.addWindowListener(new JFrameWindowClosingEventHandler());
    }


}

