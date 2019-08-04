package game;

import java.awt.*;

public class Plane extends GameObject {
    @Override
    public void drawSelf(Graphics g) {
        super.drawSelf(g);
    }

    public Plane(Image img,double x,double y) {
        this.img=img;
        this.x=x;
        this.y=y;
    }
}
