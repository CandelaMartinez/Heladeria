package actividad07.ejercicio02;

/**
 *
 * @author Candela
 */
public class Horchata extends Comida {

    //atributos de la clase
    private int cantidad;
    private int chufa;

    //constructor que llama dentro al constructor de la clase madre
    //y agrega los atributos propios de la clase
    public Horchata(String nombre, double precio, int kcal, int cant, int chufa) {
        super(nombre, precio, kcal);
        cantidad = cant;
        this.chufa = chufa;
        
    }

    //getter y setter de los atributos propios de la clase y de los heredados
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getChufa() {
        return chufa;
    }

    public void setChufa(int chufa) {
        this.chufa = chufa;
    }

    //sobreescribo el metodo toString 
    public String toString() {
        String informacion= super.toString();
        informacion= informacion + " cantidad de horchata "+ cantidad+"porcentaje de chufa "+ chufa;
        return informacion;
    }

}
