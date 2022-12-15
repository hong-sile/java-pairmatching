package pairmatching.model;

import pairmatching.dto.CrewDto;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public CrewDto toDto() {
        return new CrewDto(course, name);
    }
}