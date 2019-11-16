package TowerDefense.GameEnitty.Map;

import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GamePlay.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Target extends MapObject {


    public Target(Point pos) {
        ImageIcon icon =  new ImageIcon("res/map/target.png");
        this.im = icon.getImage();
        this.pos    = pos;
    }

    public void paint(Graphics g) {
        g.drawImage(this.im, this.pos.getX(), this.pos.getY(), this);
    }

    public boolean isTouched(Monster mon) {
        Rectangle2D.Double targetArea = new Rectangle2D.Double(this.pos.getX(),this.pos.getY(),64,64);
        if (targetArea.contains(new java.awt.Point(mon.getCentre().getX()+32, mon.getCentre().getY()+32))) {
            Player.Heart--;
            Player.monsters.remove(mon);
            return true;
        }
        return false;
    }
}
