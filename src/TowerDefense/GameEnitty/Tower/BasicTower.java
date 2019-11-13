package TowerDefense.GameEnitty.Tower;

import TowerDefense.GameEnitty.Map.Point;

import java.awt.*;

public class BasicTower extends Tower {

    public BasicTower(Point pos) {
        super(pos, "res/tower/basic_tower.png");
        this.speed = 1;
        this.damage = 5;
        this.price = 50;
        this.range = 512;
    }

}
