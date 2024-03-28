package com.myproject.javareceipt.controller;

import com.myproject.javareceipt.entity.GoodsReceipt;
import com.myproject.javareceipt.entity.Invoice;
import com.myproject.javareceipt.service.GoodsReceiptService;
import com.myproject.javareceipt.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/java-service")
public class myRestController {

    private final GoodsReceiptService goodsReceiptService;

    private final InvoiceService invoiceService;

    public myRestController(GoodsReceiptService goodsReceiptService, InvoiceService invoiceService) {
        this.goodsReceiptService = goodsReceiptService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/orders")
    public List<Long> getPoByVendorId(@RequestParam(name = "user") Long user){
        return goodsReceiptService.getPoByVendorId(user);
    }

    @GetMapping("/orders/{id}")
    public List<GoodsReceipt> getReceiptByOrderId(@PathVariable Long id){
        return goodsReceiptService.getReceiptByOrderId(id);
    }

    @GetMapping("/orders/{id}/receipts/{receiptId}")
    GoodsReceipt getReceiptById(@PathVariable Long id, @PathVariable Long receiptId){
        return goodsReceiptService.getReceiptById(receiptId);
    }

//    @GetMapping("/purchase-order/{po}")
//    public List<GoodsReceipt> getByPO(@PathVariable Long po){
//        return purchaseOrderService.getReceiptsByPO(po);
//    }

//    @GetMapping("/goods-receipt/{id}")
//    public GoodsReceipt getByReceipt(@PathVariable Long id){
//        return goodsReceiptService.getByReceiptId(id);
//    }

    @PostMapping("/invoice")
    public void createInvoice(@RequestBody List<Invoice> invoiceList){
        invoiceService.createInvoice(invoiceList);
    }


}
