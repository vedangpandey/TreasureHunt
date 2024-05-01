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
    public int hasKey=0;

    public Player(GamePanel gp,KeyHandler kh){
        this.gp=gp;
        this.kh=kh;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        solidArea=new Rectangle(8,16,32,30);
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;

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
            //CHECK TILE COLLISION
            collisionOn=false;
            gp.cChecker.checkTile(this);

            int objIndex=gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
            //IF COLLISION IS FALSE,PLAYER CAN MOVE
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
    public void pickUpObject(int i){
        if(i!=999){
            System.out.println("i "+gp.sp[i].name);
            String objectName=gp.sp[i].name;
            switch (objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.sp[i]=null;
                    gp.ui.showMessage("You got a Key!");
                    break;
                case "Chest":
                    gp.ui.gameFinished=true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
                case "Door":
                    gp.playSE(3);
                    if(hasKey>0)
                    {
                        gp.sp[i]=null;
                        hasKey--;

                        gp.ui.showMessage("You opened The door!");
                    }
                    else
                        gp.ui.showMessage("You need a key!");
                    break;
                case "Boots":
                    gp.playSE(2);
                    speed+=2;
                    gp.sp[i]=null;
                    gp.ui.showMessage("You got a Boots!");
                    break;
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
