package com.myproject.javareceipt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
    @Id
    @Column(name = "purchase_order_id")
    private Long purchaseOrderId;

    @OneToMany(mappedBy = "purchaseOrderId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GoodsReceipt> goodsReceipts;

    public void add(GoodsReceipt goodsReceipt){
        if(goodsReceipts == null){
            goodsReceipts = new ArrayList<>();
        }
        goodsReceipts.add(goodsReceipt);
    }
}
