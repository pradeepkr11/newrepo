package com.myproject.javareceipt.repository;

import com.myproject.javareceipt.entity.GoodsReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt,Long> {
}
