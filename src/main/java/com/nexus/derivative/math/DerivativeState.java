package com.nexus.derivative.math;

public class DerivativeState {

    private static double lastX = 0;
    private static double lastZ = 0;
    private static double lastVelX = 0;
    private static double lastVelZ = 0;

    private static boolean first = true;

    private static double velX = 0;
    private static double velZ = 0;

    private static double accX = 0;
    private static double accZ = 0;

    public static double getVelX() { return velX; }
    public static double getVelZ() { return velZ; }

    public static double getAccX() { return accX; }
    public static double getAccZ() { return accZ; }

    public static void update(double x, double z, float tickDelta) {
        if (first) {
            lastX = x;
            lastZ = z;
            first = false;
            return;
        }

        double dx = x - lastX;
        double dz = z - lastZ;

        double newVelX = dx / tickDelta;
        double newVelZ = dz / tickDelta;

        accX = (newVelX - lastVelX) / tickDelta;
        accZ = (newVelZ - lastVelZ) / tickDelta;

        velX = (velX * 0.6) + (newVelX * 0.4);
        velZ = (velZ * 0.6) + (newVelZ * 0.4);

        lastVelX = newVelX;
        lastVelZ = newVelZ;

        lastX = x;
        lastZ = z;
    }
}
