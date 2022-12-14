package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.CommandCode;

public class InputView {
    private static final String SELECT_COMMAND_LIST_MESSAGE = "기능을 선택하세요.";

    public static CommandCode readCommandCode() {
        System.out.println(SELECT_COMMAND_LIST_MESSAGE);
        for (CommandCode commandCode : CommandCode.values()) {
            System.out.printf("%s. %s\n", commandCode.getCode(), commandCode.getDescription());
        }
        String input = Console.readLine();
        return CommandCode.from(input);
    }
}
