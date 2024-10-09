package cleancode.studycafe.mission;




import cleancode.studycafe.mission.io.*;
import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;

import java.util.List;

public class StudyCafeApplication {

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        FileHandler fileHandler = new StudyCafeFileHandler();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(inputHandler,outputHandler,fileHandler);
        studyCafePassMachine.run();
    }

}
