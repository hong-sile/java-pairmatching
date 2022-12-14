package pairmatching.view;

public class OutputView {
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    public static void printException(IllegalArgumentException exception) {
        System.out.print(EXCEPTION_MESSAGE_PREFIX);
        System.out.println(exception.getMessage());
    }
}
