package pairmatching.model;

public enum Mission {
    CAR_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL_GAME("숫자야구게임", Level.LEVEL1),
    BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_ROAD("지하철노선도", Level.LEVEL2),
    REFACTORING("성능개선", Level.LEVEL4),
    PUBLISH("배포", Level.LEVEL4);

    private static final String INVALID_NAME_MESSAGE = "입력한 값과 일치하는 미션이 없습니다.";
    private static final String UNMATCHED_LEVEL_MESSAGE = "레벨과 미션이 일치하지 않습니다.";
    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public static Mission from(String name) {
        for (Mission mission : Mission.values()) {
            if (mission.name.equals(name)) {
                return mission;
            }
        }
        throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
    }

    public void isEqualLevel(Level level) {
        if (this.level != level) {
            throw new IllegalArgumentException(UNMATCHED_LEVEL_MESSAGE);
        }
    }
}
