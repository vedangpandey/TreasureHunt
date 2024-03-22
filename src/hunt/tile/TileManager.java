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
    public Tile[] tiles;

    public int[][] mapTileNumber;

    public TileManager(GamePanel gp){
        this.gp=gp;
        mapTileNumber=new int[gp.maxWorldRow][gp.maxWorldCol];
        tiles=new Tile[10];
        getTileImage();
        loadMap("/res/maps/WorldMap01.txt");
    }
    public void getTileImage(){
        try{
            tiles[0]=new Tile();
            tiles[0].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));
            tiles[1]=new Tile();
            tiles[1].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tiles[1].collision=true;
            tiles[2]=new Tile();
            tiles[2].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
            tiles[2].collision=true;
            tiles[3]=new Tile();
            tiles[3].image= ImageIO.read(getClass().getResourceAsStream("/res/tiles/earth.png"));
            tiles[4]=new Tile();
            tiles[4].image=ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
            tiles[4].collision=true;
            tiles[5]=new Tile();
            tiles[5].image=ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));


        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public void loadMap(String filepath){
        try{
            InputStream is=getClass().getResourceAsStream(filepath);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));

            for(int i=0;i<mapTileNumber.length;i++){
                String line=br.readLine();
                String[] st=line.split(" ");
                for(int j=0;j<mapTileNumber[i].length;j++){
                    mapTileNumber[i][j]= Integer.parseInt(st[j]);
                }
                //System.out.println(Arrays.toString(mapTileNumber[i]));
            }
        }catch(Exception io){
            io.printStackTrace();
        }
    }
    public void draw(Graphics2D g){
        int worldCol=0;
        int worldRow=0;
                while(worldCol< gp.maxWorldCol&&worldRow< gp.maxWorldRow){
                    int worldX=gp.tileSize*worldCol;
                    int worldY=gp.tileSize*worldRow;
                    int screenX=worldX-gp.player.worldX+gp.player.screenX;
                    int screenY=worldY-gp.player.worldY+gp.player.screenY;
//                    System.out.println(screenX+" "+screenY);
                int k=mapTileNumber[worldRow][worldCol];
                if(worldX>=gp.player.worldX-gp.player.screenX- gp.tileSize&&
                        worldX<=gp.player.screenX+gp.player.worldX+ gp.tileSize&&
                        worldY>=gp.player.worldY-gp.player.screenY- gp.tileSize&&
                        worldY<=gp.player.worldY+gp.player.screenY+gp.tileSize)
                g.drawImage(tiles[k].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
                worldCol++;
                if(worldCol== gp.maxWorldCol){
                    worldCol=0;
                    worldRow++;
                }
                }

    }
}
