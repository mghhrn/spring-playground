package com.mghhrn.demo.service;

import com.mghhrn.demo.enums.WarningReason;

public interface InvoiceService {

    void makeInvoiceOnTheWay(Long invoiceId) throws InterruptedException;
    void setWarning(Long invoiceId, WarningReason warningReason);
}
