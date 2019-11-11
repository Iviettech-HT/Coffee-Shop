package com.iviettech.coffeeshop.views;

import com.iviettech.coffeeshop.entities.OrderDetailEntity;
import com.iviettech.coffeeshop.entities.OrderEntity;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class ExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map model,
            Workbook wrkbk, HttpServletRequest hsr, HttpServletResponse response)
            throws Exception {
        List<OrderEntity> orders = (List<OrderEntity>) model.get("newOrders");
        response.setHeader("Content-Disposition", "attachment; filename=forex-rates.xls");
        Sheet sheet = wrkbk.createSheet("List Orders");
        Sheet sheet2 = wrkbk.createSheet("Detail Order");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("#");
        header.createCell(1).setCellValue("Order number");
        header.createCell(2).setCellValue("Order date");
        header.createCell(3).setCellValue("Customer name");
        header.createCell(4).setCellValue("Customer phone");
        header.createCell(5).setCellValue("Note");
        header.createCell(6).setCellValue("Total price");
        header.createCell(7).setCellValue("Status");
//2
        Row header2 = sheet2.createRow(0);
        header2.createCell(0).setCellValue("#");
        header2.createCell(1).setCellValue("Order number");
        header2.createCell(2).setCellValue("Product Id");
        header2.createCell(3).setCellValue("Product name");
        header2.createCell(4).setCellValue("Size");
        

        int i = 1;
        int stt = 1;

        int j = 1;
        int sttt = 1;
        double total = 0;
        for (OrderEntity order : orders) {
            Row rowcontain = sheet.createRow(i);
            rowcontain.createCell(0).setCellValue(stt);
            rowcontain.createCell(1).setCellValue(order.getId());
            rowcontain.createCell(2).setCellValue(order.getOrderDate().toString());
            rowcontain.createCell(3).setCellValue(order.getCustomer().getName());
            rowcontain.createCell(4).setCellValue(order.getCustomer().getPhone());
            rowcontain.createCell(5).setCellValue("update");
            rowcontain.createCell(6).setCellValue(order.getTotalPrice());
            rowcontain.createCell(7).setCellValue("update");
            for (OrderDetailEntity item : order.getOrderDetails()) {
                Row rs2 = sheet2.createRow(j);
                rs2.createCell(0).setCellValue(sttt);
                rs2.createCell(1).setCellValue(order.getId());
                rs2.createCell(2).setCellValue(item.getProduct().getId());
                rs2.createCell(3).setCellValue(item.getProduct().getName());
                rs2.createCell(4).setCellValue(String.valueOf(item.getSize())); 
                j++;
                sttt++;
            }
            i++;
            stt++;
        }

    }

}
