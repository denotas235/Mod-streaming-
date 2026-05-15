package com.nexus.derivative.streaming;

import com.nexus.derivative.math.DerivativeState;

public class Predictor {

    public static int[][] predictFutureChunks(double x, double z) {

        int[][] out = new int[5][2];

        for (int i = 1; i <= 5; i++) {

            double fx = x + DerivativeState.getVelX() * (i * 4);
            double fz = z + DerivativeState.getVelZ() * (i * 4);

            int cx = (int)Math.floor(fx) >> 4;
            int cz = (int)Math.floor(fz) >> 4;

            out[i - 1][0] = cx;
            out[i - 1][1] = cz;
        }

        return out;
    }
}
