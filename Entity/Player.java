package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.Simulation;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public int hasPlank = 0;
    public int hasWeapon = 0;

    public final int screenX;
    public final int  screenY;

    public Simulation sim;

    //initializes on start
    public Player(GamePanel gp, KeyHandler keyH) {

        sim = new Simulation(5, 30);

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        //set player defaults
        worldX = 48 * 57;
        worldY = 48 * 87;

        //change back to 6
        speed = 6;

        direction = "down";
    }

    public void getPlayerImage() {
        
        //movement animations
        if (hasWeapon == 0 ) {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/player/boy_right_2.png"));

            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void update() {

        //player movement on the world map

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) { 

        if (keyH.upPressed == true) {
            direction = "up";
            
        }   

        else if (keyH.downPressed == true) {
            direction = "down";
        
        }
    
        else if (keyH.leftPressed == true) {
            direction = "left";
         }

        else if (keyH.rightPressed == true) {
            direction = "right";
        }

        //tile collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //object collision
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        


        //if no collision:
        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        

        spriteCounter++;
        if (spriteCounter > 15) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    
    gameWon();
    }

    public void pickUpObject(int i) {
        if (i != 999) {

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Plank":
                    hasPlank++;
                    gp.obj[i] = null;
                    gp.playSE(2);
                    gp.ui.showMessage("Picked Up Plank!");
                    break;
                case "CoconutOnStick":
                    hasWeapon++;
                    gp.obj[i] = null;
                    gp.playSE(2);
                    gp.ui.showMessage("Picked Up Paddle!");
                    break;
                case "Hammer":
                    if (hasPlank < 6) {
                        gp.ui.showMessage("You need " + (6 - hasPlank) + " planks to build a boat!");
                    }
                    else if (hasWeapon < 1) {
                        gp.ui.showMessage("You need a paddle!");
                    }
                    else {
                        gp.ui.gameFinished = true;
                        gp.stopMusic();
                        gp.playSE(3);
                        break;
                    }
            }

        }
    }

    //Sets the player to be in the moved location
    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        
        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

    public void gameWon() {
        if (gp.ui.gameFinished == true) {
            worldX = 48 * 86;
            worldY = 48 * 111;          
                
            }

        }
    }
