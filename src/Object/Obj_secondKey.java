package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_secondKey extends Obj{

    public Obj_secondKey() {
    
        nama = "secondKey";
        try {
          image = ImageIO.read( getClass().getResourceAsStream("../TileImage/object02.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    
}
