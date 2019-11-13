package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.MapManager;
import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;

public abstract class Monster extends JPanel {
    protected int HP;
    protected int speed;
    protected int armor;
    protected int reward;
    protected Image im;

    protected int Direction;
    protected Point pos;

    protected int[][] checker =new int[12][16];

    public Monster(Point pos, String path){
        ImageIcon imageIcon = new ImageIcon(path);
        im = imageIcon.getImage();
        this.pos = pos;
        for (int i =1; i<12; i++)
            for (int j =0; j<16; j++)
                checker[i][j] = 0;
    }

    public void paint(Graphics g) {
        g.drawImage(im, pos.getX(), pos.getY(), this);
    }



    public void move() {
        int j = (this.pos.getX()) / 64 ;
        int i = (this.pos.getY()) / 64 ;

        try {
            if (MapManager.mapper[i].charAt(j + 1) != '0' && checker[i][j+1] == 0) {
                //move right
                this.pos.setX(this.pos.getX() + this.speed);
            }
            else if (MapManager.mapper[i + 1].charAt(j) != '0' && checker[i+1][j] ==0) {
                //moveDown();
                this.pos.setY(this.pos.getY() + this.speed);
            }
            else if (MapManager.mapper[i - 1].charAt(j) != '0' && checker[i-1][j] ==0) {
                System.out.println("up");
                this.pos.setY(this.pos.getY() - this.speed);
            }
            else if (MapManager.mapper[i].charAt(j - 1) != '0' && checker[i][j-1] ==0) {
                //moveLeft()
                this.pos.setX(this.pos.getX() - this.speed);
            }
            checker[i][j] = 1;
        } catch (Exception e) {}
    }
}
