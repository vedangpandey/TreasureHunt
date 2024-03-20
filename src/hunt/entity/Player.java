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
    int x;
    int y;
    int speed;
    int spiritnum=0;
    int spiritcount=0;
    public Player(GamePanel gp,KeyHandler kh){
        this.gp=gp;
        this.kh=kh;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction="right";
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
            if (kh.upPressed) {
                direction = "up";
                y -= speed;
            } else if (kh.downPressed) {
                direction = "down";
                y += speed;
            } else if (kh.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (kh.rightPressed) {
                direction = "right";
                x += speed;
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
        g.drawImage(image,x,y,gp.tileSize, gp.tileSize,null);
        g.dispose();
    }
}
