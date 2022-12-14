package pairmatching.constant;

public enum CommandCode {
    PAIR_MATCHING("1"),
    PAIR_LOOK_UP("2"),
    PAIR_CLEAR("3"),
    EXIT_PROGRAM("Q");

    private static final String INVALID_COMMAND_CODE_MESSAGE = "1,2,3,Q 중에서 하나를 입력해주세요";
    private final String code;

    CommandCode(String code) {
        this.code = code;
    }

    public static CommandCode from(String input) {
        for (CommandCode commandCode : CommandCode.values()) {
            if (commandCode.code.equals(input)) {
                return commandCode;
            }
        }
        throw new IllegalArgumentException(INVALID_COMMAND_CODE_MESSAGE);
    }
}
