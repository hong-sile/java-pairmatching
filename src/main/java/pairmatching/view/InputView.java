package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.CommandCode;

public class InputView {
    private static final String SELECT_COMMAND_LIST_MESSAGE = "기능을 선택하세요.";
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";
    private static final String BACKEND_CREW_FILE_NAME = "backend-crew.md";
    private static final String FRONTEND_CREW_FILE_NAME = "frontend-crew.md";

    public static CommandCode readCommandCode() {
        System.out.println(SELECT_COMMAND_LIST_MESSAGE);
        for (CommandCode commandCode : CommandCode.values()) {
            System.out.printf("%s. %s\n", commandCode.getCode(), commandCode.getDescription());
        }
        String input = Console.readLine();
        return CommandCode.from(input);
    }

    public static List<String> readBackCrew() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, BACKEND_CREW_FILE_NAME);
        return crewNames;
    }

    public static List<String> readFrontCrew() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, FRONTEND_CREW_FILE_NAME);
        return crewNames;
    }

    private static void readFile(List<String> crewNames, String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(RESOURCES_PATH + filePath)
        );
        String userName;
        while ((userName = reader.readLine()) != null) {
            crewNames.add(userName);
        }
    }
}
