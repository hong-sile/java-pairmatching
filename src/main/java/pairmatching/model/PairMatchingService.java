package pairmatching.model;

import pairmatching.dto.MissionAndCourseDto;
import pairmatching.dto.CrewsDto;
import pairmatching.dto.PairsDto;

public class PairMatchingService {
    private static final String NEVER_MATCHED_MESSAGE = "매칭된 적이 없는 정보입니다.";
    private final MatchedPairs matchedPairs;
    private final Crews crews;

    public PairMatchingService(CrewsDto CrewsDto) {
        crews = new Crews(CrewsDto.getCrews());
        matchedPairs = new MatchedPairs();
    }

    public PairsDto lookUp(MissionAndCourseDto missionAndCourseDto) {
        MissionAndCourse missionAndCourse = missionAndCourseDto.getMissionAndCourse();
        if (matchedPairs.isMatched(missionAndCourse)) {
            return matchedPairs.find(missionAndCourse);
        }
        throw new IllegalArgumentException(NEVER_MATCHED_MESSAGE);
    }

    public void matchingPair(MissionAndCourseDto missionAndCourseDto) {
        MissionAndCourse missionAndCourse = missionAndCourseDto.getMissionAndCourse();
        if (matchedPairs.isMatched(missionAndCourse)) {
            //다시 초기화 할 것인지 여부를 입력 받음
        }
        matchedPairs.put(missionAndCourse, crews.matchCrews(missionAndCourse));
    }
}
