package Game;
import javax.swing.*;

public class GameMain extends JFrame {
   public static void main(String[] args) {

      JFrame frame = new JFrame();
      GameField gameField= new GameField();;
      frame.setSize(1116, 639);
      frame.setTitle(" TOWER DEFENSE ");
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(150, 0);
      frame.add(gameField);
   }
}