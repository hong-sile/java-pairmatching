package pairmatching.model;

public class MissionAndCourse {
    private final Mission mission;
    private final Course course;

    public MissionAndCourse(Mission mission, Course course) {
        this.mission = mission;
        this.course = course;
    }

    public boolean checkCourse(Course course) {
        return this.course == course;
    }
}
