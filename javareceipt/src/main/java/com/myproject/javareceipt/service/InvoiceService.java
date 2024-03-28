package com.myproject.javareceipt.service;
import com.myproject.javareceipt.entity.Invoice;

import java.util.List;
public interface InvoiceService {
    void  createInvoice(List<Invoice> invoiceList);
}
