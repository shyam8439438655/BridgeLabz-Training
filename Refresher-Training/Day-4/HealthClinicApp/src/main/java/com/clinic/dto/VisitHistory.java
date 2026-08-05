package com.clinic.dto;

import java.time.LocalDateTime;

public class VisitHistory {
    private int historyId;
    private int appointmentId;
    private String diagnosis;
    private LocalDateTime visitDate;

    public VisitHistory() {}

    public VisitHistory(int appointmentId, String diagnosis, LocalDateTime visitDate) {
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.visitDate = visitDate;
    }

    public int getHistoryId() { return historyId; }
    public void setHistoryId(int historyId) { this.historyId = historyId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public LocalDateTime getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }

    @Override
    public String toString() {
        return "VisitHistory [HistoryID=" + historyId + ", ApptID=" + appointmentId + 
               ", Diagnosis=" + diagnosis + ", Date=" + visitDate + "]";
    }
}
