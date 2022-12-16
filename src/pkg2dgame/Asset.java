package pkg2dgame;

import Object.Obj;
import Object.Obj_hole;

public class Asset {
    GamePanel gp;

    public Asset(GamePanel gp) {
        this.gp = gp;
    }
    
    public void createObject(Obj object,int x,int y, int i){
        gp.object[i] = object;
        gp.object[i].x = x * gp.tilesize;
        gp.object[i].y = y * gp.tilesize;
        if(gp.object[i].nama.compareToIgnoreCase("balok")==0){
            gp.object[i].defauldX = x * gp.tilesize;
            gp.object[i].defauldY = y * gp.tilesize;
        }
                                                                                                                      
    }
    
    public void setObjectScreen2(){
        createObject(new Obj_hole(true), 14, 3, 0);
        createObject(new Obj_hole(true), 5, 15, 1);
        createObject(new Obj_hole(true), 5, 9, 2);
        createObject(new Obj_hole(true), 5, 7, 3);
        createObject(new Obj_hole(true), 5, 26, 4);
        createObject(new Obj_hole(true), 13, 13, 5);
        createObject(new Obj_hole(true), 16, 3, 6);
        createObject(new Obj_hole(true), 19, 27, 7);
        createObject(new Obj_hole(true), 17, 25, 8);
        createObject(new Obj_hole(true), 18, 21, 9);
        createObject(new Obj_hole(true), 22, 11, 10);
        createObject(new Obj_hole(true), 21, 13, 11);
        createObject(new Obj_hole(true), 32, 5, 12);
        createObject(new Obj_hole(true), 38, 26, 13);
        createObject(new Obj_hole(true), 28, 27, 14);
        createObject(new Obj_hole(true), 26, 23, 15);
        createObject(new Obj_hole(false), 38, 3, 16);
        createObject(new Obj_hole(true), 29, 14, 17);
        createObject(new Obj_hole(true), 31, 22, 18);
    }
    
    public void setObjectScreen1(){  
        createObject(new Obj_hole(true), 12, 12, 0);
        createObject(new Obj_hole(true), 10, 11, 1);
        createObject(new Obj_hole(true), 10, 14, 2);
        createObject(new Obj_hole(true), 18, 12, 3);
        createObject(new Obj_hole(true), 24, 18, 4);
        createObject(new Obj_hole(true), 37, 12, 5);
        createObject(new Obj_hole(false), 34, 4, 6);
    }
}
