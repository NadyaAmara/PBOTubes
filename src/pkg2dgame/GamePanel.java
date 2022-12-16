package pkg2dgame;

import Entity.Player;
import Object.Obj;
import Tiles.TileManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    public int tilesize = 20;
//    final int scale = 3;
//    public int tilesize = originaltileSize *scale;
    
//    public final int maxScreenCol = 16;
//    public final int maxScreenRow = 12;
    
    public final int maxworldcol = 40;
    public final int maxworldrow = 31;
    
    public final int screenWidth = maxworldcol*tilesize;
    public final int screenHeight = maxworldrow*tilesize;
    
    
    
    
    int fps = 60;
    
    KeyHandler khandler= new KeyHandler(this);
    public Thread gameThread;

    public TileManager tile = new TileManager(this);
    public ColliisionCheker ck = new ColliisionCheker(this);
    public Asset ass;
    public Player player;
    public UI ui = new UI(this);
    
    public Obj object[] = new Obj[50];
    public int gameState;
    public final int menuState = 0;
    public final int playState1 = 1;
    public final int playState2 = 2;
    public int level = 0;
    public final int scoreState = 98;
    public final int gameoverState = 99;
    public final int finishState = 97;
    public boolean save;
    
     
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        this.addKeyListener(khandler);
        this.setFocusable(true);
        this.gameState = menuState;
        this.setLayout(new BorderLayout());
    }
    
    public void setupGame(){
        save = false;
        resetAllData();
        ui.time = 3600;
        ass.setObjectScreen1();
        player = new Player(this,khandler,130,120);
        String url = "../TileImage/worldMap1.txt";
        tile.setMap(url);
    }
    
    public void setupGame2(){
        level=1;
        ui.time = 3600;
        ass.setObjectScreen2();
        player = new Player(this,khandler,20,80);
        String url = "../TileImage/worldMap2.txt";
        tile.setMap(url);
    }
    
    public void startGamethread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void resetAllData(){
        ass = new Asset(this);
        object = new Obj[50];
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null){

            currentTime = System.nanoTime();
            delta+= (currentTime- lastTime)/drawInterval;
            lastTime = currentTime;
            
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update(){
            player.update();
    }
       
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(gameState==playState1 || gameState == playState2){
            tile.draw(g2);
            for(int i=0;i<object.length;i++){
                if(object[i]!=null){
                    object[i].draw(g2, this, true); 
                }
            }
            player.draw(g2);
        }
        ui.draw(g2);
        g2.dispose();
    }
}
