package com.fty.controller;

import com.fty.entity.User;
import com.fty.service.MyBatisUserService;
import com.fty.service.UserService;
import com.fty.service.mybatisInterface.MybatisUserDao;
import com.fty.util.PdfExportService;
import com.fty.util.PdfView;
import com.lowagie.text.*;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pdfview")
public class PdfViewController {
    @Autowired
    private MyBatisUserService myBatisUserService = null;

    @GetMapping(value = "/download")
    public ModelAndView exportPdf(String userName,String note){
        List<User> userList = myBatisUserService.getUsers(userName,note);
        View view = new PdfView(new PdfExportService() {
            @Override
            public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) {
                try {
                    document.setPageSize(PageSize.A4);
                    document.addTitle("用户信息");
                    document.add(new Chunk("\n"));
                    PdfPTable table = new PdfPTable(3);
                    PdfPCell cell = null;
                    Font f8 = new Font();
                    java.util.List<User> userList = (List<User>) model.get("userList");
                    for (User user : userList) {
                        document.add(new Chunk("\n"));
                        cell = new PdfPCell(new Paragraph("note", f8));
                        table.addCell(cell);
                    }
                    document.add(table);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });
        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("userList",userList);
        return  mv;
    }


}
