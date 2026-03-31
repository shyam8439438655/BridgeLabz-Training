package AI_Driven_Resume_Screening_System;

// class for ScrreningPipeline
import java.util.List;

public class ScreeningPipeline {

    // Wildcard method (handle any job roles list)
    public static void screenAllRoles(List<? extends JobRole> candidates) {
        System.out.println("Screening Pipeline Started...");
        for (JobRole role : candidates) {
            System.out.println("Role found in pipeline: " + role.getRoleName());
        }
        System.out.println("Screening Pipeline Ended...");
        System.out.println("__________");
    }
}

