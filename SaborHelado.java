
package actividad07.ejercicio02;

/**
 *
 * @author Candela
 */
public class SaborHelado extends Comida{
    //atributos propios de la clase
    private int grasa;
    private String edulcorante;
    
    //constructor para establecer los atributos de la clase y los heredados llamando a super
    public SaborHelado(String nombre, double precio, int kcal, int gra, String edul) {
        super(nombre, precio, kcal);
        grasa=gra;
        edulcorante= edul;
        
    }

    //getter y setter que accede a los atributos
    
    public double getPrecio(){
        return super.getPrecio();
    }
    
    public String getEdulcorante() {
        return edulcorante;
    }

    public void setEdulcorante(String edulcorante) {
        this.edulcorante = edulcorante;
    }

     public int getGrasa() {
        return grasa;
    }

    public void setGrasa(int grasa) {
        this.grasa = grasa;
    }
   
    
    //toString sobreescrito que muestra los valores de los atributos
    public String toString(){
  
    String informacion= " - "+ "El nombre del sabor es:"+super.getNombre()+" el precio del sabor es: "+ super.getPrecio()+ " las calorias que aporta son:  "+ super.getKcal()+ " tipo de edulcorante que usa: "+edulcorante+ " porcentaje de grasa: "+ grasa;
   return informacion;
    }

   
    
}
