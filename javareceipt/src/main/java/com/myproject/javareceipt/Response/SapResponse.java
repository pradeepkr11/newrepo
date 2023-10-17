package com.myproject.javareceipt.Response;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SapResponse {
    private Long receiptId;

    private Long orderId;

    private Long vendorId;

    private LocalDate creationDate;

    private String truckId;

    private float quantity;

    private String materialCode;

    private String materialDescription;

    private String paymentTerm;

    private String paymentTermDescription;

    private float cgst;

    private float igst;

    private float sgst;

    private float ugst;
}
