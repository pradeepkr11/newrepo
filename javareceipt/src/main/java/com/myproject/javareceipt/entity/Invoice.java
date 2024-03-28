package com.myproject.javareceipt.entity;

import com.myproject.javareceipt.compositeKey.InvoiceKey;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "invoice")
@IdClass(InvoiceKey.class)
public class Invoice {

    @Id
    @Column(name = "goods_receipt_id")
    private Long goodsReceiptId;

    @Id                          //Composite primary key
    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "material_code")
    private String materialCode;

    @Column(name = "material_price")
    private Float materialPrice;

    @Column(name = "material_qty")
    private float materialQty;

    @Column(name = "grn_amount")
    private Float grnAmount;

    @Column(name = "grn_amount_with_tax")
    private Float grnAmountWithTax;

    @Column(name = "total_invoice_amount")
    private Float totalInvoiceAmount;

}
