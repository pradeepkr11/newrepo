package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.GoodsReceipt;
import com.myproject.javareceipt.entity.PurchaseOrder;
import com.myproject.javareceipt.repository.GoodsReceiptRepository;
import com.myproject.javareceipt.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository
    ,GoodsReceiptRepository goodsReceiptRepository){
        this.purchaseOrderRepository = purchaseOrderRepository;
    }
    @Override
    public List<GoodsReceipt> getReceiptsByPO(Long PO) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(PO).orElse(null);
        if(purchaseOrder != null){
            return purchaseOrder.getGoodsReceipts();
        }
        return null;
    }

}
