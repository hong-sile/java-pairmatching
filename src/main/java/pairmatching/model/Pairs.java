package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.dto.PairDto;
import pairmatching.dto.PairsDto;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = new ArrayList<>();
    }

    public PairsDto toDto() {
        List<PairDto> pairs = this.pairs
                .stream()
                .map(Pair::toDto)
                .collect(Collectors.toList());
        return new PairsDto(pairs);
    }
}
