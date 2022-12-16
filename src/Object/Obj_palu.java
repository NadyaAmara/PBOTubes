package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_palu extends Obj{

    public Obj_palu() {
    
        nama="palu";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/palu.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    
    
}
