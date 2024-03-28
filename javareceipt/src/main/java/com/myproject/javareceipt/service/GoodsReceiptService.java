package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.GoodsReceipt;

import java.util.List;

public interface GoodsReceiptService {
    GoodsReceipt getByReceiptId(Long id);

    List<Long> getPoByVendorId(Long id);

    List<GoodsReceipt> getReceiptByOrderId(Long id);

    GoodsReceipt getReceiptById(Long id);
}
