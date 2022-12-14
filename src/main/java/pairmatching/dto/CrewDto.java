package pairmatching.dto;

import pairmatching.model.Course;

public class CrewDto {
    private final Course course;
    private final String name;

    public CrewDto(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
