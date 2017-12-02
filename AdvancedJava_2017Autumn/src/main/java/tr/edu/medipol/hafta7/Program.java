package tr.edu.medipol.hafta7;

import javax.swing.*;
import java.awt.event.*;

public class Program {
    public static void main(String[] args) {
        new LoginPencere();
    }
}

class LoginPencere {
    private JFrame loginPencere = new JFrame("Login");
    private JButton okButon = new JButton("OK");

    public LoginPencere() {
        loginPencere.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loginPencere.getContentPane().add(okButon);
        okButon.addActionListener(ae -> {
                loginPencere.dispose();
                new Pencere2();
        });
        loginPencere.setSize(200, 200);
        loginPencere.setVisible(true);
    }

}

class Pencere2 {
    private JFrame f = new JFrame("Second");
    public Pencere2() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}
