package TowerDefense;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMain extends JFrame {

   static final int CANVAS_WIDTH = 768;    // width and height of the game screen
   static final int CANVAS_HEIGHT = 576;
   static final int UPDATES_PER_SEC = 4;
   static final long UPDATE_PERIOD_NSEC = 1000000000L / UPDATES_PER_SEC;  // nanoseconds

   static enum GameState {
      INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED;
   }
   static GameState state;
   //private GameCanvas canvas;

   /*public GameMain() {
      // Initialize the game objects
      gameInit();

      // UI components
      canvas = new GameCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      this.setContentPane(canvas);

      // Other UI components such as button, score board, if any.
      // ......

   }*/
   public void gameInit() { state = GameState.INITIALIZED; }

   public void gameShutdown(){ }

   public void gameStart() {
      Thread gameThread = new Thread(){
         @Override
         public void run(){
            gameLoop();
         }
   };
      gameThread.start();
   }

   private void gameLoop(){
      state = GameState.PLAYING;

      long beginTime, timeTaken, timeLeft;
      while (state!=GameState.GAMEOVER){
         beginTime = System.nanoTime();
         /*if (state == GameState.PLAYING){ //not paused
            gameUpdate();
         }*/
         repaint();

         timeTaken = System.nanoTime() - beginTime;
         timeLeft = (UPDATE_PERIOD_NSEC -timeTaken)/1000000L;
         if (timeLeft <10 ) timeLeft =10;
         try{
            Thread.sleep(timeLeft);
         } catch (InterruptedException ex){}
      }
      // line dssuoi dang bi loi
      //public void gameUpdate(){};
      /*private void gameDraw(Graphics2D){
         switch (state){
            case INITIALIZED: break;
            case PLAYING:  break;
            case PAUSED: break;
            case GAMEOVER: break;
         }
      }*/
      
      /* gameKeyPressed dang loi do chua co doi tuong
      public void gameKeyPressed(int keyCode){
         switch (keyCode){
            case KeyEvent.VK_UP:
            // ......
            break;
            case KeyEvent.VK_DOWN:
               // ......
               break;
            case KeyEvent.VK_LEFT:
               // ......
               break;
            case KeyEvent.VK_RIGHT:
               // ......
               break;
         }
      }   */

      abstract class GameCanvas extends JPanel implements KeyListener{
         //CONSTRUCTOR
         public GameCanvas(){
            setFocusable(true);
            requestFocus();
            addKeyListener(this);
         }


         public void paintComponent(Graphics2D g){
            Graphics2D g2d = (Graphics2D)g;
            super.paintComponent(g2d);
            setBackground(Color.BLACK);

            //draw game object
            gameDraw(g2d);
         }

         protected abstract void gameDraw(Graphics2D g2d);

         /*public void KeyPressed(KeyEvent e){
            gameKeyPressed(e.getKeyCode());
         }*/

         @Override
         public void keyReleased(KeyEvent e) { }

         @Override
         public void keyTyped(KeyEvent e) { }
         }
      }
   public static void main(String[] args) {
      // Use the event dispatch thread to build the UI for thread-safety.
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            JFrame frame = new JFrame();
            // Set the content-pane of the JFrame to an instance of main JPanel
            frame.setContentPane(new GameMain());  // main JPanel as content pane
            //frame.setJMenuBar(menuBar);          // menu-bar (if defined)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null); // center the application window
            frame.setVisible(true);            // show it
         }
      });
   }
   //public static void main(String[] args) {

      // test game framework nen bo // vao duoi day
      /*JFrame frame = new JFrame();
      GameField gameField= new GameField();;
      frame.setSize(1116, 639);
      frame.setTitle(" TOWER DEFENSE ");
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(150, 0);
      frame.add(gameField); */
   //}
}