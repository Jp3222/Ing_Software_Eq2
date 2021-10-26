package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ficheros {

    private File file;
    private String txt;
    private FileReader fr;

    public Ficheros() {
        //this.file = new File("Info/" + nom + ".txt");
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String leer(String url) {
        String str = "";
        try {
            fr = new FileReader(getClass().getResource(url).getFile());
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
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Problemas con el buffer");
            ex.printStackTrace();
        }
        return "Fichero no encontrado";
    }

    public static class Files {

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
