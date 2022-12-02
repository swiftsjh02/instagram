package display;

import function.ImgSetSize;

import javax.swing.*;

public class editprofile extends JFrame {
    private JPanel main;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton okButton;
    private JButton cancelButton;
    private JLabel pro;
    private JLabel personal;
    private JButton profile;
    private JLabel editImage;
    private JButton profile2;

    public editprofile(){

        ImgSetSize profileLeft = new ImgSetSize("src/IMG/editprofile.jpg", 50, 50);
        profile.setIcon(profileLeft.getImg());

        ImgSetSize profileRight = new ImgSetSize("src/IMG/avatar.jpg", 50, 50);
        profile2.setIcon(profileRight.getImg());
    }
}
