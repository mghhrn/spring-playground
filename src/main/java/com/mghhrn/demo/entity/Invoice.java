package com.mghhrn.demo.entity;

import com.mghhrn.demo.enums.InvoiceStatus;
import com.mghhrn.demo.enums.WarningReason;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString @Getter @Setter
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InvoiceStatus status;

    @Column(name = "is_warning")
    private Boolean isWarning;

    @Column(name = "warning_reason")
    private WarningReason warningReason;

    @Version
    private Long version;
}
