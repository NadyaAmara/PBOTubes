package Tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import pkg2dgame.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        
        this.gp = gp;
        tile = new Tile[50];
        mapTileNum = new int[gp.maxworldcol][gp.maxworldrow];
        String url = "../TileImage/worldMap1.txt";
        setMap(url);
        
    }
    
    public void setMap(String url){   
        getTileImage();
        loadImage(url);
    }
    
    
    public void loadImage(String url){
        
        try {
            
            InputStream io = getClass().getResourceAsStream(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(io));
            
            int col = 0;
            int row = 0;
            
            while(col<gp.maxworldcol && row<gp.maxworldcol){
                String line = br.readLine();
                
                while(col<gp.maxworldcol){
                    
                    String number[] = line.split(" ");
                    
                    int num = Integer.parseInt(number[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxworldcol){
                    col =0;
                    row++;
                }
                
            }
            
        } catch (Exception e) {
            
        }
        
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/tembok2.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/tembok4.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/tembok3.png"));
            tile[2].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pohon1.png"));
            tile[3].collision = true;
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pohon0.png"));
            tile[4].collision = true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu0.png"));
            tile[5].collision = true;
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu1.png"));
            tile[6].collision = true;
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu2.png"));
            tile[7].collision = true;
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu3.png"));
            tile[8].collision = true;
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu5.png"));
            tile[9].collision = true;
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu4.png"));
            tile[10].collision = true;
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumahhantu6.png"));
            tile[11].collision = true;
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pohon2.png"));
            tile[12].collision = true;
            
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pohon3.png"));
            tile[13].collision = true;
            
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumput_atas.png"));
            
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumput_bawah.png"));
            
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumput_kiri.png"));
            
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumput_kanan.png"));
            
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pantai_atas.png"));
            tile[18].collision = true;
            
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pantai_bawah.png"));
            tile[19].collision = true;
            
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pantai_kiri.png"));
            tile[20].collision = true;
            
            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/pantai_kanan.png"));
            tile[21].collision = true;
            
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/laut.png"));
            tile[22].collision = true;
            
            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("../TileImage/rumput.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g){
        int worldcol = 0;
        int worldrow = 0;

        
        while(worldcol<gp.maxworldcol && worldrow<gp.maxworldrow){
            
            int worldX = worldcol * gp.tilesize; 
            int worldY = worldrow * gp.tilesize; 
            
//            if(worldX > gp.player.worldX - gp.player.eyes &&
//               worldX <    gp.player.worldX + gp.player.eyes  &&
//               worldY > gp.player.worldY -gp.player.eyes &&
//               worldY< gp.player.worldY + gp.player.eyes){
//                g.drawImage(tile[mapTileNum[worldcol][worldrow]].image, screeenX, screeenY, gp.tilesize,gp.tilesize,null);
//            }
            
            g.drawImage(tile[mapTileNum[worldcol][worldrow]].image, worldX, worldY, gp.tilesize,gp.tilesize,null);
            
            worldcol++;
            if(worldcol == gp.maxworldcol){
                worldcol = 0;
                worldrow++;
            }
        }
        
    }
   
}
