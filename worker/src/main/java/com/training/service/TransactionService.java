package com.training.service;

import com.training.Transaction;
import com.training.mapper.TransactionMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionService(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    public void doReport() throws IOException {

        List<Transaction> transactions = transactionMapper.getListTransaction();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Transactions");

        Row headerRow = sheet.createRow(0);

        //id cell
        Cell idCell = headerRow.createCell(0);
        idCell.setCellValue("Id");

        //date cell
        Cell dateCell = headerRow.createCell(1);
        dateCell.setCellValue("date");

        //phone cell
        Cell phoneCell = headerRow.createCell(2);
        phoneCell.setCellValue("phone");

        //product cell
        Cell productCell = headerRow.createCell(3);
        productCell.setCellValue("product");

        DataFormat format = workbook.createDataFormat();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));

        int rowIdx = 1;
        for (Transaction transaction : transactions){
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(transaction.getId());
            row.createCell(1).setCellValue(transaction.getDate());
            row.createCell(2).setCellValue(transaction.getPatient_id().getPhone());
            row.createCell(3).setCellValue(transaction.getProduct_id().getName());
        }

        FileOutputStream fileOut = new FileOutputStream("transactions.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
