package actividad07.ejercicio02;

import actividad07.ejercicio01.cuentaCorriente.Utilidades;

/**
 *
 * @author Candela
 */
public class Heladeria {

    private static Comida[] pedido;
    private static Comida cacahuetes;
    private static Horchata horchata1;
    private static Cucurucho cucuruchoGalleta;
    private static Cucurucho cucuruchoChocolate;
    private static SaborHelado saborVainilla;
    private static SaborHelado saborChocolate;
    private static SaborHelado saborCookies;
    private static SaborHelado saborFresa;

    public static void main(String[] args) {
//     • Inicialmente contenga un array de nombre “pedido” con los siguientes valores:
//     ◦ Unos cacahuetes de 99kcal y 1.5€

//     ◦ Una horchata de 250ml, 20kcal, 30% de chufa y 2.5€.
//     ◦ Un cucurucho de galleta de 20kcal y precio 1€. El cucurucho tiene dos sabores:
//     ▪ de vainilla de 30kcal , 1€ , 15% grasa  con azúcar.
//     ▪ de chocolate de 15kcal, 1€ , 15% grasa con aspartamo.
//     ◦ Un cucurucho de galleta de chocolate de 25kcal y precio 1.5€. El cucurucho tiene dos sabores:
//     ▪  de cookies de 35kcal , 1€ , 20% grasa  con azúcar.
//     ▪ de fresa de 10 kcal, 1€ , 5% grasa con aspartamo.
        cacahuetes = new Comida("cacahuetes", 1.5, 99);
        horchata1 = new Horchata("horchata", 2.5, 20, 250, 30);
        cucuruchoGalleta = new Cucurucho("cucurucho galleta", 1, 20, 2);
        cucuruchoChocolate = new Cucurucho("cucurucho de galleta de chocolate", 1.5, 25, 2);
        saborVainilla = new SaborHelado("vainilla", 1, 30, 15, "azucar");
        saborChocolate = new SaborHelado("chocolate", 1, 15, 15, "aspartamo");
        saborCookies = new SaborHelado("cookies", 1, 35, 20, "azucar");
        saborFresa = new SaborHelado("fresa", 1, 10, 5, "aspartamo");

        pedido = new Comida[4];
        pedido[0] = cacahuetes;
        pedido[1] = horchata1;
        pedido[2] = cucuruchoGalleta;
        pedido[3] = cucuruchoChocolate;

        cucuruchoChocolate.addBolaHelado(0, saborFresa);
        cucuruchoChocolate.addBolaHelado(1, saborCookies);

        cucuruchoGalleta.addBolaHelado(0, saborVainilla);
        cucuruchoGalleta.addBolaHelado(1, saborChocolate);

//    6. Muestra la información de todos los productos que forman el “pedido”
//    por consola con un formato parecido al siguiente:
        muestraMenu(pedido);

//    7. Muestra un menú al dependiente para que hasta que no elija salir, 
//pueda ver el pedido actual y/o sustituir tantas veces como se desee un
//elemento del pedido por una horchata con los valores que él indique.
        int opcion;
        int producto;
        do {

            muestraMenu(pedido);

            opcion = eligeOpcionCorrecta();
            switch (opcion) {
                case 1:
                    reemplazaProducto(pedido);

                    break;

                case 2:
                    precioAcumuladoPorProducto(pedido);
                    precioTotalPedido(pedido);
                    break;
                case 3:
                    System.out.println("chau!");

                    break;

            }

        } while (opcion != 3);

    }

    public static void precioPorProducto(Comida array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].toString() != null) {
                double precio = array[i].getPrecio();
                System.out.println("el precio total es: " + precio);
            }
        }

    }

    public static void precioAcumuladoPorProducto(Comida array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getClass().getSimpleName().equalsIgnoreCase("Cucurucho")) {
                double precioTo = ((Cucurucho) array[i]).PrecioTotal();
                System.out.println("---------------------------------------------");
                System.out.println("El precio total del " + ((Cucurucho) array[i]).getNombre() + " y sus bolas es " + precioTo);
            } else {
                double pre = array[i].getPrecio();
                System.out.println("---------------------------------------------");
                System.out.println("El precio total del producto " + array[i].getNombre() + " es " + pre);
            }

        }

    }

    public static void precioTotalPedido(Comida array[]) {

        double precioTo = 0;
        double pre = 0;
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getClass().getSimpleName().equalsIgnoreCase("Cucurucho")) {
                precioTo = precioTo + ((Cucurucho) array[i]).PrecioTotal();

            } else {
                pre = pre + array[i].getPrecio();

            }

        }

        total = precioTo + pre;
        System.out.println("---------------------------------------------");
        System.out.println("El precio total del pedido es: " + total);
    }

    public static void muestraMenu(Comida[] array) {
        System.out.println("----------------------------------------------------");
        System.out.println("Pedido Elegido");
        for (int i = 0; i < array.length; i++) {
            if (array[i].toString() != null) {

                System.out.println(i + " - " + array[i].toString());

            }
        }
    }

    public static int eligeProducto(Comida array[]) {
        int producto = 0;
        do {
            System.out.println("---------------------------------------------");
            producto = Utilidades.pideEntero("dime que numero de producto quieres cambiar:");

            if (producto <= 0 || producto > array.length - 1) {
                System.out.println("*********************************************************************************");
                System.out.println("OPCION INVALIDA! debes elegir entre alguna de las opciones de producto del pedido!");
            }
        } while (producto <= 0 || producto > array.length - 1);

        return producto;
    }

    public static void reemplazaProducto(Comida array[]) {
        int producto = 0;
        producto = eligeProducto(array);
        System.out.println("---------------------------------------------");
        String nom = Utilidades.pideFrase("dime el nombre de la nueva horchata");
        System.out.println("---------------------------------------------");
        double pre = Utilidades.pideDouble("cual es el precio de la horchata?");
        System.out.println("---------------------------------------------");
        int cal = Utilidades.pideEntero("cuantas calorias tiene esta nueva horchata?");
        System.out.println("---------------------------------------------");
        int cant = Utilidades.pideEntero("cual es la cantidad de horchata que tiene el producto?");
        System.out.println("---------------------------------------------");
        int chu = Utilidades.pideEntero("cual es el porcentaje de chufa que tiene el producto?");

        array[producto - 1] = new Horchata(nom, pre, cal, cant, chu);
        System.out.println("****************************************************");
        System.out.println("MODIFICASTE TU PEDIDO");

    }

    public static int eligeOpcionCorrecta() {
        int opcion;
        do {
            System.out.println("1- Cambiar un producto por una horchata");
            System.out.println("2- precio total");
            System.out.println("3- salir");
            opcion = Utilidades.pideEntero("elige una opcion");

            if (opcion < 0 || opcion > 3) {
                System.out.println("*********************************************************************************");
                System.out.println(" OPCION INVALIDA! debes elegir entre alguna de las opciones que te di!");
            }
        } while (opcion < 1 && opcion > 2);

        return opcion;
    }

}
