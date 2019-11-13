package TowerDefense.GameEnitty.Tower;
import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;

public abstract class Tower extends JPanel{
    protected int speed;
    protected int range;
    protected int damage;
    protected int price;
    protected Point pos;
    protected Image im;


    public Tower(Point pos, String fileName){
        ImageIcon imageIcon = new ImageIcon(fileName);
        this.im = imageIcon.getImage();
        this.pos= pos;
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
    }


}
