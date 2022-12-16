package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public abstract class Entity {
    public int worldX,worldY,speed;
    public BufferedImage up1,down1,left1,right1,up2,down2,left2,right2,stay;
    public String direction;
    public int life, maxlife;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
}
