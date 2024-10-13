package cleancode.studycafe.mission;

import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.io.*;
import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final FileHandler fileHandler;

    public StudyCafePassMachine(InputHandler inputHandler, OutputHandler outputHandler,FileHandler fileHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.fileHandler = fileHandler;
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            StudyCafePassType studyCafePassType = getStudyCafePassType();
            List<StudyCafePass> studyCafeAllPasses = getStudyCafeAllPasses();
            List<StudyCafePass> passesBySameType = getPassesBySameType(studyCafeAllPasses, studyCafePassType);

            outputHandler.showPassListForSelection(passesBySameType);

            StudyCafePass selectedPass = inputHandler.getSelectPass(passesBySameType);

            if (doesUserChooseFixedType(studyCafePassType)) {

                StudyCafeLockerPass lockerCandidates = getLockerPass(selectedPass);

                boolean lockerSelection = false;
                if (lockerCandidates != null) {
                    outputHandler.askLockerPass(lockerCandidates);
                    lockerSelection = inputHandler.getLockerSelection();
                }

                if (lockerSelection) {
                    outputHandler.showPassOrderSummary(selectedPass, lockerCandidates);
                } else {
                    outputHandler.showPassOrderSummary(selectedPass, null);
                }
            }
            outputHandler.showPassOrderSummary(selectedPass, null);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeLockerPass getLockerPass(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses =fileHandler.readLockerPasses();

        return lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElse(null);
    }

    private List<StudyCafePass> getPassesBySameType(List<StudyCafePass> studyCafePasses, StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
            .filter(pass -> pass.isSameType(studyCafePassType))
            .toList();
    }

    private List<StudyCafePass> getStudyCafeAllPasses() {
        return fileHandler.readStudyCafePasses();
    }

    private StudyCafePassType getStudyCafePassType() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private boolean doesUserChooseFixedType(StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.FIXED;
    }

}
