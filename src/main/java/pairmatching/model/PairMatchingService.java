package pairmatching.model;

import pairmatching.dto.CourseMissionDto;
import pairmatching.dto.CrewsDto;

public class PairMatchingService {
    private final MatchedPairs matchedPairs;
    private final Crews crews;

    public PairMatchingService(CrewsDto CrewsDto) {
        crews = new Crews(CrewsDto.getCrewDtos());
        matchedPairs = new MatchedPairs();
    }

    public void lookUp(CourseMissionDto courseMissionDto) {

    }

    public void matchingPair(Mission mission, Course course) {
        MissionAndCourse missionAndCourse = new MissionAndCourse(mission, course);
        matchedPairs.put(missionAndCourse, crews.matchCrews(course));
    }

    public void checkAlreadyMatched(Mission mission, Course course) {

    }
}
