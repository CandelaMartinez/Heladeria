
package actividad07.ejercicio02;

/**
 *
 * @author Candela
 */
public class Comida {
    //atributos de la clase
    private String nombre;
    private double precio;
    private int kcal;
//constructor
    public Comida(String nombre, double precio, int cal) {
        this.nombre = nombre;
        this.precio = precio;
        kcal = cal;
    }
    
    public Comida(String nombre, int kcal){
        this.nombre=nombre;
        this.precio=precio;
    }
//getter y setter de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
    //metodo sobreescrito toString que me devuelve los atributos de la clase
    @Override
    public String toString(){
    String  informacion="El nombre es: "+nombre+", el precio es: "+ precio+" euros, las calorias son: "+kcal+"calorias";
    return informacion;
    
    }
}
