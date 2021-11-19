package Modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Reportes {

    private final Document documento;
    private PdfPTable table;

    public Reportes(int url, String nombre) throws FileNotFoundException, DocumentException {
        this.documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(cons.url(url) + "/" + nombre + ".pdf"));
        documento.open();
    }

    public void crearReporte(String tabla, String[] campos) {
        try {
            table = new PdfPTable(campos.length);
            for (String string : campos) {
                table.addCell(string);
            }
            ResultSet rs = BD.getNodo().Buscar(tabla);
            while (rs.next()) {
                for (String string : campos) {
                    table.addCell(rs.getString(string));
                }
            }
            documento.add(table);
            documento.close();
        } catch (SQLException | DocumentException e) {
            System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Documento Generado");

    }

}
