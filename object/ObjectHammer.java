package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectHammer extends SuperObject {

    public ObjectHammer() {

        name = "Hammer";

        try {
        image = ImageIO.read(getClass().getResourceAsStream("/Objects/Hammer.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    
    }
}
