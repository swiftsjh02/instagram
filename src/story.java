import javax.swing.*;


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

    public story(){
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
        setSize(850,900);
        setBounds(0,0,850,900);
        setVisible(true);
        //dispose();

    }

    public JPanel get_main(){
        return main;
    }
}
