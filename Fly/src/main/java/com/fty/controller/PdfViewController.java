package com.fty.controller;

import com.fty.entity.User;
import com.fty.service.MyBatisUserService;
import com.fty.util.PdfExportService;
import com.fty.util.PdfView;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pdfview")
public class PdfViewController {
    @Autowired
    private MyBatisUserService myBatisUserService = null;

    @GetMapping(value = "/download")
    public ModelAndView exportPdf(String userName,String note){
        List<User> user= myBatisUserService.getUsers(userName,note);
        View view = new PdfView(exportService());
        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("userList",user);
        return  mv;
    }

    private  PdfExportService exportService() {
//        return  new PdfExportService(new PdfExportService() {
//            @Override
//            public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) {
//
//            }
//        });
        return   new PdfExportService() {
            @Override
            public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) {

                try {
                    document.setPageSize(PageSize.A4);
                    document.addTitle("用户信息");
                    document.add(new Chunk("\n"));
                    PdfPTable table = new PdfPTable(3);
                    PdfPCell cell = null;
                    Font f8 = new Font();
                    f8.setColor(Color.BLUE);
                    f8.setStyle(Font.BOLD);
                    f8.setSize(18);
                    cell = new PdfPCell(new Paragraph("id",f8));
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph("userName",f8));
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph("Note",f8));
                    table.addCell(cell);
                    List<User> userList = (List<User>) model.get("userList");

                    for (User user : userList) {
                        document.add(new Chunk("\n"));
                        cell = new PdfPCell(new Paragraph(user.getId()+"",f8));
                        System.out.println(user.getUserName());
                        table.addCell(cell);
                        cell =  new PdfPCell(new Paragraph(user.getUserName(),f8));
                        table.addCell(cell);
                        cell = new PdfPCell(new Paragraph(user.getNote(),f8));
                        table.addCell(cell);
                    }
                    document.add(table);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
