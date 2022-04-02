package uz.pdp.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import uz.pdp.dto.BookDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class GeneratePdfService {

    public static ByteArrayInputStream booksReport(List<BookDto> books) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 3, 3, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell cell1 = PdfPCell("T/R", headFont);
            table.addCell(cell1);

            PdfPCell cell2 = PdfPCell("Name", headFont);
            table.addCell(cell2);

            PdfPCell cell3 = PdfPCell("Author", headFont);
            table.addCell(cell3);

            PdfPCell cell4 = PdfPCell("Price", headFont);
            table.addCell(cell4);

            PdfPCell cell5 = PdfPCell("Size", headFont);
            table.addCell(cell5);


            for (int i = 0; i < books.size(); i++) {
                BookDto book = books.get(i);

                PdfPCell(table, i + 1 + "");
                PdfPCell(table, book.getName());
                PdfPCell(table, book.getAuthor());
                PdfPCell(table, book.getPrice().toString());
                PdfPCell(table, book.getSize().toString());
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            document.close();

        } catch (DocumentException ex) {
            System.out.println("ex = " + ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static PdfPCell PdfPCell(String name, Font headFont) {
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase(name, headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return hcell;
    }

    private static void PdfPCell(PdfPTable table, String book) {
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(book));
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingRight(10);
        table.addCell(cell);
    }
;

}
