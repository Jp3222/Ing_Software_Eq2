package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;

public class Ficheros {

    private File file;
    private String txt;
    private FileReader fr;
    private PrintWriter pw;

    public boolean Exists(String url) {
        file = new File(url);
        return file.exists();
    }

    public String crearCarpeta(String url) {
        file = new File(url);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directorio Creado");
            } else {
                System.out.println("Error al crear direcotirio");
            }
        }
        return url;
    }

    public String crearArchivo(String url, String nom) throws IOException {
        file = new File(url + "/" + nom);
        if (file.exists()) {
            System.out.println("Archivo existente");
        } else {
            file.createNewFile();
        }
        return url + "/" + nom;
    }

    public void escribirArchivo(String url, String txt) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        file = new File(url);
        if (file.exists()) {
            pw = new PrintWriter(file, "utf-8");
            pw.print(txt);
            pw.close();
        } else {
            file.createNewFile();
            escribirArchivo(url, txt);
        }
    }

    public String leer(String url) {
        String str = "";
        try {
            fr = new FileReader(url);
            int x;
            do {
                x = fr.read();
                char c = (char) x;
                str += "" + c;
            } while (x != -1);
            fr.close();
            return str.substring(0, str.length() - 1);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Problemas con el buffer");
        }
        return "Fichero no encontrado";
    }

    public static class FilesRead {

        public final static String INFO_DB_EMPLEADOS = "/Info/txt_1.txt";
        public final static String INFO_DB_PRODUCTOS = "/Info/txt_2.txt";
        public final static String INFO_INTENTARIO = "/Info/txt_3.txt";
        public final static String INFO_CAJA = "/Info/txt_4.txt";
        public final static String INFO_PERFIL = "/Info/txt_5.txt";

        public static String getUrl(int i) {
            return switch (i) {
                case 0:
                    yield INFO_DB_EMPLEADOS;
                case 1:
                    yield INFO_DB_PRODUCTOS;
                case 2:
                    yield INFO_INTENTARIO;
                default:
                    yield "null";
            };
        }
    }
}
