package telas.gui;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
//import api iText 
//import com.lowagie.text.*; 
//import com.lowagie.text.pdf.PdfWriter; 
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarRelatorios {

	public void GerarPdf(String cpfPaciente, String[] parciais, String cardioPre, String respPre, String artePre,
			String cardioPos, String respPos, String artePos) {

		Document document = new Document(PageSize.A4);

		String paciente = "Relatório Sessão Simplificado - " + cpfPaciente + ".pdf";
		String arquivo = "C:\\Users\\Maurício Realan\\eclipse-workspace\\Victus Teste1\\relatorios\\" + paciente;
		String nomepaciente = "Paciente - " + cpfPaciente;

		try {
			PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			document.open(); // adicionando um parágrafo ao documento
			Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
			Paragraph p1 = new Paragraph("Projeto Victus", f);
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setSpacingAfter(22);
			document.add(p1);
			Paragraph p1b = new Paragraph("Relatório de Sessão Simplificado", f);
			p1b.setAlignment(Element.ALIGN_CENTER);
			p1b.setSpacingAfter(20);
			document.add(p1b);
			Paragraph p2 = new Paragraph(nomepaciente);
			p2.setSpacingAfter(18);
			document.add(p2);

			PdfPTable table2 = new PdfPTable(2);
			PdfPCell header2 = new PdfPCell(new Paragraph("Coletas Manuais"));
			header2.setColspan(2);
			table2.addCell(header2);
			table2.addCell(cardioPre);
			table2.addCell(respPre);
			table2.addCell(artePre);
			table2.addCell(cardioPos);
			table2.addCell(respPos);
			table2.addCell(artePos);
			document.add(table2);

			PdfPTable table = new PdfPTable(4);
			PdfPCell header = new PdfPCell(new Paragraph("Parciais da Sessão"));
			header.setColspan(4);
			table.addCell(header);
			for (int i = 0; i < parciais.length; i++) {
				table.addCell(parciais[i]);
			}
			document.add(table);

			JOptionPane.showMessageDialog(null, "Relatório Gerado com Sucesso!");

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();

	}

	// Read more:
	// http://www.linhadecodigo.com.br/artigo/863/geracao-de-arquivos-pdf-com-java.aspx#ixzz4oenGcrb4

}
