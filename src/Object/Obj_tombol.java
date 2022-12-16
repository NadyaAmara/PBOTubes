package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_tombol extends Obj{

    public Obj_tombol() {
        nama="tombol";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pintu.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
        collision=true;
    }
    
    
}
