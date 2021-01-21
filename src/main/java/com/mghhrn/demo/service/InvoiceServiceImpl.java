package com.mghhrn.demo.service;

import com.mghhrn.demo.dao.InvoiceRepository;
import com.mghhrn.demo.entity.Invoice;
import com.mghhrn.demo.enums.InvoiceStatus;
import com.mghhrn.demo.enums.WarningReason;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void makeInvoiceOnTheWay(Long invoiceId) throws InterruptedException {
        System.out.println("started makeInvoiceOnTheWay at " + LocalDateTime.now());
        Optional<Invoice> invoiceOpt = invoiceRepository.findById(invoiceId);
        Invoice invoice = invoiceOpt.get();
        invoice.setStatus(InvoiceStatus.ON_THE_WAY);
        Thread.sleep(10000);
        System.out.println("makeInvoiceOnTheWay woke up!");
        invoiceRepository.save(invoice);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void setWarning(Long invoiceId, WarningReason warningReason) {
        System.out.println("started setWarning at " + LocalDateTime.now());
        Optional<Invoice> invoiceOpt = invoiceRepository.findById(invoiceId);
        Invoice invoice = invoiceOpt.get();
        invoice.setIsWarning(Boolean.TRUE);
        invoice.setWarningReason(warningReason);
        invoiceRepository.save(invoice);
        System.out.println("setWarning end");
    }
}
