package com.myproject.javareceipt.service;

import com.myproject.javareceipt.entity.GoodsReceipt;
import com.myproject.javareceipt.exception.NoOrderForVendorException;
import com.myproject.javareceipt.exception.OrderNotFoundException;
import com.myproject.javareceipt.repository.GoodsReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Long> getPoByVendorId(Long id) {
        List<Long> orderList =  goodsReceiptRepository.getPoByVendorId(id);
        if(orderList.isEmpty()){
            throw new NoOrderForVendorException("Vendor has no Orders");
        }
        return orderList;
    }

    @Override
    public List<GoodsReceipt> getReceiptByOrderId(Long id) {
        List<GoodsReceipt> goodsReceiptList = goodsReceiptRepository.findByOrderIdAndInvoiceIdIsNull(id);
        if(goodsReceiptList.isEmpty()){
            throw new OrderNotFoundException(String.format("Order id %s doesn't exist",id));
        }
        return goodsReceiptList;
    }

    @Override
    public GoodsReceipt getReceiptById(Long id) {
        return goodsReceiptRepository.findByGoodsReceiptIdAndInvoiceIdIsNull(id);
    }
}
