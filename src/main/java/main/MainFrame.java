package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class MainFrame extends JFrame{

    JLabel textPanel;
    JLabel hyperlink;

    MainFrame() {

        super("LF05Backend");

        textPanel = new JLabel();
        textPanel.setBounds(50,5,150,50);
        textPanel.setText("Server is running...");

        hyperlink = new JLabel("Find out more on GitHub");
        hyperlink.setBounds(50,40,150,50);
        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hyperlink.setText("<html><a href=''>Find out more on GitHub</a></html>");
        hyperlink.setText("Find out more on GitHub");

        hyperlink.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
         
                    Desktop.getDesktop().browse(new URI("http://github.com/devclaim/lf05backend"));
                     
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(280,200);
        this.add(textPanel);
        this.add(hyperlink);
    }
}


