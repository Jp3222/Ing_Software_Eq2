package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jp
 * @class func clase auxiliar con funciones especiales para el manejo de
 * arreglos y conjuntos indefinidos
 */
public class func {

    /**
     * arreglo de numeros primos
     */
    private static final int NoP[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    /**
     * @param str - nombre del objeto
     * @param cont - contenido del objeto
     * @param precio - precio del objeto
     * @return Hash unico para el objeto
     */
    public static String getID(String str, String cont, String precio) {
        str = str.toLowerCase();
        String array[] = str.split(" ");
        String c = "";
        for (String string : array) {
            c += "" + string.charAt(0);
        }
        c += cont + precio + hash(Double.parseDouble(cont) + Double.parseDouble(precio));
        return c;
    }

    /**
     * @param x numero de partida para el calculo de una clave unica
     * @return un hash unico
     */
    private static int hash(double x) {
        int i = (int) (x);
        int p = (int) (Math.random() * NoP.length);
        i *= i;
        return i % NoP[p];
    }

    /**
     * @param T conjunto de elementos indefinidos
     * @return array de esos elementos indefinidos
     */
    public static int[] getArray(int... T) {
        return T;
    }

    /**
     * @param T conjunto de elementos indefinidos
     * @return array de esos elementos indefinidos
     */
    public static String[] getArray(String... T) {
        return T;
    }

    /**
     * @param array arreglo de cadenas existentes
     * @param ex indices de las cadenas que se requieran excluir
     * @return arreglo sin elementos excluidos
     */
    public static String[] exp(String array[], int... ex) {
        ArrayList<String> obj = new ArrayList<>();
        int[] e = getArray(ex);
        for (int i = 0; i < array.length; i++) {
            if (!in(e, i)) {
                obj.add(array[i]);
            }
        }
        return obj.toArray(String[]::new);
    }

    /**
     * @param array arreglo de enteros
     * @param obj objeto buscado
     * @return true si el objeto pertenece al conjunto dado
     */
    private static boolean in(int[] array, int obj) {
        for (int i : array) {
            if (obj == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array arreglo de cadenas
     * @param obj objeto buscado
     * @return true si el objeto pertenece al conjunto dado
     */
    public static boolean in(String[] array, String obj) {
        for (String string : array) {
            if (obj.equals(string)) {
                return true;
            }
        }
        return false;
    }

    public static void clear(String[] info) {
        Arrays.fill(info, null);
    }

}
