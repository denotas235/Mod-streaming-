package com.nexus.derivative.streaming;

import java.util.HashSet;
import java.util.Set;

public class PrefetchMap {

    private static final Set<Long> requested = new HashSet<>();

    public static boolean shouldRequest(int cx, int cz) {
        long key = (((long)cx) << 32) ^ (cz & 0xffffffffL);
        if (requested.contains(key)) return false;
        requested.add(key);
        return true;
    }
}
