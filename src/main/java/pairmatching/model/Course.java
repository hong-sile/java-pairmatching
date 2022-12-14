package pairmatching.model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String INVALID_NAME_MESSAGE = "입력한 값고 일치하는 과정이 없습니다.";
    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String name) {
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return course;
            }
        }
        throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
    }
}
