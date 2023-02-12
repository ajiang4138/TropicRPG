package Main;

import java.util.Random;

public class Simulation {

    public int numTypes;
    public int numParticles;
    public Particle[] particles;
    public double[][][] attractions;

    public Simulation(int numTypesIn, int numParticlesIn) {

        numTypes = numTypesIn;
        numParticles = numParticlesIn;
        Random rand = new Random();
        particles = new Particle[numParticles];
        for (int i = 0; i < numParticles; i++) {
            particles[i] = new Particle(rand.nextDouble(), rand.nextDouble(), rand.nextInt(numTypes));
        }
        attractions = new double[numTypes][numTypes][4];
        for (int i = 0; i < numTypes; i++) {
            for (int j = 0; j < numTypes; j++) {
                if (i != j) {
                    attractions[i][j][0] = rand.nextDouble();
                    attractions[i][j][1] = rand.nextDouble();
                    attractions[i][j][2] = rand.nextDouble();
                    attractions[i][j][3] = rand.nextDouble();
                }
            }
        }
    }

    public void update() {

        for(Particle p1: particles) {
            double accX = 0.0;
            double accY = 0.0;
            for(Particle p2: particles) {

                double xD = p1.xPos - p2.xPos;
                double yD = p1.yPos - p2.yPos;

                double n1 = 0.01 + (0.02 - 0.01) * attractions[p1.type][p2.type][0];
                double n2 = 0.1 + (0.5 - 0.1) * attractions[p1.type][p2.type][1];
                double n3 = 0.6 + (0.9 - 0.6) * attractions[p1.type][p2.type][2];
                double n4 = 2 * attractions[p1.type][p2.type][3] - 1;

                if (xD < n1){
                    accX += 0.1 / (xD / n1 - 0.1) - 0.1;
                } else if (xD < n2) {
                    accX += n4 / (n2 - n1) * (xD - n1);
                }
                else if (xD < n3) {
                    accX += -n4 / (n3 - n2) * (xD - n2) + n4;
                }
                if (yD < n1){
                    accY += 0.1 / (yD / n1 - 0.1) - 0.1;
                } else if (yD < n2) {
                    accY += n4 / (n2 - n1) * (yD - n1);
                }
                else if (yD < n3) {
                    accY += -n4 / (n3 - n2) * (yD - n2) + n4;
                }
                p1.move(accX / numParticles, accY / numParticles);
            }
        }
    }
}
