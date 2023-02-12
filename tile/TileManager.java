package tile;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import Main.GamePanel;

public class TileManager {

    GamePanel gp;
    Tile[] tile; 

    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[10];
        
        getTitleImage();
    } 

    public void getTitleImage() {
        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/PalmTree.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Sand.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water00.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water01.png"));

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null); //grass
        g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null); //Palm Tree
        g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null); //Sand
        g2.drawImage(tile[3].image, 0, 0, gp.tileSize, gp.tileSize, null); //Water (no ripple)
        g2.drawImage(tile[4].image, 720, 528, gp.tileSize, gp.tileSize, null); //Water (ripple)

    }
}