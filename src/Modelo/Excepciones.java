package Modelo;

/**
 *
 * @author jp
 */
public class Excepciones extends Exception {

    //Modelo
    /**
     * ERROR_IN_CLASS_BD = 100;
     */
    public static final int ERROR_IN_CLASS_BD = 100;
    /**
     * ERROR_IN_CLASS_EMPLEADO = 200;
     */
    public static final int ERROR_IN_CLASS_EMPLEADO = 200;
    /**
     * ERROR_IN_CLASS_OPERACIONES = 300;
     */
    public static final int ERROR_IN_CLASS_OPERACIONES = 300;
    /**
     * ERROR_IN_CLASS_PRODUCTO = 400;
     */
    public static final int ERROR_IN_CLASS_PRODUCTO = 400;
    //Vista
    /**
     * ERROR_IN_CLASS_V_LOGIN = 500;
     */
    public static final int ERROR_IN_CLASS_V_LOGIN = 500;
    /**
     * ERROR_IN_CLASS_V_MA = 600;
     */
    public static final int ERROR_IN_CLASS_V_MA = 600;
    /**
     * ERROR_IN_CLASS_V_ME = 700;
     */
    public static final int ERROR_IN_CLASS_V_ME = 700;
    /**
     * ERROR_IN_CLASS_M_P = 800;
     */
    public static final int ERROR_IN_CLASS_M_P = 800;
    //Controladores
    /**
     * ERROR_IN_CLASS_CON_LOGIN = 900;
     */
    public static final int ERROR_IN_CLASS_CON_LOGIN = 900;
    /**
     * ERROR_IN_CLASS_CON_MENU = 1000;
     */
    public static final int ERROR_IN_CLASS_CON_MENU = 1000;
    /**
     * ERROR_IN_CLASS_CON_RELOG = 2000;
     */
    public static final int ERROR_IN_CLASS_CON_RELOG = 2000;

    public Excepciones(String txt) {
        super(txt);
    }

    /**
     *
     * @param error parametro para definir el tipo de error
     * @return El mensaje de la excepcion correspondiente
     */
    public static String getMensaje(int error) {
        String obj = switch (error) {
            case 100:
                yield str(error, "BD");
            case 101:
                yield mess(error, "Campo no valido");
            case 103:
                yield mess(error, "Indice no valido");
            case 104:
                yield mess(error, "Campo no encontrado");
            case 105:
                yield mess(error,"Index fuera de rango");
            case 200:
                yield str(error, "Empleado");
            case 300:
                yield str(error, "Operaciones");
            case 400:
                yield str(error, "Producto");
            case 500:
                yield str(error, "Login");
            case 600:
                yield str(error, "Menu Admin");
            case 700:
                yield str(error, "Menu Empleado");
            case 800:
                yield str(error, "CRUD Productos");
            case 900:
                yield str(error, "Controlador Login");
            case 1000:
                yield str(error, "Controlador Menu");
            case 2000:
                yield str(error, "Controlador Relog");
            case 3000:
                yield "Objeto nulo";
            default:
                yield "Motivo Desconociodo";
        };
        return obj;
    }

    /**
     * @param error numero de error
     * @param clase clase en la cual a ocurrido un error
     * @return retorna el mensaje "Error + NoError + ocurrido en la clase +
     * clase;
     */
    private static String str(int error, String clase) {
        return "Error " + error + " ocurrido en la clase " + clase;
    }

    private static String mess(int error, String mess) {
        return "Error " + error + " "+mess;
    }

}
