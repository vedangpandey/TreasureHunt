package hunt.main;

import hunt.entity.Player;
import hunt.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
     public final int originalTileSize=16;
     final int scale=3;
     public final int tileSize=originalTileSize*scale;
     public final int maxScreenCol=16;
     public final int maxScreenRow=12;
     public final int screenHeight=maxScreenRow*tileSize;
     public final int screenWidth=maxScreenCol*tileSize;


     Thread gameThread;
     final int playerSpeed=4;

    final int FPS=60;
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;

    KeyHandler kh=new KeyHandler();
    public Player player=new Player(this,kh);
    TileManager tm=new TileManager(this);

    public CollisionChecker cChecker=new CollisionChecker(this);

     public GamePanel(){
         this.setPreferredSize(new Dimension(screenWidth,screenHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
         this.addKeyListener(kh);
         this.setFocusable(true);


     }
     public void startGameThread(){
         gameThread=new Thread(this);
         gameThread.start();
     }

//
    public void run(){
         double drawInterval=1e9/FPS;
         double delta=0;
         long lastTime=System.nanoTime();
         long currentTime;
         long timer=0;
        int count=0;
         while(gameThread!=null){
             currentTime=System.nanoTime();
             delta+=(currentTime-lastTime)/drawInterval;
             timer+=(currentTime-lastTime);
//             System.out.println(delta);
             //System.out.println("Outside "+delta);
             lastTime=currentTime;
             if(delta>0){
                 //System.out.println("Inside "+delta);
                 //System.out.println("Timer "+timer);
                 update();
                 repaint();
                 delta--;
                 count++;
             }
             if(timer>(int)1e9){
                 //System.out.println("FPS : "+count);
                 count=0;
                 timer=0;
             }
         }
    }
    //update information such as character positions

    //draw the position of the character is drawn based on update
    public void update(){
         player.update();

    }


    //this is the draw component
    public void paintComponent(Graphics g){
         super.paintComponent(g);
         Graphics2D g2=(Graphics2D) g;
        tm.draw(g2);
         player.draw(g2);


    }
}
