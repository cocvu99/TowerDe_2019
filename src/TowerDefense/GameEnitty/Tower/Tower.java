package TowerDefense.GameEnitty.Tower;
import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;
import TowerDefense.GameEnitty.Tower.Bullet.Arrow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends JPanel{

    protected int price;
    protected Point pos;
    protected Image im;
    protected int range;

    public Tower(Point pos, String fileName){
        ImageIcon imageIcon = new ImageIcon(fileName);
        this.im = imageIcon.getImage();
        this.pos= pos;
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
    }


    public double distance(Point from, Point to){
        return Math.sqrt(
                Math.pow((from.getX() - to.getX()), 2)
                        + Math.pow((from.getY() - to.getY()), 2)
        );
    }

    public void fire() {
        List<Monster> monsters = new ArrayList<Monster>();
        for (int i = monsters.size()-1; i>=0 ;i--) {
            if (distance(monsters.get(i).getPosition(), this.pos) < (double)range) {
                GameField.bullets.add(new Arrow(this.pos, monsters.get(i).getPosition()));
            }
        }
    }

}
