package Main;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;

import object.ObjectPlank;

public class UI {
    
    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage plankImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;

    public boolean gameFinished = false;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    
        ObjectPlank plank = new ObjectPlank();
        plankImage = plank.image;

    }

    public void showMessage(String text) {
        message = text; 
        messageOn = true;
    }
    
    public void draw(Graphics2D g2) {

        if (gameFinished == true) {


            g2.setFont(arial_40);
            g2.setColor(Color.black);

            String text;
            int textLength;
            int x;
            int y;

            text = "You Escaped!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 3);

            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);

            text = "Congratulations!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);

            g2.drawString(text, x, y);
        
    }
        
        else {
        g2.setFont(arial_40);
        g2.setColor(Color.black);
        g2.drawImage(plankImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.hasPlank, 76, 60);

        if (messageOn == true) {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize/2, gp.tileSize * 5);

            messageCounter++;

            if (messageCounter > 240) {
                messageCounter = 0;
                messageOn = false;
            }
        }
    }
}
}
