package pkg2dgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class UI {
    GamePanel gp;
    Font  font40;
    public boolean messageON = false;
    public String message ="";
    int messageCounter = 0;
    public boolean gamefinish = false;
    int x,y, jam, menit, detik, time;
    Graphics2D g2;
    DecimalFormat dformat = new DecimalFormat("#00,00,00");
    BufferedImage title1,title2,title3;
    public int commandNum = 0;
    String name;

    public UI(GamePanel gp){
        this.gp = gp;
        try {
            font40 = Font.createFont(Font.TRUETYPE_FONT, new File("../PixelGameFont.ttf")).deriveFont(90f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("../PixelGameFont.ttf")));
        } catch (IOException | FontFormatException e) {
        }
    }
    
    public void showMessage(String text){
        message = text;
        messageON = true;
    }
    
    public void setTimer(){
         jam = (int) time/3600;
         menit = (int) (time-(jam*3600))/60;
         detik = (int) time-(menit*60)-((jam*3600));
    }
    
    public void draw(Graphics2D g2){
        this.g2 = g2;
        if(gp.gameState == gp.menuState){
            drawMenuState();
        }else if(gp.gameState == gp.scoreState){
            drawScoreState();
        }else if(gp.gameState == gp.gameoverState){
            drawGameOverState();
        }
        else{
            if(gp.gameState == gp.finishState){
                if(gamefinish){
                    gp.level=2;
                    try {
                        String sql = "INSERT INTO data VALUE('"+name+"',"+gp.level+");";
                        Connection conn = Koneksi.getKoneksi();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.execute();
                    } catch (SQLException e) {
                        System.out.println(e.getStackTrace());
                    }
                    gamefinish=false;
                }else{
                    g2.setFont(font40);
                    g2.setColor(Color.white);
                    message = "End the game";
                    x = getXValue(message);
                    y = gp.screenHeight/2 - (gp.tilesize*3);
                    g2.drawString(message, x, y);
                }
            }else{
                g2.setFont(font40);
                g2.setColor(Color.white);
                setTimer();
                System.out.println(jam);
                g2.drawString("time : "+jam+":"+menit+":"+detik, gp.tilesize*gp.maxworldcol-gp.tilesize*4, gp.tilesize*2);
                time-=(double)1/60;
                if(time<=0){
                    gp.gameState = gp.gameoverState;
                }
                if(messageON){
                    g2.drawString(message, gp.tilesize*5, 11*gp.tilesize);
                    messageCounter++;
                    if(messageCounter > 120){
                        messageCounter=0;
                        messageON = false;
                    }
                }
            }       
        }
        
    }

    private void drawMenuState() {
        g2.setFont(font40);
        try {
            title1 = ImageIO.read(getClass().getResourceAsStream("../TileImage/menu1.png"));
            title2 = ImageIO.read(getClass().getResourceAsStream("../TileImage/menu2.png"));
            title3 = ImageIO.read(getClass().getResourceAsStream("../TileImage/menu3.png"));
        } catch (IOException e) {
            
            e.getStackTrace();
        }
        String text = "DARK MAZE";
        x = getXValue(text) - 80;
        y = gp.tilesize * 5;
        g2.setFont(new Font("TimesRoman", Font.BOLD, 38));
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 26));
        text = "PLAY";
        x = getXValue(text);
        y +=gp.tilesize*8;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tilesize, y);
        }
        
        text = "SCORE";
        x = getXValue(text);
        y += gp.tilesize*4;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tilesize, y);
        }
        
        text = "EXIT";
        x = getXValue(text);
        y += gp.tilesize * 4;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.tilesize, y);
        }
        
    }
    
    public void drawProfilState() {
        name = JOptionPane.showInputDialog("NAME : ");
    }
    
    public int getXValue(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
    private void drawScoreState() {
        g2.setFont(font40);
        String text = "Nama";
        x = gp.tilesize*2;
        y = gp.tilesize*2;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        text = "Level";
        x =gp.tilesize*6;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        try {
            String sql = "SELECT * FROM data ORDER BY level limit 6";
            Connection conn = Koneksi.getKoneksi();
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while(res.next()){
                y+=gp.tilesize;
                g2.drawString(res.getString(1), gp.tilesize*2, y);
                g2.drawString(res.getString(2), gp.tilesize*6, y);
                
            }
        } catch (SQLException e) {
            System.out.println("Error : "+e.getMessage());
        }
        
    }

    private void drawGameOverState() {
        g2.setFont(font40);
        if(!gp.save){
            try {
                String sql = "INSERT INTO data VALUE('"+name+"',"+gp.level+");";
                Connection conn = Koneksi.getKoneksi();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.execute();
            } catch (SQLException e) {
                System.out.println(e.getStackTrace());
            }
            gp.save = true;
        }
        String text = "Game Over";
        x = getXValue(text);
        y = gp.tilesize*6;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        text = "MENU";
        x = getXValue(text);
        y += gp.tilesize;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tilesize, y);
        }
        
        text = "EXIT";
        x = getXValue(text);
        y += gp.tilesize;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tilesize, y);
        }
        
    }
    
}
