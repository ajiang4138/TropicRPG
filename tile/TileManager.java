package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import Main.GamePanel;

public class TileManager {

    GamePanel gp;
    public Tile[] tile; 
    public static Tile[] fishTile;
    public int mapTileNum[][];

    //initializes on startup
    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        fishTile = new Tile[10];
        
        getTileImage();
        loadMap("/maps/world.txt");
    } 

    public void getTileImage() {
        //places tiles in an array for usage
        try {

            //CREATE MORE TILES !!!
            //Check collision

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water00.png"));
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water01.png"));
            tile[1].collision = true;

            tile[2] = new Tile();   
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater2.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater1.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater3.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater4.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater5.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater6.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater7.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandWater8.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Sand.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Sand2.png"));
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass1.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass2.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass3.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass4.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass5.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass6.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass7.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandGrass8.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Grass.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Grass2.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock1.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock2.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock3.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock4.png"));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock5.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock6.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock7.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GrassRock8.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Rock.png"));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Rock2.png"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock1.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock2.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock3.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock4.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock5.png"));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock6.png"));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock7.png"));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/SandRock8.png"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/PalmTree.png"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Tree2.png"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/raft.png"));
            tile[42].collision = false;

            fishTile[0] = new Tile();
            fishTile[0].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/fish/Bfish.png"));

            fishTile[1] = new Tile();
            fishTile[1].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/fish/Crab.png"));

            fishTile[2] = new Tile();
            fishTile[2].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/fish/Fish.png"));

            fishTile[3] = new Tile();
            fishTile[3].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/fish/Jellyfish.png"));

            fishTile[4] = new Tile();
            fishTile[3].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/fish/Shrimp.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    //reads text files, generates map
    public void loadMap(String filePath) {
        
        //LOAD WORLD MAP
        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch(Exception e) {

        }

    }
    
    //draws the maps
    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;


            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
                worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++; 
            }

        }
    }
}