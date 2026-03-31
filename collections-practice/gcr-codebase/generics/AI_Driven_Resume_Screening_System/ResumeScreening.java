package AI_Driven_Resume_Screening_System;

// ResumeScreeningMain.java
import java.util.ArrayList;
import java.util.List;

public class ResumeScreening {
    public static void main(String[] args) {

        // Create role objects (candidate data)
        SoftwareEngineer se1 = new SoftwareEngineer("Shyam", 75);
        DataScientist ds1 = new DataScientist("Aman", 62);
        ProductManager pm1 = new ProductManager("Neha", 80);

        // Create resumes (type safe)
        Resume<SoftwareEngineer> r1 = new Resume<>("R001", se1);
        Resume<DataScientist> r2 = new Resume<>("R002", ds1);
        Resume<ProductManager> r3 = new Resume<>("R003", pm1);

        // Process resumes (generic method)
        ResumeProcessor.processResume(r1);
        ResumeProcessor.processResume(r2);
        ResumeProcessor.processResume(r3);

        // Wildcard pipeline list
        List<JobRole> pipeline = new ArrayList<>();
        pipeline.add(se1);
        pipeline.add(ds1);
        pipeline.add(pm1);

        // Wildcard method call
        ScreeningPipeline.screenAllRoles(pipeline);
    }
}
