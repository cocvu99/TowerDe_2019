package TowerDefense.GameEnitty.Map;

import javax.swing.*;

public class Mountain extends GameMap {
    public Mountain(Point pos) {
        this.im     = new ImageIcon("/map/mountain.png").getImage();
        this.pos    = pos;
    }
}
