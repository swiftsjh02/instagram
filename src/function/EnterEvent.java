package function;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EnterEvent {
    JTextField jtf = new JTextField();
    boolean focus = false;

    jtf.addFocusListener(this); // 텍스트 필드에 포커스 리스너 추가
    jtf.addKeyListener(new KeyAdapter()); // 텍스트 필드에 키 리스너 추가

    public void keyPressed(KeyEvent e) {
        if(focusJtf == true) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                // 엔터키를 눌렀을 때 실행할 코드
                focus = true;
            }
        }
    }
}
