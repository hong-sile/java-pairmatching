package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.dto.CrewDto;

public class Crews {
    private final List<Crew> backendCrews = new ArrayList<>();
    private final List<Crew> frontendCrews = new ArrayList<>();

    public Crews(List<CrewDto> crewDtos) {
        for (CrewDto crewDto : crewDtos) {
            if (crewDto.getCourse() == Course.FRONTEND) {
                frontendCrews.add(new Crew(Course.FRONTEND, crewDto.getName()));
            }
            if (crewDto.getCourse() == Course.BACKEND) {
                backendCrews.add(new Crew(Course.BACKEND, crewDto.getName()));
            }
        }
    }

    //리팩토링 필요
    public Pairs matchCrews(Course course) {
        if (Course.FRONTEND == course) {
            return new Pairs(matchPairs(frontendCrews));
        }
        return new Pairs(matchPairs(backendCrews));
    }

    private static List<Pair> matchPairs(List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        for (int i = 0; i < shuffledCrews.size(); i = i + 2) {
            Pair pair = new Pair(shuffledCrews.subList(i, i + 1));
            pairs.add(pair);
        }
        return pairs;
    }
}
