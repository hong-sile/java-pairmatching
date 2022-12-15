package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.CommandCode;
import pairmatching.dto.CrewDto;
import pairmatching.dto.PairDto;
import pairmatching.dto.PairsDto;
import pairmatching.model.Pairs;

public class OutputView {
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";
    private static final String SELECT_COURSE_MISSION_LEVEL_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";
    private static final List<String> COURSE_MISSION_LEVEL_TEMPLATE =
            List.of("#############################################",
                    "과정: 백엔드 | 프론트엔드",
                    "미션:",
                    "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임",
                    "  - 레벨2: 장바구니 | 결제 | 지하철노선도",
                    "  - 레벨3: ",
                    "  - 레벨4: 성능개선 | 배포",
                    "  - 레벨5: ",
                    "############################################");
    private static final String SELECT_COMMAND_LIST_MESSAGE = "기능을 선택하세요.";
    private static final String DELIMITER = " : ";

    public static void printException(IllegalArgumentException exception) {
        System.out.print(EXCEPTION_MESSAGE_PREFIX);
        System.out.println(exception.getMessage());
    }

    public static void printCourseLevelMissionInfo() {
        for (String message : COURSE_MISSION_LEVEL_TEMPLATE) {
            System.out.println(message);
        }
        System.out.println(SELECT_COURSE_MISSION_LEVEL_MESSAGE);
    }

    public static void printCommandCodeList() {
        System.out.println(SELECT_COMMAND_LIST_MESSAGE);
        for (CommandCode commandCode : CommandCode.values()) {
            System.out.printf("%s. %s\n", commandCode.getCode(), commandCode.getDescription());
        }
    }

    public static void printPairs(PairsDto pairsDto) {
        for (PairDto pairDto : pairsDto.getPairs()) {
            String pair = pairDto.getPair()
                    .stream()
                    .map(CrewDto::getName)
                    .collect(Collectors.joining(":"));
            System.out.println(pair);
        }
    }
}
