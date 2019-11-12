package TowerDefense.GameEnitty.Map;

import TowerDefense.GameFrame;

import javax.swing.*;
import java.awt.*;

public class BackGround {

    Image im = new ImageIcon("res/Map/background.png").getImage();

    void draw(Graphics2D g2d) {
        g2d.drawImage(
                im,
                0,
                0,
                GameFrame.WINDOW_WITH,
                GameFrame.WINDOW_HEIGHT,
                null
        );

    }
}
