package display;

import javax.swing.*;
import function.*;

public class reels extends JFrame{
    private JPanel main;
    private JButton userhomeButton;
    private JButton homeButton;
    private JButton userHomeButton;
    private JButton shopButton;
    private JButton reelsButton;
    private JButton searchButton;
    private JLabel camera;
    private JButton imageButton;
    private JButton likeButton;
    private JButton moreButton;
    private JButton dmButton;
    private JButton commentsButton;
    private JButton 팔로우Button;
    private JPanel bottom;

    public reels(){
        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.png", 50, 50);
        shopButton.setIcon(shop.getImg());

        ImgSetSize userHome = new ImgSetSize("src/IMG/userhomefeed.png", 50, 50);
        userhomeButton.setIcon(userHome.getImg());

        ImgSetSize camera1 = new ImgSetSize("src/IMG/camera1.png", 50,50);
        camera.setIcon(camera1.getImg());

        ImgSetSize like = new ImgSetSize("src/IMG/like.png", 50,50);
        likeButton.setIcon(like.getImg());

        ImgSetSize comments = new ImgSetSize("src/IMG/comments.png", 50,50);
        commentsButton.setIcon(comments.getImg());

        ImgSetSize dm = new ImgSetSize("src/IMG/dm.png", 50,50);
        dmButton.setIcon(dm.getImg());

        ImgSetSize more = new ImgSetSize("src/IMG/more.png", 50,50);
        moreButton.setIcon(more.getImg());


        setContentPane(main);
        setSize(850,1000);
        bottom.setSize(850,50);
        setBounds(0,0,850,1000);
        setVisible(true);
    }
}
