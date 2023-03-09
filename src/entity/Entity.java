package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1,up2, up3, down1, down2, down3, right1, right2, right3, left1, left2, left3;
    public String direction;
    public int spriteCount = 0;
    public int spriteNum = 3;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
}
