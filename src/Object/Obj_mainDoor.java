package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_mainDoor extends Obj{

    public Obj_mainDoor() {
    
        nama = "mainDoor";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu1.png"));
        } catch (IOException e) {
            
            e.getStackTrace();
        }
        collision = true;
    }
    
    
}
