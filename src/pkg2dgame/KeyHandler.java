package pkg2dgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upPressed,downPressed,leftPressed,rightPressed;
    GamePanel gp;
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        int code = ke.getKeyCode();
        if(gp.gameState ==gp.menuState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=2;
                }
                
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum=0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    if(gp.player.name.compareToIgnoreCase("")==0){
                        gp.ui.drawProfilState();
                    }
                    gp.gameState = gp.playState1;                
                    gp.setupGame();
                }
                if(gp.ui.commandNum==1){
                    gp.gameState = gp.scoreState;
                }
                if(gp.ui.commandNum==2){
                    System.exit(0);
                }
            }
        }else if(gp.gameState ==gp.gameoverState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
                
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState = gp.menuState;
                    gp.resetAllData();
                }
                if(gp.ui.commandNum==1){
                    System.exit(0);
                }
            }
        }else if(gp.gameState == gp.finishState || gp.gameState == gp.scoreState){
            if(code == KeyEvent.VK_ENTER){
                gp.gameState=gp.menuState;
            }
        }else{
            if(code == KeyEvent.VK_W){
            upPressed = true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed = true;
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int code = ke.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
    
}
