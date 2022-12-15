package pairmatching.dto;

import java.util.Collections;
import java.util.List;

public class PairDto {
    private final List<CrewDto> pair;

    public PairDto(List<CrewDto> pair) {
        this.pair = Collections.unmodifiableList(pair);
    }

    public List<CrewDto> getPair() {
        return pair;
    }
}
