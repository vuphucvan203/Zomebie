package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font arial_30;
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_30 = new Font("Arial", Font.PLAIN, 30);
    }

    public void draw(Graphics2D g2)
    {
        g2.setFont(arial_30);
        g2.setColor(Color.white);
        g2.drawString("Jonh",20,40);
    }

}
