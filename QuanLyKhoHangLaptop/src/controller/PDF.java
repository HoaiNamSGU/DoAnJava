package controller;
import java.awt.Graphics2D;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import view.CuaHangView;

public class PDF {

    public static void main(String[] args) {
        CuaHangView phieuXuat = new CuaHangView();
        phieuXuat.setVisible(true);
        generatePDF("phieu_xuat.pdf", phieuXuat);
    }

    public static void generatePDF(String filename, CuaHangView frame) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            Graphics2D g2d = template.createGraphics(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            //frame.paintComponent(g2d);
            g2d.dispose();
            cb.addTemplate(template, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
