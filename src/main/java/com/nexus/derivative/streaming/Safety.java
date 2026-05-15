package com.nexus.derivative.streaming;

public class Safety {

    public static int MAX_PREFETCH_PER_TICK = 12;
    public static int MAX_DISTANCE = 320;
    public static int MAX_ACCEL = 40;

    public static boolean allow(double dist, double acc) {
        return dist < MAX_DISTANCE && Math.abs(acc) < MAX_ACCEL;
    }
}
