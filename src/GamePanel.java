import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
     final int originalTileSize=16;
     final int scale=3;
     final int tileSize=originalTileSize*scale;
     final int maxScreenCol=16;
     final int maxScreeenRow=12;
     final int screenHeight=maxScreeenRow*tileSize;
     final int screenWidth=maxScreenCol*tileSize;

     Thread gameThread;
     public GamePanel(){
         this.setPreferredSize(new Dimension(screenWidth,screenHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);


     }
     public void startGameThread(){
         gameThread=new Thread(this);
         gameThread.start();
     }

    @Override
    public void run() {
         while(gameThread!=null)
             System.out.println("Game loop is running");
    }
}
