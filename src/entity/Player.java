package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.entitySize/2);
        screenY = gp.screenHeigh/2 - (gp.entitySize/2);

        solidArea = new Rectangle();
        solidArea.x = 57;
        solidArea.y = 92;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 28;
        solidArea.height = 46;
        setDefaultValue();
        getPlayerImgage();
    }

    public void setDefaultValue() {
        worldX = gp.tileSize * 20;
        worldY = gp.tileSize * 20;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImgage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/JonhUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/JonhUp2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/JonhUp3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/JonhDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/JonhDown2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/JonhDown3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/JonhRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/JonhRight2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/JonhRight3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/JonhLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/JonhLeft2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/JonhLeft3.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed == true || keyH.downPressed ==true
                || keyH.rightPressed == true || keyH.leftPressed == true)
        {
            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLISITON
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
//            openDoor(objIndex);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false)
            {
                switch (direction)
                {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }
            spriteCount++;
            if(spriteCount > 10)
            {
                if( spriteNum == 1)
                {
                    spriteNum = 3;
                    if(spriteNum == 2)
                    {
                        spriteNum = 1;
                    }

                }
                else if( spriteNum == 1 || spriteNum == 3)
                {
                    spriteNum = 2;
                    if(spriteNum == 3)
                    {
                        spriteNum = 1;
                    }
                }
                else if(spriteNum == 2 || spriteNum == 3)
                {
                    spriteNum = 1;
                    if(spriteNum == 2)
                    {
                        spriteNum = 3;
                    }
                }
                spriteCount = 0;
            }
        }
        else if(keyH.upPressed == false || keyH.downPressed == false
                || keyH.leftPressed == false || keyH.rightPressed == false)
        {
            spriteNum = 1;
        }
    }
    public void pickUpObject(int i)
    {
        if(i != 999)
        {
            String objectName = gp.obj[i].name;
            if(objectName == "Axe")
            {
//                gp.playSE(1);
                gp.obj[i] = null;

            }
            if(objectName == "Door")
            {
//                gp.playSE(2);
                gp.obj[i] = null;
            }

//            switch(objectName)
//            {
//                case "Axe":
//                    hasKey++;
//                    gp.obj[i] = null;
//                    System.out.println("Key:"+hasKey);
//                    break;
//                case "Door":
//                    if(hasKey > 0)
//                    {
//                        gp.obj[i] = null;
//                        hasKey--;
//                    }
//                    System.out.println("Key:"+hasKey);
//                    break;
//            }
        }
    }
//    public void openDoor(int i)
//    {
//        String objectName = gp.obj[i].name;
//        if(objectName == "Door")
//        {
//            gp.playSE(2);
//            gp.obj[i] = null;
//        }
//    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                if(spriteNum == 3)
                {
                    image = up3;
                }
                break;
            case "down":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                if(spriteNum == 3)
                {
                    image = down3;
                }
                break;
            case "left":
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum == 2)
                {
                    image = left2;
                }
                if(spriteNum == 3)
                {
                    image = left3;
                }
                break;
            case "right":
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum == 2)
                {
                    image = right2;
                }
                if(spriteNum == 3)
                {
                    image = right3;
                }
                break;
        }
        g2.drawImage(image,screenX,screenY,gp.entitySize,gp.entitySize,null);
    }
}


