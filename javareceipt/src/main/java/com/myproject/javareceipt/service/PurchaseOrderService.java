package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.GoodsReceipt;

import java.util.List;

public interface PurchaseOrderService {
    List<GoodsReceipt> getReceiptsByPO(Long PO);


}
