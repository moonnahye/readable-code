package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface FileHandler {

    public List<StudyCafePass> readStudyCafePasses();

    public List<StudyCafeLockerPass> readLockerPasses();
}
