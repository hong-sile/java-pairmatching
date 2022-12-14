package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.CommandCode;
import pairmatching.dto.CrewDto;
import pairmatching.dto.CrewsDto;
import pairmatching.model.Course;

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

    public static CrewsDto readCrews() throws IOException {
        List<CrewDto> crewDtos = new ArrayList<>();
        addCrewDtos(crewDtos);
        return new CrewsDto(crewDtos);
    }

    private static void addCrewDtos(List<CrewDto> crewDtos) throws IOException {
        List<String> backCrews = readBackCrews();
        List<String> frontCrews = readFrontCrews();
        for (String name : backCrews) {
            crewDtos.add(new CrewDto(Course.BACKEND, name));
        }
        for (String name : frontCrews) {
            crewDtos.add(new CrewDto(Course.FRONTEND, name));
        }
    }

    private static List<String> readBackCrews() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, BACKEND_CREW_FILE_NAME);
        return crewNames;
    }

    private static List<String> readFrontCrews() throws IOException {
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
