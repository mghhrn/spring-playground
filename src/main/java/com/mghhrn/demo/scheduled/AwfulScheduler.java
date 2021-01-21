package com.mghhrn.demo.scheduled;

import com.mghhrn.demo.entity.Invoice;
import com.mghhrn.demo.enums.WarningReason;
import com.mghhrn.demo.service.InvoiceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class AwfulScheduler {

    private InvoiceService invoiceService;

    public AwfulScheduler(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Scheduled(fixedDelay = 20000000)
    public void process1() throws InterruptedException {
        try {
            invoiceService.makeInvoiceOnTheWay(1L);
        } catch (Exception e) {
            e.printStackTrace();
            invoiceService.makeInvoiceOnTheWay(1L);
        }
    }

    @Scheduled(initialDelay = 2000, fixedDelay = 20000000)
    public void process2() {
        invoiceService.setWarning(1L, WarningReason.VOLCANO_ERUPTION);
    }
}
