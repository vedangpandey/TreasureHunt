package hunt.object;

import javax.imageio.ImageIO;

public class OBJ_DOOR extends SuperObject {

    public OBJ_DOOR(){
        name="Door";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/object/door.png"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        collision=true;
    }
}
