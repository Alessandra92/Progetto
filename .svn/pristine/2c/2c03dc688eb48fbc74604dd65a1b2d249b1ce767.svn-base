package utilita;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
 
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modello.Pdf;
import persistenza.dao.DAOPdf;





public class GeneraPdf {
		 public GeneraPdf() {
		super();
		// TODO Auto-generated constructor stub
	}


		private static String FILE = "C:/Test.pdf";
		 private static Font bigFont  = new Font(Font.FontFamily.TIMES_ROMAN, 18,  Font.BOLD);
		 private static Font redFont  = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.NORMAL, BaseColor.RED);
		 private static Font subFont  = new Font(Font.FontFamily.TIMES_ROMAN, 16,  Font.BOLD);
		 private static Font smallBold  = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.BOLD);
	
	
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
		Pdf pdf=DAOPdf.getPdfByIdPaziente(1);
		
		File f= new File(FILE);
		f.delete();
		Document document = new Document(PageSize.A4);
		   PdfWriter.getInstance(document, new FileOutputStream(FILE));
		   document.open();
		
		   Chapter chapter = new Chapter(new Paragraph("Primo Capitolo", bigFont), 1);
		   Paragraph sectionParagraph = new Paragraph("Sezione 1", subFont);
		   Section section = chapter.addSection(sectionParagraph);
		   section.add(new Paragraph("Paragrafo 1"));
		  
		   Paragraph paragraph = new Paragraph();
		   aggiungiLineaVuota(paragraph, 2);
		   section.add(paragraph);
		  
		   // Aggiungiamo una tabella
		   creaTabella(section,pdf);
		  
		   // Aggiunta al documento
		   document.add(chapter);
		  
		   // Prossimo capitolo
		  
		   sectionParagraph = new Paragraph(pdf.getNote(), subFont);
		   section = chapter.addSection(sectionParagraph);
		   section.add(new Paragraph("Paragrafo 1"));
		  
		   // Aggiunta al documento
		   document.add(chapter);
		   document.close();

	}
	
	
	
	
	
	private static void creaTabella(Section section, Pdf pdf) throws BadElementException {
		  PdfPTable tabella = new PdfPTable(6);
		  tabella.setWidthPercentage(100);

		  // tabella.setBorderColor(BaseColor.GRAY);
		  // tabella.setPadding(4);
		  // tabella.setSpacing(4);
		  // tabella.setBorderWidth(1);
		 
		  PdfPCell c1 = new PdfPCell(new Phrase("Esame"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		  c1 = new PdfPCell(new Phrase("Data Esame"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		 
		  c1 = new PdfPCell(new Phrase("Costo"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		  
		  c1 = new PdfPCell(new Phrase("Note"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		 
		  c1 = new PdfPCell(new Phrase("Nome Azienda"));
		  c1.setFixedHeight(35f);
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		  
		  c1 = new PdfPCell(new Phrase("Indirizzo"));
		  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  c1.setGrayFill(0.8f);
		  tabella.addCell(c1);
		  
		  
		  
		  tabella.setHeaderRows(1);
		 
		  tabella.addCell(pdf.getEsame());
		  tabella.addCell(pdf.getDataEsame());
		  tabella.addCell(pdf.getCosto()+"");
		  tabella.addCell(pdf.getNote());
		  tabella.addCell(pdf.getNomeAzienda());
		  tabella.addCell(pdf.getIndirizzoAzienda());
	
		 
		  section.add(tabella);
		 
		 }
	
	
	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		  for (int i = 0; i < number; i++) {
		   paragraph.add(new Paragraph(" "));
		  }
	}

}
