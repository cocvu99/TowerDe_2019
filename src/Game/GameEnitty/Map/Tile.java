package Game.GameEnitty.Map;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private Image image,money,tower;
    private int coin =500;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Tile(){
        ImageIcon imageIcon = new ImageIcon("image/tile.png");
        image = imageIcon.getImage();
        ImageIcon imageIcon1 = new ImageIcon("image/x.png");
        money = imageIcon1.getImage();
        ImageIcon imageIcon2 = new ImageIcon("image/tower1.png");
        tower = imageIcon2.getImage();
    }
    public void paint(Graphics g){
        g.drawImage(image,1000,0,this);
        g.drawImage(money,1025,30,this);
        g.drawImage(tower,1025,150,this);
        g.setColor(Color.WHITE);
        g.setFont( new Font("Arial",Font.BOLD,14));
        g.drawString(coin+"$",1040,100);
        g.drawString("100$",1040,220);

    }
}
