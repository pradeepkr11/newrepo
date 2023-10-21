package com.myproject.javareceipt.controller;

import com.myproject.javareceipt.entity.GoodsReceipt;
import com.myproject.javareceipt.entity.PurchaseOrder;
import com.myproject.javareceipt.service.GoodsReceiptService;
import com.myproject.javareceipt.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/javaservice")
public class myRestController {

    private final PurchaseOrderService purchaseOrderService;

    private final GoodsReceiptService goodsReceiptService;
    public myRestController(PurchaseOrderService purchaseOrderService,
                            GoodsReceiptService goodsReceiptService){
        this.purchaseOrderService = purchaseOrderService;
        this.goodsReceiptService = goodsReceiptService;
    }

    @GetMapping("/purchase-order/{po}")
    public List<GoodsReceipt> getByPO(@PathVariable Long po){
        return purchaseOrderService.getReceiptsByPO(po);
    }

    @GetMapping("/goods-receipt/{id}")
    public GoodsReceipt getByReceipt(@PathVariable Long id){
        return goodsReceiptService.getByReceiptId(id);
    }
}
