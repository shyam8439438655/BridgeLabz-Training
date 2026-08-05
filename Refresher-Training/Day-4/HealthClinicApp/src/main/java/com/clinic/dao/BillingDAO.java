package com.clinic.dao;

import com.clinic.dto.Billing;
import java.util.List;

public interface BillingDAO {
    int insertBilling(Billing billing);
    Billing getBillingById(int id);
    Billing getBillingByAppointmentId(int appointmentId);
}
