package hunt.main;

import hunt.object.OBJ_CHEST;
import hunt.object.OBJ_DOOR;
import hunt.object.OBJ_KEY;

public class Asset_Setter {
    GamePanel gp;
    Asset_Setter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        gp.sp[0]=new OBJ_KEY();
        gp.sp[0].worldX= 23*gp.tileSize;
        gp.sp[0].worldY=7*gp.tileSize;

        gp.sp[1]=new OBJ_KEY();
        gp.sp[1].worldX= 23*gp.tileSize;
        gp.sp[1].worldY=40*gp.tileSize;

        gp.sp[2]=new OBJ_KEY();
        gp.sp[2].worldX= 37*gp.tileSize;
        gp.sp[2].worldY=7*gp.tileSize;

        gp.sp[3]=new OBJ_DOOR();
        gp.sp[3].worldX= 10*gp.tileSize;
        gp.sp[3].worldY=11*gp.tileSize;

        gp.sp[4]=new OBJ_DOOR();
        gp.sp[4].worldX= 8*gp.tileSize;
        gp.sp[4].worldY=28*gp.tileSize;

        gp.sp[5]=new OBJ_DOOR();
        gp.sp[5].worldX= 12*gp.tileSize;
        gp.sp[5].worldY=22*gp.tileSize;


        gp.sp[6]=new OBJ_CHEST();
        gp.sp[6].worldX= 10*gp.tileSize;
        gp.sp[6].worldY=7*gp.tileSize;







    }
}
