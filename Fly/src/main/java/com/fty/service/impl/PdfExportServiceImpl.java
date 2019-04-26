package com.fty.service.impl;

import com.fty.entity.User;
import com.fty.util.PdfExportService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PdfExportServiceImpl implements PdfExportService {
    @Override
    public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) {
//
//        try {
//            document.setPageSize(PageSize.A4);
//            document.addTitle("用户信息");
//            document.add(new Chunk("\n"));
//            PdfPTable table = new PdfPTable(3);
//            PdfPCell cell = null;
//            Font f8 = new Font();
//            java.util.List<User> userList = (List<User>) model.get("userList");
//            for (User user : userList) {
//                document.add(new Chunk("\n"));
//                cell = new PdfPCell(new Paragraph("note", f8));
//                table.addCell(cell);
//            }
//            document.add(table);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
    }
}
