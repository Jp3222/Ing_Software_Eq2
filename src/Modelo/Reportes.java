package Modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Reportes {

    private final Document documento;
    private PdfPTable table;

    /**
     * @param url
     * <br>1 - .BD
     * <br>2 - Reportes Generados
     * <br>3 - Historial de Movimientos
     * <br>4 - J-Shop
     * <br>
     * @param nombre del archivo
     * @throws java.io.FileNotFoundException
     * @throws com.itextpdf.text.DocumentException
     */
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
