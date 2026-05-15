package com.nexus.derivative.streaming;

import com.nexus.derivative.math.DerivativeState;

public class PrioritySystem {

    public static double priorityFor(int cx, int cz, double px, double pz) {

        double dx = (cx << 4) - px;
        double dz = (cz << 4) - pz;

        double dist = Math.sqrt(dx*dx + dz*dz);

        double dot =
            (dx * DerivativeState.getVelX()) +
            (dz * DerivativeState.getVelZ());

        double acc =
            (dx * DerivativeState.getAccX()) +
            (dz * DerivativeState.getAccZ());

        return dot * 2 + acc * 1.5 - dist * 0.3;
    }
}
