package com.clinic.dao;

import com.clinic.dto.VisitHistory;

public interface VisitHistoryDAO {
    int insertVisitHistory(VisitHistory visitHistory);
    VisitHistory getVisitHistoryById(int id);
    VisitHistory getVisitHistoryByAppointmentId(int appointmentId);
}
