/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class Obj_hole extends Obj{
    public Obj_hole(boolean f){
        nama = "hole";
        fake = f;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../TileImage/hole.png"));
        } catch (IOException e) {
            
            e.getStackTrace();
        }
        collision = true;
    }
}
