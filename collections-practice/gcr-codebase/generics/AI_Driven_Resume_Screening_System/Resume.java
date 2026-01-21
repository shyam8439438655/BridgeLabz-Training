package AI_Driven_Resume_Screening_System;

// class for Resume with generic type constraint
public class Resume<T extends JobRole> {
    String resumeId;
    T roleData;

    public Resume(String resumeId, T roleData) {
        this.resumeId = resumeId;
        this.roleData = roleData;
    }

    public T getRoleData() {
        return roleData;
    }

    public void showResume() {
        System.out.println("Resume ID: " + resumeId + " | Role: " + roleData.getRoleName());
    }
}

