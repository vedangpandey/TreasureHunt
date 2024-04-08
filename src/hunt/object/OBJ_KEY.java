package hunt.object;

import hunt.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

public class OBJ_KEY extends SuperObject{

    public OBJ_KEY(){
        name="key";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/object/key.png"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
