package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_balok extends Obj{

    public Obj_balok() {
        int posisitionX = x,positionY=y;
        nama="balok";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/lantai.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
        collision = true;
    }
    
    
}
