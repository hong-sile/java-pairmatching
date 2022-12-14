package pairmatching.model;

import java.util.List;

public class Pair {
    private final List<Crew> pair;
    private final Mission mission;

    public Pair(List<Crew> pair, Mission mission) {
        this.pair = pair;
        this.mission = mission;
    }
}
