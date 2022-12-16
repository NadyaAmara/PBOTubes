package pkg2dgame;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

public class Main {
    
    
    public static void main(String[] args) {   
        JFrame window = new JFrame("DARK MAZE");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();
        
        window.setVisible(true);
        
        window.setLocationRelativeTo(null);
        
        gamePanel.setupGame();
        gamePanel.startGamethread();
        
    }
    
}
