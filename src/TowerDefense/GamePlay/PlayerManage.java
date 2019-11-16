package TowerDefense.GamePlay;

import javax.swing.*;
import java.awt.geom.Rectangle2D;

public class PlayerManage extends JPanel {

    public static int money;
    public static int heart;
    public static Object choosedObject;

    public static Rectangle2D.Double basicTowerArea = new Rectangle2D.Double(3,1024 + 0,64,64);
    public static Rectangle2D.Double advanceTowerArea = new Rectangle2D.Double(3,1024 + 0,64,64);
    public static Rectangle2D.Double knightTrapTowerArea = new Rectangle2D.Double(3,1024 + 0,64,64);

    public static void init() {
        money = 200;
        heart = 10;
        choosedObject = null;
    }

}
