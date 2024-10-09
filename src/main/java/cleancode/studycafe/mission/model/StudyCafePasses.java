package cleancode.studycafe.mission.model;

import cleancode.studycafe.mission.io.StudyCafeFileHandler;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePasses {

    private final List<StudyCafePass> studyCafePasses;

    public StudyCafePasses(List<StudyCafePass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }

    public static StudyCafePasses of(List<StudyCafePass> studyCafePasses){
        return new StudyCafePasses(studyCafePasses);
    }

    public StudyCafePasses getPassListSameType(StudyCafePassType type){
        List<StudyCafePass> studyCafePasses = new ArrayList<>();

        return of(studyCafePasses.stream()
            .filter(pass -> pass.isSameType(type))
            .toList());
    }






}
