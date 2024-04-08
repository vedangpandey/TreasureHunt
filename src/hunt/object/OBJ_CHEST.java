package hunt.object;

import javax.imageio.ImageIO;

public class OBJ_CHEST extends SuperObject {
    public OBJ_CHEST(){
        name="Chest";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/object/chest.png"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
