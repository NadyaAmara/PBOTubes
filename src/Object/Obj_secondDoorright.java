package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_secondDoorright extends Obj{

    public Obj_secondDoorright() {
    
        nama = "secondDoor";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/gate1.png"));
        } catch (IOException e) {
            
            e.getStackTrace();
        }
        collision = true;
    }
    
    
}
