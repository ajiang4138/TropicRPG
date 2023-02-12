package Main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import tile.TileManager;

public class endScreen {

    GamePanel gp;
    Simulation sim = new Simulation(5, 30);
    public int positionX;
    public int positionY;
    
    public endScreen(GamePanel gp) {
        this.gp = gp;
        }

    public void draw(Graphics2D g2) {

        BufferedImage image = null; 

        sim.update();

        for (Particle p : sim.particles) {
            positionX = (int) Math.round((48 * (86-16)) + (48 * 32 * p.xPos));
            positionY = (int) Math.round((48 * (111 - 16)) + (48 * 32 * p.yPos));

            image = TileManager.fishTile[p.type].image;
            g2.drawImage(image, 86 * 48, 111 * 48, null);
            
        }

    }
}
