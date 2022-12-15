package pairmatching.dto;

import java.util.Collections;
import java.util.List;

public class CrewsDto {
    private final List<CrewDto> crews;

    public CrewsDto(List<CrewDto> crews) {
        this.crews = Collections.unmodifiableList(crews);
    }

    public List<CrewDto> getCrews() {
        return crews;
    }
}
