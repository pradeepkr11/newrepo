package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.Invoice;
import com.myproject.javareceipt.repository.GoodsReceiptRepository;
import com.myproject.javareceipt.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private GoodsReceiptRepository goodsReceiptRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, GoodsReceiptRepository goodsReceiptRepository) {
        this.invoiceRepository = invoiceRepository;
        this.goodsReceiptRepository = goodsReceiptRepository;
    }


    @Override
    @Transactional
    public void createInvoice(List<Invoice> invoiceList) {
        invoiceRepository.saveAll(invoiceList);
        List<Long> goodsReceiptId = invoiceList.stream().map(i->i.getGoodsReceiptId()).collect(Collectors.toList());
        Long invoiceId = invoiceList.get(0).getInvoiceId();
//        Long invoice = invoiceList.stream().findAny().map(i->i.getInvoiceId()).get();
        goodsReceiptRepository.updateInvoiceIdByGoodsReceiptId(goodsReceiptId,invoiceId);

    }
}
