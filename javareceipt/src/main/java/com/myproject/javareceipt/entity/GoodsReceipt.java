package com.myproject.javareceipt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "goods_receipt")
public class GoodsReceipt {

    @Id
    @Column(name = "goods_receipt_id")
    private Long goodsReceiptId;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    @JsonManagedReference
    private PurchaseOrder purchaseOrderId;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "truck_id")
    private String truckId;

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "material_code")
    private String materialCode;

    @Column(name = "material_desc")
    private String materialDescription;

    @Column(name = "payment_term")
    private String paymentTerm;

    @Column(name = "payment_term_desc")
    private String paymentTermDescription;

    @Column(name = "cgst")
    private float cgst;

    @Column(name = "igst")
    private float igst;

    @Column(name = "sgst")
    private float sgst;

    @Column(name = "ugst")
    private float ugst;
}
