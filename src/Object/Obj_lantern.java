/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class Obj_lantern extends Obj{

    public Obj_lantern() {
        nama = "lantern";
        try {
          image = ImageIO.read( getClass().getResourceAsStream("../TileImage/object00.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }   
}
