package com.myproject.javareceipt.repository;

import com.myproject.javareceipt.compositeKey.InvoiceKey;
import com.myproject.javareceipt.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, InvoiceKey> {
}
