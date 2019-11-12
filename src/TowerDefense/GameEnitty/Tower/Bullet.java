package TowerDefense.GameEnitty.Tower;

import javax.swing.*;
import java.awt.*;

public class Bullet extends JPanel {
    private int X_To;
    private  int Y_To;

    private int X_Start;
    private  int Y_Start;
    private int x  ;
    private int y ;
    float xV,yV;
    private int BULLET_SPEED = 5;

    public Bullet(int x, int y, int x_To, int y_To , int x_Start, int y_Start) {
        X_To = x_To;
        Y_To = y_To;
        X_Start = x_Start;
        Y_Start = y_Start;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
                g.setColor(Color.CYAN);
                g.fillOval(x, y, 10, 10);
        }


    public  int getX1() {
        return x;
    }


    public int getY1() {
        return y;
    }

    public void move() {
        if((X_To==X_Start) )
        {
            if ( (Y_To<Y_Start))
                y-=BULLET_SPEED;
            else
                y+=BULLET_SPEED;
        }
        else
        if(Y_Start==Y_To) {
            if(Y_To>Y_Start)
                x -= BULLET_SPEED;
            else
                x+=BULLET_SPEED;
        }
        else
        if  ((X_To>X_Start) && (Y_To>Y_Start)) {
            if ((X_To - X_Start) > (Y_To - Y_Start)) {
                y+=BULLET_SPEED+1;
                int  a=(int)((BULLET_SPEED*(X_To-X_Start)/(Y_To-Y_Start) )+0.5);
                if (a>6)
                    a=4;
                x+=a*BULLET_SPEED;
            }
            else
            {
                x+=BULLET_SPEED;
                y+=(int) ((BULLET_SPEED*(Y_To-Y_Start)/(X_To-X_Start))+0.5);
            }
        }
        else
        if  ((X_To>X_Start) && (Y_To<Y_Start))
        {
            if ((X_To-X_Start) >(Y_Start-Y_To))
            {
                y-=BULLET_SPEED;
                x+=(int) ( (BULLET_SPEED*(X_To-X_Start)/(Y_Start-Y_To) )+0.5 );
            }
            else
            {
                x+=BULLET_SPEED;
                y-=(int) ((BULLET_SPEED*(Y_Start-Y_To)/(X_To-X_Start))+0.5);
            }
        }

        else
        if  ((X_To<X_Start) && (Y_To>Y_Start))
        {
            if ((X_Start-X_To)>(Y_To-Y_Start))
            {
                y+=BULLET_SPEED;
                x-=(int) ( (BULLET_SPEED*(X_Start-X_To)/(Y_To-Y_Start) )+0.5 );
            }
            else {
                x-=BULLET_SPEED;
                y+=(int) ( (BULLET_SPEED*(Y_To-Y_Start)/(X_Start-X_To))+0.5 );
            }

        }
        else
        if  ((X_To<X_Start) && (Y_To<Y_Start))
        {
            if((X_Start-X_To)>(Y_Start-Y_To))
            {
                y-=BULLET_SPEED;
                x-=(int) ( (BULLET_SPEED*(X_Start-X_To)/(Y_Start-Y_To) )+0.5 );
            }
        }

    }
    private void calculateDirection(){
        //double angle = Math.atan2((Y_Start-Y_To),(X_Start-X_To));
         xV= (float) ((Y_Start-Y_To)/(Math.sqrt(Math.pow((Y_Start-Y_To),2)+Math.pow((X_Start-X_To),2))));
         yV=(float) ((X_Start-X_To)/(Math.sqrt(Math.pow((Y_Start-Y_To),2)+Math.pow((X_Start-X_To),2))));
    }
    public void move1(){
        x +=(int) (((Y_Start-Y_To)/(Math.sqrt(Math.pow((Y_Start-Y_To),2)+Math.pow((X_Start-X_To),2)))) * BULLET_SPEED+0.5);
        y += (int)(((X_Start-X_To)/(Math.sqrt(Math.pow((Y_Start-Y_To),2)+Math.pow((X_Start-X_To),2)))) * BULLET_SPEED+0.5);
    }
}
