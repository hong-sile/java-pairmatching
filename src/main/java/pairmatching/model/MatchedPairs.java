package pairmatching.model;

import java.util.HashMap;
import java.util.Map;
import pairmatching.dto.PairsDto;

public class MatchedPairs {
    private final Map<MissionAndCourse, Pairs> matchedPairs;

    public MatchedPairs() {
        this.matchedPairs = new HashMap<>();
    }

    public void put(MissionAndCourse missionAndCourse, Pairs pairs) {
        matchedPairs.put(missionAndCourse, pairs);
    }

    public boolean isMatched(MissionAndCourse missionAndCourse) {
        return matchedPairs.containsKey(missionAndCourse);
    }

    public PairsDto find(MissionAndCourse missionAndCourse) {
        return matchedPairs.get(missionAndCourse).toDto();
    }
}
