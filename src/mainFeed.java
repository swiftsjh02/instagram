import javax.swing.*;
import java.awt.*;
import java.beans.Visibility;

public class mainFeed {
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
    public mainFeed(){
        ImageIcon home = new ImageIcon("IMG/home.png");
        Image img = home.getImage();
        Image changeImg = img.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon chageIcon = new ImageIcon(changeImg);
        JButton bt = new JButton(chageIcon);

        homeButton.add(bt);
        homeButton.setSize(50,50);
        homeButton.setVisible(true);
    }

    private void createUIComponents() {
        searchButton = new JButton();
        searchButton.setSize(100, 100);
    }
}

