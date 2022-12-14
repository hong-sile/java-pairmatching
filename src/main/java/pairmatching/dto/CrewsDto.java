package pairmatching.dto;

import java.util.List;

public class CrewsDto {
    private final List<CrewDto> crewsDto;

    public CrewsDto(List<CrewDto> crewsDto) {
        this.crewsDto = crewsDto;
    }

    public List<CrewDto> getCrewsDto() {
        return crewsDto;
    }
}
