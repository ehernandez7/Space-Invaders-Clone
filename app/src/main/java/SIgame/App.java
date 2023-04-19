/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package SIgame;

import SIgame.view.*;
import SIgame.model.*;
import SIgame.controller.*;

public class App 
{
    public static void main(String[] args) 
    {
        Score score = new Score();
        TankModel tankModel = new TankModel(290, 420, 5);
        GameController gameController = new GameController(score);
        TankView tankView = gameController.getSpaceGUI().getTankView();
        TankController tankController = new TankController(tankModel, tankView, gameController);
        gameController.setTankView(tankView);

        Thread laserThread = new Thread(() -> {
            while (true) 
            {
                gameController.moveLasers();
                gameController.checkForCollisions();
        
                try 
                {
                    Thread.sleep(10);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        });
        laserThread.start();
    }
}
