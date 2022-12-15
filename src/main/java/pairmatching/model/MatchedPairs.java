package pairmatching.model;

import java.util.HashMap;
import java.util.Map;

public class MatchedPairs {
    private final Map<MissionAndCourse, Pairs> matchedPairs;

    public MatchedPairs() {
        this.matchedPairs = new HashMap<>();
    }

    public void put(MissionAndCourse missionAndCourse, Pairs pairs) {
        matchedPairs.put(missionAndCourse, pairs);
    }
}
