package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.GoodsReceipt;
import com.myproject.javareceipt.repository.GoodsReceiptRepository;
import com.myproject.javareceipt.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsReceiptServiceImpl implements GoodsReceiptService {

    private final GoodsReceiptRepository goodsReceiptRepository;
    public GoodsReceiptServiceImpl(GoodsReceiptRepository goodsReceiptRepository){
        this.goodsReceiptRepository = goodsReceiptRepository;
    }
    @Override
    public GoodsReceipt getByReceiptId(Long id) {
        GoodsReceipt goodsReceipt = goodsReceiptRepository.findById(id).orElse(null);
        return goodsReceipt;
    }
}
