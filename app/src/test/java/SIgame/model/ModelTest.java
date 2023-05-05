/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package SIgame.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ModelTest 
{
    @Test
    public void testAlienModel() 
    {
        AlienModel alien = new AlienModel(10, 20);

        assertEquals(10, alien.getX());
        assertEquals(20, alien.getY());

        alien.setX(5);
        alien.setY(30);

        assertEquals(5, alien.getX());
        assertEquals(30, alien.getY());
    }

    @Test
    public void testBarrierModel() 
    {
        BarrierModel barrier = new BarrierModel(10, 20, 50, 60, 20);

        assertEquals(10, barrier.getX());
        assertEquals(20, barrier.getY());
        assertEquals(50, barrier.getWidth());
        assertEquals(60, barrier.getHeight());
        assertEquals(20, barrier.getHitCount());

        for (int i = 0; i < 19; i++) 
        {
            assertFalse(barrier.hitByLaser());
        }
        assertTrue(barrier.hitByLaser());
    }

    @Test
    public void testBarrierModelNegative() 
    {
        BarrierModel barrier = new BarrierModel(10, 20, 50, 60, 10);
    
        for (int i = 0; i < 15; i++) 
        {
            barrier.hitByLaser();
        }
        
        assertEquals(0, barrier.getHitCount());
    }

    @Test
    public void testLaserModel() 
    {
        LaserModel laser = new LaserModel(10, 20, 5);

        assertEquals(10, laser.getX());
        assertEquals(20, laser.getY());
        assertEquals(5, laser.getSpeed());

        laser.move();

        assertEquals(15, laser.getY());
    }

    @Test
    public void testLifeModel() 
    {
        LifeModel lifeModel = new LifeModel();

        assertEquals(3, lifeModel.getLives());
        assertFalse(lifeModel.isGameOver());

        lifeModel.hitByAlien();
        assertEquals(2, lifeModel.getLives());
        assertFalse(lifeModel.isGameOver());

        lifeModel.hitByAlien();
        lifeModel.hitByAlien();
        assertEquals(0, lifeModel.getLives());
        assertTrue(lifeModel.isGameOver());
    }

    @Test
    public void testScoreModel() 
    {
        ScoreModel scoreModel = new ScoreModel();

        int initialScore = scoreModel.getCurrentScore();
        int initialHighScore = scoreModel.getHighScore();

        scoreModel.gainPoint();
        assertEquals(initialScore + 10, scoreModel.getCurrentScore());
        assertTrue(scoreModel.getHighScore() >= initialHighScore);
    }

    @Test
    public void testTankModel() 
    {
        TankModel tank = new TankModel(300, 400, 10);

        assertEquals(300, tank.getX());
        assertEquals(400, tank.getY());
        assertEquals(10, tank.getSpeed());

        tank.moveLeft();
        assertEquals(290, tank.getX());

        tank.moveRight();
        assertEquals(300, tank.getX());

        LaserModel laser = tank.shoot();
        assertEquals(tank.getX() + 27, laser.getX());
        assertEquals(tank.getY() - 10, laser.getY());
    }

    @Test
    public void testTankModelBoundary() 
    {
        TankModel tank = new TankModel(0, 400, 10);
    
        tank.moveLeft();
        assertEquals(0, tank.getX());
    
        tank = new TankModel(580, 400, 10);
    
        tank.moveRight();
        assertEquals(580, tank.getX());
    }
}