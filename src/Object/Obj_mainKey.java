package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_mainKey extends Obj{

    public Obj_mainKey() {
    
        nama = "mainKey";
        try {
          image = ImageIO.read( getClass().getResourceAsStream("../TileImage/object01.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    
}
