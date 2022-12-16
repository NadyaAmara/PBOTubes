package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_secondDoorleft extends Obj{

    public Obj_secondDoorleft() {
    
        nama = "secondDoor";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/gate0.png"));
        } catch (IOException e) {
            
            e.getStackTrace();
        }
        collision = true;
    }
    
    
}
