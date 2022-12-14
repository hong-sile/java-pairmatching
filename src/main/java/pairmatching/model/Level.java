package pairmatching.model;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String INVALID_NAME_MESSAGE = "입력한 값과 일치하는 레벨이 업습니다.";
    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level from(String name) {
        for (Level level : Level.values()) {
            if (level.name.equals(name)) {
                return level;
            }
        }
        throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
    }
}