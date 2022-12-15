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
        if (shuffledCrews.size() % 2 == 0) {
            matchPairIfSizeEven(pairs, shuffledCrews);
        }
        if (shuffledCrews.size() % 2 == 1) {
            matchPairIfSizeOdd(pairs, shuffledCrews);
        }
        return pairs;
    }

    private static void matchPairIfSizeOdd(List<Pair> pairs, List<Crew> shuffledCrews) {
        for (int i = 0; i < shuffledCrews.size() - 1; i = i + 2) {
            if (i == shuffledCrews.size() - 3) {
                pairs.add(new Pair(shuffledCrews.subList(i, i + 2)));
                continue;
            }
            pairs.add(new Pair(shuffledCrews.subList(i, i + 1)));
        }
    }

    private static void matchPairIfSizeEven(List<Pair> pairs, List<Crew> shuffledCrews) {
        for (int i = 0; i < shuffledCrews.size(); i = i + 2) {
            pairs.add(new Pair(shuffledCrews.subList(i, i + 1)));
        }
    }
}
