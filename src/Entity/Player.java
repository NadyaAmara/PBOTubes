package Entity;

//
import Tiles.TileManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import pkg2dgame.GamePanel;
import pkg2dgame.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public String name = "";
    
    public Player(GamePanel gp, KeyHandler keyH, int x, int y){
        this.gp = gp;
        this.keyH = keyH;
        speed = 2;
        worldX = x;
        worldY = y;
        solidArea = new Rectangle(5,8,10,12);
        solidAreaDefaultX = 5;
        solidAreaDefaultY =8;
//        setDefaultValue();
        getPlayerImage(); 
        direction = "stay";
    }
    
//    public void setPlayer(){
//        worldX=150;
//        worldY=100;
//        speed = 4;
//    }
    
    public void getPlayerImage(){
        
        try{
            stay = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_5.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_6.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_3.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_7.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("../playerImage/sprite_8.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
//    public void setDefaultValue(){
//        worldX=150;
//        worldY=100;
//        speed = 4;
//        life = 3;
//        maxlife = 3;
//        eyes = 2 * gp.tilesize;
//    }
    
    public void update(){
        if(keyH.upPressed== true || keyH.downPressed== true || keyH.leftPressed== true || keyH.rightPressed== true){
            if(keyH.upPressed){
                direction="up";
            }else if(keyH.downPressed){
                direction ="down";
            }else if(keyH.leftPressed){
                direction ="left";
            }else if(keyH.rightPressed){
                direction ="right";
            }
            collisionOn = false;
            gp.ck.checkTile(this);
            
            int objectIndex = gp.ck.checkObject(this, true);
            pickUpObject(objectIndex);
            
            if(collisionOn == false){
                
                switch(direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter >13){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter =0;
            }
        }else{
            direction = "stay";
        }
        
    }
    
    public void pickUpObject(int index){
        if(index != 999){
            String objectName = gp.object[index].nama;
            
            switch(objectName){
              
                case "hole":
                    if(!gp.object[index].fake){
                        if(gp.gameState==gp.playState1){
                            gp.resetAllData();
                            gp.setupGame2();
                            gp.gameState = gp.playState2;
                        }else{
                            gp.object[index]= null;
                            gp.ui.gamefinish = true;
                            gp.gameState=gp.finishState;

                        }
                    }else{
                        gp.ui.showMessage("Fake Hole!");
                    }
                    break;
                case "tembok":
                    if(gp.gameState==gp.playState1){
                        gp.resetAllData();
                        gp.setupGame2();
                        gp.gameState = gp.playState2;
                    }else{
                        gp.object[index]= null;
                        gp.ui.gamefinish = true;
                        gp.gameState=gp.finishState;
                    }
                    break;
            }
        }
    }
    
    public void draw(Graphics2D g){
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }else if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }else if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                image = left1;if(spriteNum == 1){
                    image = left1;
                }else if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }else if(spriteNum == 2){
                    image = right2;
                }
                break;
            case "stay":
                image = stay;
        }
        g.drawImage(image, worldX,worldY, gp.tilesize, gp.tilesize,null);
        
    }
}
