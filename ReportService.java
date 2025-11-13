/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.service;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;
import com.marafa.sis.model.Student;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ReportService {
    // sessions: List of maps or strings: course,percent,letter
    public File generateTranscript(Student student, List<Map<String,Object>> courseRows, String outPath) throws Exception {
        PdfWriter writer = new PdfWriter(outPath);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        doc.add(new Paragraph("Marafa Community School").setBold());
        doc.add(new Paragraph("Transcript"));
        doc.add(new Paragraph(student.getFirstName() + " " + student.getLastName() + " - " + student.getRegistrationNumber()));
        if(student.getPhotoPath() != null){
            try{ Image img = new Image(ImageDataFactory.create(student.getPhotoPath())); img.scaleToFit(80,100); doc.add(img);}catch(Exception e){}
        }
        Table t = new Table(new float[]{200,80,80});
        t.addHeaderCell("Course");
        t.addHeaderCell("Percent");
        t.addHeaderCell("Letter");
        for(Map<String,Object> row : courseRows){
            t.addCell((String)row.get("course"));
            t.addCell(String.format("%.2f", (Double)row.get("percent")));
            t.addCell((String)row.get("letter"));
        }
        doc.add(t);
        doc.close();
        return new File(outPath);
    }
}