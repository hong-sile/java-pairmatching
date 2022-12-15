package pairmatching.dto;

import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.model.MissionAndCourse;

public class MissionAndCourseDto {
    private final MissionAndCourse missionAndCourse;

    public MissionAndCourseDto(Mission mission, Course course) {
        missionAndCourse = new MissionAndCourse(mission, course);
    }

    public MissionAndCourse getMissionAndCourse() {
        return missionAndCourse;
    }
}
