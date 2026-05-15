package com.nexus.derivative.math;

public class DerivativeState {
    private static double lastX, lastZ;
    private static double vx, vz;
    private static boolean initialized = false;

    public static void update(double x, double z, float dt) {
        if (!initialized) { lastX = x; lastZ = z; initialized = true; return; }
        double dx = x - lastX;
        double dz = z - lastZ;
        vx = dx / dt;
        vz = dz / dt;
        lastX = x; lastZ = z;
    }

    public static double getVx() { return vx; }
    public static double getVz() { return vz; }
}
