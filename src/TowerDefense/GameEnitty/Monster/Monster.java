package TowerDefense.GameEnitty.Monster;

import TowerDefense.GameEnitty.Map.GameMap;
import TowerDefense.GamePlay.GameFrame;
import TowerDefense.GamePlay.Player;
import TowerDefense.GameEnitty.Map.MapManager;
import TowerDefense.GameEnitty.Map.Point;

import javax.swing.*;
import java.awt.*;

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
        //g.drawRect(pos.getX(), pos.getY(), 64, 64);
    }

    public void move() throws Exception{
        if (MapManager.target.isTouched(this)) return;

        int j = (this.pos.getX() + 32)/ 64;
        int i = (this.pos.getY() + 32)/ 64;

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

    public void Remove() {

        Player.monsters.remove(this);

        if (Player.monsters.isEmpty()) {
            Player.bullets.clear();
            GameFrame.GAME_LEVEL++;
            GameFrame.gameState = GameFrame.GameState.STARTING;
        }
    }

    public Point getPosition() {
        return this.pos;
    }

    public Point getCentre() {
        return new Point(this.pos.getX()+32, this.pos.getY()+32);
    }

    public void damage(int damage) {
        this.HP -= (damage - this.armor);
        if (HP <=0) {
            this.pos = null;
            this.Remove();
            Player.Money += this.reward;
        }
    }

    public void drawHealthBar(Graphics g) {
        final int barMaxWidth = 48;
        int barHealth = (int)Math.ceil(((double)this.HP / this.maxHP) * barMaxWidth);

        g.setColor(Color.gray);
        g.fillRect(((int) getPosition().getX()) + 12,
                ((int) getPosition().getY()) , barMaxWidth, 5);
        g.setColor(Color.blue);
        g.fillRect(((int) getPosition().getX()+ 12) ,
                ((int) getPosition().getY()) , barHealth, 5);

    }

}
