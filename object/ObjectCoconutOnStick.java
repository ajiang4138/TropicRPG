package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectCoconutOnStick extends SuperObject{
    
    public ObjectCoconutOnStick() {

        name = "CoconutOnStick"; 

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/CoconutOnStick.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
    }
}
