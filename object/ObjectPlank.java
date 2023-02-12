package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectPlank extends SuperObject{
    
    public ObjectPlank() {

        name = "Plank"; 

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/plank2.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        
    }

}
