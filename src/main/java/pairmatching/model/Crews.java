package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.dto.CrewDto;

public class Crews {
    private List<Crew> crews = new ArrayList<>();

    public Crews(List<CrewDto> crewDtos) {
        for (CrewDto crewDto : crewDtos) {
            crews.add(new Crew(crewDto.getCourse(), crewDto.getName()));
        }
    }

    public Pairs matchCrews(Mission mission) {
        List<Pair> pairs = new ArrayList<>();
        this.crews = Randoms.shuffle(crews);
        for (int i = 0; i < crews.size(); i = i + 2) {
            Pair pair = new Pair(crews.subList(i, i + 1), mission);
            pairs.add(pair);
        }
        return new Pairs(pairs);
    }
}
