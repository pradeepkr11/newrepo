package com.myproject.javareceipt.scheduler;

import com.myproject.javareceipt.response.SapResponse;
import com.myproject.javareceipt.entity.GoodsReceipt;
import com.myproject.javareceipt.repository.GoodsReceiptRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Component
public class CronJob {

    //Declare RestTemplate property
    private final RestTemplate restTemplate;

    private final GoodsReceiptRepository goodsReceiptRepository;

//    private final PurchaseOrderRepository purchaseOrderRepository;

    private LocalDate date ;

    @Value("${SAP_API_ENDPOINT}")
    private String url;

    private String finalUrl;

    public CronJob(RestTemplate restTemplate, GoodsReceiptRepository goodsReceiptRepository){
        this.restTemplate = restTemplate;
        this.goodsReceiptRepository = goodsReceiptRepository;
    }


    private GoodsReceipt goodsReceipt;

//    private PurchaseOrder purchaseOrder;

    private SapResponse sapResponse;

    private List<GoodsReceipt> goodsReceipts;

    @Scheduled(cron = "0 */01 * * * *")
    public void getSapData() {
        date = LocalDate.now();
        finalUrl = "";
        finalUrl = url + date.toString();
        try{
        SapResponse[] sapResponseArray = restTemplate.getForObject(finalUrl, SapResponse[].class);

//        for (SapResponse tempResponse : sapResponseArray) {
//            goodsReceipt = null;
////            purchaseOrder = purchaseOrderRepository.findById(tempResponse.getOrderId()).orElse(null);
//
//            if (purchaseOrder == null) {
//                purchaseOrder = new PurchaseOrder();
//                purchaseOrder.setPurchaseOrderId(tempResponse.getOrderId());
//
//                goodsReceipt = new GoodsReceipt();
//
//                goodsReceipt.setGoodsReceiptId(tempResponse.getReceiptId());
//                goodsReceipt.setVendorId(tempResponse.getVendorId());
//                goodsReceipt.setCreationDate(tempResponse.getCreationDate());
//                goodsReceipt.setTruckId(tempResponse.getTruckId());
//                goodsReceipt.setQuantity(tempResponse.getQuantity());
//                goodsReceipt.setMaterialCode(tempResponse.getMaterialCode());
//                goodsReceipt.setMaterialDescription(tempResponse.getMaterialDescription());
//                goodsReceipt.setPaymentTerm(tempResponse.getPaymentTerm());
//                goodsReceipt.setPaymentTermDescription(tempResponse.getPaymentTermDescription());
//                goodsReceipt.setCgst(tempResponse.getCgst());
//                goodsReceipt.setIgst(tempResponse.getIgst());
//                goodsReceipt.setSgst(tempResponse.getSgst());
//                goodsReceipt.setUgst(tempResponse.getUgst());
//
//                goodsReceipt.setPurchaseOrderId(purchaseOrder);
//
//                //goodsReceipt = goodsReceiptRepository.save(goodsReceipt);
//
//
//                purchaseOrder.add(goodsReceipt);
//
//                purchaseOrderRepository.save(purchaseOrder);
//            } else {
//                goodsReceipts = purchaseOrder.getGoodsReceipts();
//
//                goodsReceipt = new GoodsReceipt();
//
//                goodsReceipt.setGoodsReceiptId(tempResponse.getReceiptId());
//                goodsReceipt.setVendorId(tempResponse.getVendorId());
//                goodsReceipt.setCreationDate(tempResponse.getCreationDate());
//                goodsReceipt.setTruckId(tempResponse.getTruckId());
//                goodsReceipt.setQuantity(tempResponse.getQuantity());
//                goodsReceipt.setMaterialCode(tempResponse.getMaterialCode());
//                goodsReceipt.setMaterialDescription(tempResponse.getMaterialDescription());
//                goodsReceipt.setPaymentTerm(tempResponse.getPaymentTerm());
//                goodsReceipt.setPaymentTermDescription(tempResponse.getPaymentTermDescription());
//                goodsReceipt.setCgst(tempResponse.getCgst());
//                goodsReceipt.setIgst(tempResponse.getIgst());
//                goodsReceipt.setSgst(tempResponse.getSgst());
//                goodsReceipt.setUgst(tempResponse.getUgst());
//
//                goodsReceipt.setPurchaseOrderId(purchaseOrder);
//
//                goodsReceipts.add(goodsReceipt);
//
//                purchaseOrder.setGoodsReceipts(goodsReceipts);
//
//                purchaseOrderRepository.save(purchaseOrder);
//
//
//            }
//        }

    }
    catch(Exception e){
        System.out.println("Exception occurred inside Cronjob class");
        System.out.println(e.getMessage());

    }

//        List<SapResponse> sapResponseList = Arrays.asList(sapResponseArray);
//
//        Map<Long, List<SapResponse>> groupedData = sapResponseList.stream()
//                .collect(Collectors.groupingBy(SapResponse::getOrderId));
//
//        for (Map.Entry<Long, List<SapResponse>> entry : groupedData.entrySet()) {
//            Long orderId = entry.getKey();
//            List<SapResponse> sapResponsesForOrder = entry.getValue();
//
//            // Create a PurchaseOrder entity
//            PurchaseOrder purchaseOrder = new PurchaseOrder();
//            purchaseOrder.setPurchaseOrderId(orderId);
//
//            // Create GoodsReceipt entities for this order
//            List<GoodsReceipt> goodsReceipts = sapResponsesForOrder.stream()
//                    .map(sapResponse -> {
//                        GoodsReceipt goodsReceipt = new GoodsReceipt();
//                        goodsReceipt.setPurchaseOrderId(orderId);
//                        goodsReceipt.setVendorId(sapResponse.getVendorId());
//                        // Set other fields for GoodsReceipt
//
//                        return goodsReceipt;
//                    })
//                    .collect(Collectors.toList());
//
//            // Set the list of GoodsReceipt entities in the PurchaseOrder
//            purchaseOrder.setGoodsReceipts(goodsReceipts);
//
//            // Save the PurchaseOrder and associated GoodsReceipts using your JPA repository
//            purchaseOrderRepository.save(purchaseOrder);
//        }



    }
}
