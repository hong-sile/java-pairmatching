package pairmatching.constant;

public enum CommandCode {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_LOOK_UP("2", "페어 조회"),
    PAIR_CLEAR("3", "페어 초기화"),
    EXIT_PROGRAM("Q", "종료");

    private static final String INVALID_COMMAND_CODE_MESSAGE = "1,2,3,Q 중에서 하나를 입력해주세요";
    private final String code;
    private final String description;

    CommandCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CommandCode from(String input) {
        for (CommandCode commandCode : CommandCode.values()) {
            if (commandCode.code.equals(input)) {
                return commandCode;
            }
        }
        throw new IllegalArgumentException(INVALID_COMMAND_CODE_MESSAGE);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
