package Main;

public class Particle {

    public double xPos, yPos;
    public double xVel, yVel;
    public double xAcc, yAcc;
    public int type;

    public Particle(double xPosIn, double yPosIn, int typeIn) {
        type = typeIn;
        xPos = xPosIn;
        yPos = yPosIn;
        xVel = 0.0;
        yVel = 0.0;
        xAcc = 0.0;
        yAcc = 0.0;
    }

    public void move(double xAccIn, double yAccIn) {

        xVel = (xVel + 0.1 * xAccIn) * 0.95;
        yVel = (yVel + 0.1 * yAccIn) * 0.95;

        xPos += 0.1 * xVel;
        yPos += 0.1 * yVel;
        if(xPos > 1.0) xPos = 0.0;
        if(yPos > 1.0) yPos = 0.0;
        if(xPos < 0.0) xPos = 1.0;
        if(yPos < 0.0) yPos = 1.0;
    }
}
