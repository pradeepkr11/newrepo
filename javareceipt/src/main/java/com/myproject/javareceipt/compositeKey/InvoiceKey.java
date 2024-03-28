package com.myproject.javareceipt.compositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceKey implements Serializable {
    private Long goodsReceiptId;
    private Long invoiceId;

}

