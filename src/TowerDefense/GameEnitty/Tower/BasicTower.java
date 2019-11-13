package TowerDefense.GameEnitty.Tower;

import TowerDefense.GameEnitty.GameScreen.GameField;
import TowerDefense.GameEnitty.Map.Point;
import TowerDefense.GameEnitty.Monster.Monster;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicTower extends Tower {

    public BasicTower(Point pos) {
        super(pos, "res/Map/basic_tower.png");
        this.price = 50;
        this.range = 256;
        this.damage = 5;
    }

}
