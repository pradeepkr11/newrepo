package com.myproject.javareceipt.repository;

import com.myproject.javareceipt.entity.GoodsReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt,Long> {

    @Query(value = "SELECT DISTINCT order_id from goods_receipt WHERE goods_receipt.vendor_id = ?1", nativeQuery = true)
    List<Long> getPoByVendorId(Long id);

    List<GoodsReceipt> findByOrderIdAndInvoiceIdIsNull(Long orderId);

    GoodsReceipt findByGoodsReceiptIdAndInvoiceIdIsNull(Long id);

    @Modifying
    @Query(value = "UPDATE goods_receipt SET invoice_id = :invoiceId WHERE goods_receipt_id IN :goodsReceiptId",
            nativeQuery = true)
    void updateInvoiceIdByGoodsReceiptId(List<Long> goodsReceiptId, Long invoiceId);
}
