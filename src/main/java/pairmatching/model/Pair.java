package pairmatching.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.dto.CrewDto;
import pairmatching.dto.PairDto;

public class Pair {
    private final List<Crew> pair;

    public Pair(List<Crew> pair) {
        this.pair = Collections.unmodifiableList(pair);
    }

    public PairDto toDto() {
        List<CrewDto> pairDto = pair
                .stream()
                .map(Crew::toDto)
                .collect(Collectors.toList());
        return new PairDto(pairDto);
    }
}
