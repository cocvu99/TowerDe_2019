package TowerDefense.GamePlay;
import javax.swing.*;
import TowerDefense.GameScreen.*;
import java.awt.*;
import java.awt.event.*;

abstract class ActionEvent implements ActionListener {
    JFrame frame=new JFrame();
    JButton button=new JButton("Click Me");

    ActionEvent(){
        prepareGUI();
        buttonProperties();
    }

    public void prepareGUI(){
        frame.setTitle("Tower Defense");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(200,200,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void buttonProperties(){
        button.setBounds(130,200,100,40);
        frame.add(button);
        button.addActionListener(this);//Registering ActionListener to the button
    }

    public void actionPerformed(ActionEvent e) { }
}
public class GameMain {
    public static void main(String[] args){
        new ActionEvent() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

            }
        };
    }
}
