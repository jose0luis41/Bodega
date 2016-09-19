package bodeguita;

 public class Bodega {
 	
 	private volatile double articuloUno; 
 	private volatile double articuloDos; 
 	public final static int  CAPACIDAD_MAXIMA = 200; 
 	
 	public Bodega(double articuloUno, double articuloDos){
 		this.articuloUno = articuloUno;
 		this.articuloDos = articuloDos;
 	}
 	
 	public void colocarArticulo(double articulo) throws Exception{
 		
 		System.out.println("Capacidad actual de bodega: " + (CAPACIDAD_MAXIMA - (int)darCapacidadActual()));

 		if(articulo == 1){
 			while(darCapacidadArticuloUno() + darCapacidadArticuloDos() > 190){
 				
 			}
 			articuloUno++;
 		}
 		else if(articulo == 2){
 			while(darCapacidadArticuloUno() + darCapacidadArticuloDos() > 185){
 				
 			}
 			articuloDos++;
 		}
 		else{
 			throw new Exception("No existe un articulo de ese tipo");
 		}
 		
 		System.out.println("Capacidad actual de bodega luego de poner el siguiente paquete: " + (CAPACIDAD_MAXIMA - (int)darCapacidadActual()));
 		System.out.println("Articulos Tipo Uno: " + (int)articuloUno);
 		System.out.println("Articulos Tipo Dos: " + (int)articuloDos);
 	}
 	
 	public void armarPaquete(){
 		while(articuloUno < 3 || articuloDos < 4){
 			
 		}
		articuloUno -= 3;
 		articuloDos -= 4;
 	}
 	
 	public double darCapacidadArticuloUno(){
 		return  (articuloUno*10);
 	}
 	
 	
	public double darCapacidadArticuloDos(){
 		return  (articuloDos*10);
 	}
 	
	
	
 	public double darCapacidadActual(){
 		return (articuloUno*10) + (articuloDos*15);
 	}
 }
