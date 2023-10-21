package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.GoodsReceipt;

public interface GoodsReceiptService {
    GoodsReceipt getByReceiptId(Long id);
}
