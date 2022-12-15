package pairmatching.dto;

import java.util.Collections;
import java.util.List;

public class PairsDto {
    private final List<PairDto> pairs;

    public PairsDto(List<PairDto> pairs) {
        this.pairs = Collections.unmodifiableList(pairs);
    }

    public List<PairDto> getPairs() {
        return pairs;
    }
}
