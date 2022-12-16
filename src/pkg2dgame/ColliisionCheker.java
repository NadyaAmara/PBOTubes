package pkg2dgame;

import Entity.Entity;
import Object.Obj;
 
public class ColliisionCheker {
    
    
    GamePanel gp;

    public ColliisionCheker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTileObject(Entity player,Obj object){
        int LeftX = object.x;
        int rightX = object.x + gp.tilesize -3;
        int topY = object.y;
        int bottomY = object.y + gp.tilesize;
        
        int leftcol = LeftX/gp.tilesize;
        int rightcol = rightX/gp.tilesize;
        int toprow = topY/gp.tilesize;
        int bottomrow = bottomY/gp.tilesize;
        
        int tileNum1, tileNum2, objectNum1, objectNum2;
        
        switch(player.direction){
            case "up":
                toprow = (topY - player.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[leftcol][toprow];
                tileNum2 = gp.tile.mapTileNum[rightcol][toprow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    object.collisionOn = true; 
                }
                break;
            case "down":
                bottomrow =(bottomY + player.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[leftcol][bottomrow];
                tileNum2 = gp.tile.mapTileNum[rightcol][bottomrow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    object.collisionOn = true;
                }
                break;
            case "right":
                rightcol =(rightX + player.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[rightcol][toprow];
                tileNum2 = gp.tile.mapTileNum[rightcol][bottomrow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    object.collisionOn = true;
                }
                break;
            case "left":
                leftcol =(LeftX - player.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[leftcol][toprow];
                tileNum2 = gp.tile.mapTileNum[leftcol][bottomrow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    object.collisionOn = true;
                }
                break;
        }
    }
    
    public void checkTile(Entity entity){
        
        int LeftX = entity.worldX + 5;
        int rightX = entity.worldX + gp.tilesize;
        int topY = entity.worldY + 8;
        int bottomY = entity.worldY + gp.tilesize;
        
        int leftcol = LeftX/gp.tilesize;
        int rightcol = rightX/gp.tilesize;
        int toprow = topY/gp.tilesize;
        int bottomrow = bottomY/gp.tilesize;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
            case "up":
                toprow = (topY - entity.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[leftcol][toprow];
                tileNum2 = gp.tile.mapTileNum[rightcol][toprow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                
                break;
            case "down":
                bottomrow =(bottomY + entity.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[leftcol][bottomrow];
                tileNum2 = gp.tile.mapTileNum[rightcol][bottomrow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                rightcol =(rightX + entity.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[rightcol][toprow];
                tileNum2 = gp.tile.mapTileNum[rightcol][bottomrow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                leftcol =(LeftX - entity.speed)/gp.tilesize;
                tileNum1 = gp.tile.mapTileNum[leftcol][toprow];
                tileNum2 = gp.tile.mapTileNum[leftcol][bottomrow];
                if(gp.tile.tile[tileNum1].collision == true || gp.tile.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
                
        }
        
    }
    
    public int checkObject(Entity entity, boolean player){
        int index = 999;
            for(int i=0;i<gp.object.length;i++){

                if(gp.object[i] != null){

                    //get entity solid area
                    entity.solidArea.x = entity.worldX + entity.solidArea.x;
                    entity.solidArea.y = entity.worldY + entity.solidArea.y;
                    //get object solid area
                    gp.object[i].solidArea.x = gp.object[i].x + gp.object[i].solidArea.x;
                    gp.object[i].solidArea.y = gp.object[i].y + gp.object[i].solidArea.y;

                    switch(entity.direction){
                        case "up":
                            entity.solidArea.y -= entity.speed;
                            if(entity.solidArea.intersects(gp.object[i].solidArea)){
                                if(gp.object[i].collision){
                                    entity.collisionOn = true;
                                }
                                if(player){
                                    index = i;
                                }
                            }
                            break;
                        case "down":
                            entity.solidArea.y += entity.speed;
                            if(entity.solidArea.intersects(gp.object[i].solidArea)){
                                if(gp.object[i].collision){
                                    entity.collisionOn = true;
                                }
                                if(player){
                                    index = i;
                                }
                            }
                            break;
                        case "right":
                            entity.solidArea.x += entity.speed;
                            if(entity.solidArea.intersects(gp.object[i].solidArea)){
                                if(gp.object[i].collision){
                                    entity.collisionOn = true;
                                }
                                if(player){
                                    index = i;
                                }
                            }
                            break;
                        case "left":
                            entity.solidArea.x -= entity.speed;
                            if(entity.solidArea.intersects(gp.object[i].solidArea)){
                                if(gp.object[i].collision){
                                    entity.collisionOn = true;
                                }
                                if(player){
                                    index = i;
                                }
                            }
                            break;
                    }
                    entity.solidArea.x = entity.solidAreaDefaultX;
                    entity.solidArea.y = entity.solidAreaDefaultY;
                    gp.object[i].solidArea.x = gp.object[i].solidAreaDefaultX;
                    gp.object[i].solidArea.y = gp.object[i].solidAreaDefaultY;

                }
            }
        return index;
    }
    
}
