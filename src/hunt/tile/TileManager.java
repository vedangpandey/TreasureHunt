package hunt.tile;

import hunt.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TileManager {
    GamePanel gp;
    Tile[] tiles;

    int[][] mapTileNumber;

    public TileManager(GamePanel gp){
        this.gp=gp;
        mapTileNumber=new int[gp.maxScreenRow][gp.maxScreenCol];
        tiles=new Tile[10];
        getTileImage();
        loadMap("/res/maps/Map01.txt");
    }
    public void getTileImage(){
        try{
            tiles[0]=new Tile();
            tiles[0].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));
            tiles[1]=new Tile();
            tiles[1].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tiles[2]=new Tile();
            tiles[2].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
            tiles[3]=new Tile();
            tiles[3].image= ImageIO.read(getClass().getResourceAsStream("res/tiles/earth.png"));
            tiles[4]=new Tile();
            tiles[4].image=ImageIO.read(getClass().getResourceAsStream("res/tiles/tree.png"));
            tiles[5]=new Tile();
            tiles[5].image=ImageIO.read(getClass().getResourceAsStream("res/tiles/sand.png"));


        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public void loadMap(String filepath){
        try{
            InputStream is=getClass().getResourceAsStream(filepath);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));

            for(int i=0;i<gp.maxScreenRow;i++){
                String line=br.readLine();
                String[] st=line.split(" ");
                for(int j=0;j<gp.maxScreenCol;j++){
                    mapTileNumber[i][j]= Integer.parseInt(st[j]);
                }
                System.out.println(Arrays.toString(mapTileNumber[i]));
            }
        }catch(Exception io){
            io.printStackTrace();
        }
    }
    public void draw(Graphics2D g){
        int col=0;
        int row=0;
        for(int i=0;i<gp.maxScreenRow;i++){
            for(int j=0;j<gp.maxScreenCol;j++){
                int k=mapTileNumber[i][j];
                g.drawImage(tiles[k].image,(48*j),(48*i),48,48,null);
            }
        }
    }
}
