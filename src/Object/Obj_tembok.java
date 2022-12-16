package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_tembok extends Obj{

    public Obj_tembok() {
    
        nama="tembok";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/tembok1.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
        collision = true;
    }
    
    
}
