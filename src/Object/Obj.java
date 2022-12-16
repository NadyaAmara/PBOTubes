package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pkg2dgame.GamePanel;

public abstract class Obj {
    public BufferedImage image;
    public String nama;
    public boolean collision = false;
    public boolean collisionOn = false;
    public int x, defauldX;
    public int y, defauldY;
    public boolean condition, fake;
    public Rectangle solidArea = new Rectangle(0,0,20,20);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    
    public void draw(Graphics2D g, GamePanel gp, boolean gerak){
        int worldX = x;
        int worldY = y;
        g.drawImage(image, worldX, worldY, gp.tilesize,gp.tilesize,null);
//        g.setColor(Color.red);
//        g.drawRect(screeenX, screeenY, solidArea.width,solidArea.height);
        
    }
    
}
