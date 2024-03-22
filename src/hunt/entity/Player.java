package hunt.entity;
import hunt.main.GamePanel;
import hunt.main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler kh;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp,KeyHandler kh){
        this.gp=gp;
        this.kh=kh;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        solidArea=new Rectangle(8,16,32,30);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX= (gp.tileSize*23);
        worldY=(gp.tileSize*21);
        speed=4;
        direction="up";
    }
    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_up_1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_down_1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_down_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_left_1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_left_2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_right_1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/res/player/walking/boy_right_2.png"));

        }catch(IOException io){
            io.printStackTrace();
        }
    }
    public void update(){
        if(kh.rightPressed||kh.upPressed||kh.downPressed||kh.leftPressed) {
            spiritcount++;
            if(spiritcount>12) {
                spiritnum ^= 1;
                spiritcount=0;
            }
            collisionOn=false;
            gp.cChecker.checkTile(this);
            if (kh.upPressed) {
                direction = "up";
            } else if (kh.downPressed) {
                direction = "down";
            } else if (kh.leftPressed) {
                direction = "left";
            } else if (kh.rightPressed) {
                direction = "right";
            }
            if(!collisionOn) {
                switch(direction){
                    case "up":worldY -= speed;break;
                    case "down":worldY += speed;break;
                    case "left": worldX -= speed;break;
                    case "right":worldX += speed;break;
                }
            }
        }
    }
    public void draw(Graphics2D g){
        BufferedImage image=null;
        switch (direction){
            case "up": image=spiritnum==0?up1:up2;
            break;
            case "down":image=spiritnum==0?down1:down2;break;
            case "left":image=spiritnum==0?left1:left2;break;
            case "right":image=spiritnum==0?right1:right2;break;
        }
        g.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize,null);
        g.dispose();
    }
}
