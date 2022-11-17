import javax.swing.*;
import java.awt.*;
import java.beans.Visibility;

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

    public mainFeed(){
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

        ImgSetSize mainphoto = new ImgSetSize("src/IMG/login.png", 100, 50);
        icon.setIcon(mainphoto.getImg());

        ImgSetSize add_size = new ImgSetSize("src/IMG/addfeed.jpg", 50, 50);
        add.setIcon(add_size.getImg());

        ImgSetSize notification = new ImgSetSize("src/IMG/notification.jpg", 50, 50);
        heart.setIcon(notification.getImg());

        ImgSetSize dm_size = new ImgSetSize("src/IMG/dm.jpg", 50, 50);
        dm.setIcon(dm_size.getImg());

        setContentPane(main);
        setSize(600,800);
        setVisible(true);
    }


}

