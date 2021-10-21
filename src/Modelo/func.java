package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jp
 */
public class func {

    private static final int NoP[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static String getID(String str, String cont, String precio) {
        System.out.println(str);
        String array[] = str.split("_");
        String c = "";
        for (String string : array) {
            c += "" + string.charAt(0);
        }
        c += cont + precio + hash(Double.parseDouble(cont) + Double.parseDouble(precio));
        return c;
    }

    private static int hash(double x) {
        int i = (int) (x);
        int p = (int) (Math.random() * NoP.length);
        i *= i;
        return i % NoP[p];
    }

    public static void set(int index, String[] array, String obj) {
        try {
            if (index < array.length) {
                array[index] = obj;
            } else {
                throw new Excepciones(Excepciones.getMensaje(105));
            }
        } catch (Excepciones e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object get(int index, String[] array) throws Excepciones {
        if (index < array.length) {
            return array[index];
        }
        throw new Excepciones(Excepciones.getMensaje(105));

    }

    public static int LinealSearch(String obj, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean in(String[] array, String obj) {
        for (String string : array) {
            if (obj.equals(string)) {
                return true;
            }
        }
        return false;
    }

    public static int[] getArray(int... T) {
        int[] obj = new int[T.length];
        int x = 0;
        for (int i : T) {
            obj[x] = i;
            x++;
        }
        return obj;
    }

    public static String[] range(String array[], int... ex) {
        ArrayList<String> obj = new ArrayList<>();
        int[] e = getArray(ex);
        for (int i = 0; i < array.length; i++) {
            if (!in(e, i)) {
               obj.add(array[i]);
            }
        }
        return obj.toArray(new String[obj.size()]);
    }

    private static boolean in(int[] array, int obj) {
        for (int i : array) {
            if (obj == i) {
                return true;
            }
        }
        return false;
    }

}
