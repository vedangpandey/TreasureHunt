package hunt.main;

import hunt.entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp=gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX=gp.player.worldX+gp.player.solidArea.x;
        int entityRightWorldX=gp.player.worldX+gp.player.solidArea.x+gp.player.solidArea.width;
        int entityTopWorldY=gp.player.worldY+gp.player.solidArea.y;
        int entityBottomWorldY=gp.player.worldY+gp.player.solidArea.y+gp.player.solidArea.height;

        int entityLeftCol=entityLeftWorldX/gp.tileSize;
        int entityRightCol=entityRightWorldX/ gp.tileSize;
        int entityTopRow=entityTopWorldY/gp.tileSize;
        int entityBottomRow=entityBottomWorldY/ gp.tileSize;
        int tilenum1,tilenum2;
        switch (entity.direction){
            case "up":
                entityTopRow=(entityTopWorldY-entity.speed)/gp.tileSize;
                tilenum1=gp.tm.mapTileNumber[entityTopRow][entityLeftCol];
                tilenum2=gp.tm.mapTileNumber[entityTopRow][entityRightCol];
                if(gp.tm.tiles[tilenum1].collision||gp.tm.tiles[tilenum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;
            case "down":entityBottomRow=(entityBottomWorldY+entity.speed)/gp.tileSize;
                tilenum1=gp.tm.mapTileNumber[entityBottomRow][entityLeftCol];
                tilenum2=gp.tm.mapTileNumber[entityBottomRow][entityRightCol];
                if(gp.tm.tiles[tilenum1].collision||gp.tm.tiles[tilenum2].collision)
                {
                    entity.collisionOn=true;
                }
            break;
            case "left":
                entityLeftCol=(entityLeftWorldX-entity.speed)/gp.tileSize;
                tilenum1=gp.tm.mapTileNumber[entityTopRow][entityLeftCol];
                tilenum2=gp.tm.mapTileNumber[entityBottomRow][entityLeftCol];
                if(gp.tm.tiles[tilenum1].collision||gp.tm.tiles[tilenum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol=(entityRightWorldX+entity.speed)/gp.tileSize;
                tilenum1=gp.tm.mapTileNumber[entityTopRow][entityRightCol];
                tilenum2=gp.tm.mapTileNumber[entityBottomRow][entityRightCol];
                if(gp.tm.tiles[tilenum1].collision||gp.tm.tiles[tilenum2].collision)
                {
                    entity.collisionOn=true;
                }
                break;
        }

    }
}
