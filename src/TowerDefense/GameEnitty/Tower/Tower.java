package TowerDefense.GameEnitty.Tower;
import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;

public abstract class Tower extends JPanel{

    protected int price;
    protected Point pos;
    protected Image im;
    protected int range;
    protected int damage;
    protected long lastFired;

    public Tower(Point pos, String fileName){
        ImageIcon imageIcon = new ImageIcon(fileName);
        this.im = imageIcon.getImage();
        this.pos= pos;
        this.lastFired = System.currentTimeMillis();
    }
    

    protected void drawRound(Graphics g) {
        g.drawOval(this.pos.getX()-range/2+32,this.pos.getY()-range/2+32 , range, range);
    }
    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
        //drawRound(g);
    }

    public abstract void fire();

    public double distance(Point from, Point to){
        return Math.sqrt(
                Math.pow((from.getX() - to.getX()), 2)
                        + Math.pow((from.getY() - to.getY()), 2)
        );
    }

    public void setPos(int x, int y) {
        this.pos.setX(x);
        this.pos.setY(y);
    }
    public Image getIm() {
        return this.im;
    }

    public int getPrice() {
        return price;
    }
}
