package main;

import object.OBJ_Chest;
import object.OBJ_Door;

public class AccessSetter {

    GamePanel gp;

    public AccessSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        gp.obj[0] = new OBJ_Door();
        gp.obj[0].worldX = 15 * gp.tileSize;
        gp.obj[0].worldY = 15 * gp.tileSize;

        gp.obj[1] = new OBJ_Chest();
        gp.obj[1].worldX = 20 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;

        gp.obj[2] = new OBJ_Chest();
        gp.obj[2].worldX = 21 * gp.tileSize;
        gp.obj[2].worldY =  20 * gp.tileSize;
    }

}
