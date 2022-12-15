package pairmatching.model;

import java.util.Collections;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = Collections.unmodifiableList(pairs);
    }
}
