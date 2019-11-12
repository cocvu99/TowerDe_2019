package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;

public abstract class Monster extends JPanel {
    protected int HP;
    protected int speed;
    protected int armor;
    protected int reward;
    protected int Direction;
    protected Point pos;
    protected Image im;

    public Monster(Point pos, String path){
        ImageIcon imageIcon = new ImageIcon(path);
        im = imageIcon.getImage();
        this.pos = pos;
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
    }

    public void move() {
        this.pos.setX(this.pos.getX() + this.speed);
        this.pos.setY(this.pos.getY() + this.speed);
    }
}
