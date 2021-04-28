package actividad07.ejercicio02;

/**
 *
 * @author Candela
 */
public class Cucurucho extends Comida {

    //atributo de clase 
    int maximoBolas;

    //Un array de SaborHelado, para almacenar los sabores del cucurucho
  SaborHelado[] misSabores;

    //Constructor que establezca el nombre, precio base , 
    //kcal y número de bolas de helado que puede tener como máximo el cucurucho. 
    public Cucurucho(String nombre, double precioBase, int kcal, int maxBo) {
        super(nombre, precioBase, kcal);
        maximoBolas = maxBo;
        misSabores= new SaborHelado[maxBo];
    }
//metodos getter y setter para acceder a los atributos propios y heredados

    public int getMaximoBolas() {
        return maximoBolas;
    }

    public void setMaximoBolas(int maximoBolas) {
        this.maximoBolas = maximoBolas;
    }

    public void getSaborHelado() {
        for (int i = 0; i < misSabores.length; i++) {
            if (misSabores[i] != null) {
                System.out.println(misSabores[i]);
            }
        }
    }

    @Override
    public String toString() {
        String informacion = super.toString();
       
        for (SaborHelado sabor : misSabores) {
            
            if (sabor != null) {
            
                informacion = informacion + "\n "+sabor.toString();
            } 
        }
        return informacion;
    }

//addBolaHelado() debe recibir por parámetro una bola de helado , 
    //en qué posición de las bolas de helado que tiene el cucurucho
    //se quiere añadir y añadirla si la posición es correcta. 
    public void addBolaHelado(int pos, SaborHelado sabor) {
        if(pos<=misSabores.length){
          
             misSabores[pos] = sabor;
        }else{
        
         System.out.println("no tienes permitido en este producto agregar tantas bolas");
        }
    }

    // calculaPrecioTotal()  retorna la suma del precio base del 
    //cucurucho más el de todas las bolas de helado que tenga.
    public  double PrecioTotal() {
        double precio = getPrecio();
        double preciob=0;
       for(int i=0;i<misSabores.length;i++){
            
            preciob=preciob+misSabores[i].getPrecio();
        }
       precio= precio + preciob;
        return precio;
    }

}
