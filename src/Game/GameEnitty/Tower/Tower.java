package Game.GameEnitty.Tower;
import Game.GameEnitty.Point;

import javax.swing.*;
import java.awt.*;

public abstract class Tower {
    protected int HP;
    protected int speed;
    protected int range;
    protected int damage;
    protected int price;
    protected Point pos;
    protected Image im;


    public Tower(int x, int y){
        ImageIcon imageIcon = new ImageIcon("image/tower1.png");
        this.im = imageIcon.getImage();
        this.pos.setX(x);
        this.pos.setY(y);
    }

    public void paint(Graphics g){
        g.drawImage(im,pos.getX(),pos.getY(),null);
    }


}
