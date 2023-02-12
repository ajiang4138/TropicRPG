package Main;

import object.ObjectCoconutOnStick;
import object.ObjectHammer;
import object.ObjectPlank;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;
    }

    public void setObject() {

        //SET OBJECT IN PROPER PLACE

        gp.obj[0] = new ObjectPlank();
        gp.obj[0].worldX = 38 * gp.tileSize;
        gp.obj[0].worldY = 79 * gp.tileSize;

        //THIS IS A PADDLE
        gp.obj[1] = new ObjectCoconutOnStick();
        gp.obj[1].worldX = 51 * gp.tileSize;
        gp.obj[1].worldY = 53 * gp.tileSize;

        //THIS IS END GAME
        gp.obj[2] = new ObjectHammer();
        gp.obj[2].worldX = 83 * gp.tileSize;
        gp.obj[2].worldY = 91 * gp.tileSize;

        gp.obj[3] = new ObjectPlank();
        gp.obj[3].worldX = 51 * gp.tileSize;
        gp.obj[3].worldY = 75 * gp.tileSize;

        gp.obj[4] = new ObjectPlank();
        gp.obj[4].worldX = 65 * gp.tileSize;
        gp.obj[4].worldY = 44 * gp.tileSize;

        gp.obj[5] = new ObjectPlank();
        gp.obj[5].worldX = 58 * gp.tileSize;
        gp.obj[5].worldY = 50 * gp.tileSize;

        gp.obj[6] = new ObjectPlank();
        gp.obj[6].worldX = 82 * gp.tileSize;
        gp.obj[6].worldY = 42 * gp.tileSize;

        gp.obj[7] = new ObjectPlank();
        gp.obj[7].worldX = 66 * gp.tileSize;
        gp.obj[7].worldY = 57 * gp.tileSize;
    }
}
