package com.myproject.controller;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.myproject.pojo.Category;

public class PDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Font  helvetica_18_blue = new Font(Font.HELVETICA, 18, Font.BOLDITALIC, Color.BLUE);
        
        List<Category> cat = (List<Category>) model.get("categories");
        Paragraph title = new Paragraph("Welcome to MILLIONS EVERYDAY", helvetica_18_blue);
        
        Phrase producttitle = new Phrase("Are you ready to get rich???");
        
        Phrase producttitle2 = new Phrase("Below are the game categories:");
        
        Phrase thank = new Phrase("Enjoy winning!!!!!");
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
        
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        
       cell.setPhrase(new Phrase("Match 1", helvetica_18_blue));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Match 2", helvetica_18_blue));
        table.addCell(cell);

       cell.setPhrase(new Phrase("Prize", helvetica_18_blue));
        table.addCell(cell);
        
       for (Category ccc : cat) {
            table.addCell(String.valueOf(ccc.getMatch1()));
            table.addCell(String.valueOf(ccc.getMatch2()));
            table.addCell(String.valueOf(ccc.getPrize()));
        }
        
        pdfdoc.add(title);
        pdfdoc.add(producttitle);
        pdfdoc.add(table);
        pdfdoc.add(thank);
    }

    
}