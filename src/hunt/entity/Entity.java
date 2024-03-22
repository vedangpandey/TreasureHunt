package hunt.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;
    public int spiritnum=0;
    public int spiritcount=0;
    public Rectangle solidArea;
    public boolean collisionOn;


}
