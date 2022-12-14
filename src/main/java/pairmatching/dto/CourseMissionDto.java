package pairmatching.dto;

import pairmatching.model.Course;
import pairmatching.model.Mission;

public class CourseMissionDto {
    private final Course course;
    private final Mission mission;

    public CourseMissionDto(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
