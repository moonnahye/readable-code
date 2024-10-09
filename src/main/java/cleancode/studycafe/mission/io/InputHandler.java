package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public interface InputHandler {

    public StudyCafePassType getPassTypeSelectingUserAction();

    public StudyCafePass getSelectPass(List<StudyCafePass> passes);

    public boolean getLockerSelection();
}
