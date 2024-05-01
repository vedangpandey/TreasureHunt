package hunt.object;

import javax.imageio.ImageIO;

public class OBJ_BOOTS extends SuperObject {

    public OBJ_BOOTS(){
        name="Boots";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/res/object/boots.png"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
