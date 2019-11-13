package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.MapManager;
import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Monster extends JPanel {
    protected int HP;
    protected int maxHP;
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
        drawHealthBar(g);
    }



    public void move() {
        int j = (int) Math.ceil(this.pos.getX() / 64.0 - 0.3);
        int i = (int) Math.ceil(this.pos.getY() / 64.0 - 0.3);

        try {
            if (MapManager.mapper[i + 1].charAt(j) != '0' && checker[i+1][j] ==0) {
                //moveDown();
                this.pos.setY(this.pos.getY() + this.speed);

            }
            else if ((i > 0 && MapManager.mapper[i - 1].charAt(j) != '0' && checker[i-1][j] ==0)) {
                this.pos.setY(this.pos.getY() - this.speed);
            }
            else if (MapManager.mapper[i].charAt(j + 1) != '0' && checker[i][j+1] == 0) {
                //move right
                this.pos.setX(this.pos.getX() + this.speed);
            }

            else if (MapManager.mapper[i].charAt(j - 1) != '0' && checker[i][j-1] ==0) {
                //moveLeft()
                this.pos.setX(this.pos.getX() - this.speed);
            }
            checker[i][j] = 1;
        } catch (Exception e) {}
    }

    public Point getPosition() {
        return pos;
    }

    public void damage(int damage) {
        this.HP -= damage + this.armor;
        if (HP <=0) GameField.monsters.remove(this);
    }

    public void drawHealthBar(Graphics g) {
        final int barMaxWidth = 48;
        int barHealth = (int)Math.ceil(((double)this.HP / this.maxHP) * barMaxWidth);
        System.out.println("["+this.HP+" "+barHealth+"]");

        g.setColor(Color.gray);
        g.fillRect(((int) getPosition().getX()) + 12,
                ((int) getPosition().getY()) , barMaxWidth, 5);
        g.setColor(Color.blue);
        g.fillRect(((int) getPosition().getX()+ 12) ,
                ((int) getPosition().getY()) , barHealth, 5);

    }
}
