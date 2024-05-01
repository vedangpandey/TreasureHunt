package hunt.main;

import hunt.object.OBJ_KEY;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font Arial_40,Arial_80B;
    BufferedImage keyImage;
    public boolean messageOn=false;
    public String message="";
    int messageCounter=0;
    public boolean gameFinished=false;
    double playTime=0;
    DecimalFormat df=new DecimalFormat("0.00");
    public UI(GamePanel gp){
        this.gp=gp;
        Arial_40=new Font("Arial",Font.PLAIN,40);
        Arial_80B=new Font("Arial",Font.BOLD,80);
        OBJ_KEY obj_key=new OBJ_KEY();
        keyImage=obj_key.image;
    }
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        if(gameFinished == true){
            messageOn=false;
            g2.setFont(Arial_40);
            g2.setColor(Color.WHITE);
            String text;
            int x;
            int y;
            int textLength;
            text="You found The treasure";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenWidth/2 -textLength/2;
            y=gp.screenHeight/2- (gp.tileSize*3);
            g2.drawString(text,x,y);
            text="Your time is = "+df.format(playTime)+"!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenWidth/2 -textLength/2;
            y=gp.screenHeight/2+ (gp.tileSize*4);
            g2.drawString(text,x,y);
            g2.setFont(Arial_80B);
            g2.setColor(Color.yellow);
            text="Congratulations!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenWidth/2 -textLength/2;
            y=gp.screenHeight/2+ (gp.tileSize*2);
            g2.drawString(text,x,y);
            gp.gameThread=null;
            new NameEnter((int)playTime);
        }
        playTime+=(double)1/60;
        g2.setFont(Arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
        g2.drawString("x "+gp.player.hasKey,74,64);
        g2.drawString("Time = "+df.format(playTime),gp.tileSize*11,gp.tileSize+5);
        if(messageOn == true){
            g2.setFont(g2.getFont().deriveFont(30f));
            g2.drawString(message,gp.tileSize/2,gp.tileSize*5);
            messageCounter++;
            if(messageCounter>120){
                messageCounter=0;
                messageOn=false;
            }
        }
    }
}
