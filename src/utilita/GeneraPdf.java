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

	private static String FILE = "C:/RicevutaPrenotazione.pdf";
	private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		Pdf pdf = DAOPdf.getPdfByIdPaziente(1);

		File f = new File(FILE);
		f.delete();
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(FILE));
		document.open();

		Paragraph sectionParagraph = new Paragraph("Ricevuta Esame ", subFont);
		sectionParagraph.setAlignment(Element.ALIGN_CENTER);
		aggiungiLineaVuota(sectionParagraph, 2);
		sectionParagraph.add(new Paragraph("Paziente: " + pdf.getNomePaziente() + " " + pdf.getCognomePaziente()
				+ ", nato/a il: " + pdf.getDataNas()));
		aggiungiLineaVuota(sectionParagraph, 1);

		sectionParagraph.add(new Paragraph("Codice Fiscale: " + pdf.getCf()));
		// Section section = chapter.addSection(sectionParagraph);
		// section.add(new Paragraph("Paragrafo 1"));
		aggiungiLineaVuota(sectionParagraph, 1);
		Paragraph paragraph = new Paragraph();
		aggiungiLineaVuota(paragraph, 2);
		creaTabella(sectionParagraph, pdf);
		sectionParagraph.add(paragraph);

		// Aggiungiamo una tabella

		sectionParagraph.add(new Paragraph("Note: " + pdf.getNote()));
		// Aggiunta al documento
		document.add(sectionParagraph);

		// Prossimo capitolo

		// section = sectionParagraph.addSection(sectionParagraph);
		// section.add(new Paragraph("Paragrafo 1"));

		// Aggiunta al documento
		// document.add(sectionParagraph);
		document.close();

	}

	private static void creaTabella(Paragraph section, Pdf pdf) throws BadElementException {

		float[] columnWidths = { 5, 3, 2, 7, 7 };
		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		// tabella.setBorderColor(BaseColor.GRAY);
		// tabella.setPadding(4);
		// tabella.setSpacing(4);
		// tabella.setBorderWidth(1);

		PdfPCell c1 = new PdfPCell(new Phrase("Esame"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		// c1.setGrayFill(0.8f);
		tabella.addCell(c1);
		c1 = new PdfPCell(new Phrase("Data Esame"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase("Costo"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase("Nome Azienda"));
		c1.setFixedHeight(34f);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase("Indirizzo"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setBorderColor(BaseColor.BLACK);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);

		tabella.setHeaderRows(1);

		c1 = new PdfPCell(new Phrase(pdf.getEsame()));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setFixedHeight(34f);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase(pdf.getDataEsame()));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase(pdf.getCosto() + ""));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase(pdf.getNomeAzienda()));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase(pdf.getIndirizzoAzienda()));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(c1);

		c1 = new PdfPCell(new Phrase(pdf.getIndirizzoAzienda()));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(c1);

		section.add(tabella);

	}

	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
