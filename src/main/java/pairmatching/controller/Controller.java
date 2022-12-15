package pairmatching.controller;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import pairmatching.constant.CommandCode;
import pairmatching.dto.MissionAndCourseDto;
import pairmatching.dto.PairsDto;
import pairmatching.model.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    private final PairMatchingService service;

    public Controller() throws IOException {
        this.service = new PairMatchingService(InputView.readCrews());
    }

    public void run() {
        CommandCode commandCode;
        do {
            commandCode = repeat(InputView::readCommandCode);
            runCommandCode(commandCode);
        } while (commandCode != CommandCode.EXIT_PROGRAM);
    }

    private void runCommandCode(CommandCode commandCode) {
        if (commandCode == CommandCode.PAIR_MATCHING) {
            matching();
        }
        if (commandCode == CommandCode.PAIR_LOOK_UP) {
            lookUp();
        }
        if (commandCode == CommandCode.PAIR_CLEAR) {

        }
    }

    private void matching() {

    }

    private void lookUp() {
        MissionAndCourseDto missionAndCourseDto = this.repeat(InputView::readCourseLevelMission);
        PairsDto pairsDto = service.lookUp(missionAndCourseDto);
        OutputView.printPairs(pairsDto);
    }

    public <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return this.repeat(reader);
        }
    }

    public <T> void repeat(Consumer method, CommandCode commandCode) {
        try {
            method.accept(commandCode);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            repeat(method, commandCode);
        }
    }
}
