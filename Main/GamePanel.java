package Main;

import javax.swing.JPanel;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings
    final int originalTileSize = 16; //16 x 16 tile
    final int scale = 3; //upscales

    public final int tileSize = originalTileSize * scale; //48 x 48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //768 pixels

    // World Settings
    public final int maxWorldCol = 128;
    public final int maxWorldRow = 128;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //set FPS
    int FPS = 60;

    //initialize game components
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();

    //collision + set objects
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);

    Thread gameThread; 

    //player + object
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];

    //end screen
    public endScreen endS = new endScreen(this);
    

public GamePanel() {

    //generate window
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
}

public void setUpGame() {
    aSetter.setObject();
    playMusic(1);
}

public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
}
    //runs on startup
    @Override
    public void run() {

        //update loop, redraw, limits loop

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    
public void update() {
    player.update();
}

public void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;

    tileM.draw(g2);

    for (int i = 0; i < obj.length; i++) {
        if (obj[i] != null) {
            obj[i].draw(g2, this);
        }
    }
    player.draw(g2);

    //UI
    ui.draw(g2);

    if (ui.gameFinished == true) {
        endS.draw(g2);
    }

    g2.dispose();
}

public void playMusic(int i) {
    sound.setFile(i);
    sound.play();
    sound.loop();
}

public void stopMusic() {
    sound.stop();
}

public void playSE(int i) {
    sound.setFile(i);
    sound.play();
}
}
