package bodeguita;

import java.util.concurrent.Semaphore;

 public class Bodega {
 	
 	private volatile double articuloUno;  
 	private volatile double articuloDos; 
 	public final static int  CAPACIDAD_MAXIMA = 200;  
 	private Semaphore cantArticuloUno;
	private Semaphore cantArticuloDos;
	private Semaphore espacioBodega;
	private Semaphore mutex;
 	
 	
 	public Bodega(double articuloUno, double articuloDos){
 		this.articuloUno = articuloUno;
 		this.articuloDos = articuloDos;
 		cantArticuloUno = new Semaphore(0);
 		cantArticuloDos = new Semaphore(0);
 		mutex = new Semaphore(1);
 		espacioBodega = new Semaphore(CAPACIDAD_MAXIMA);
 	}
 	
 	public void colocarArticulo(double articulo) throws Exception{
 		
 		System.out.println("Capacidad actual de bodega: " + (CAPACIDAD_MAXIMA - (int)darCapacidadActual()));

 		if(articulo == 1){
 			espacioBodega.acquire(10);
 			mutex.acquire();
 			articuloUno++;
 			mutex.release();

 		}
 		else if(articulo == 2){
 			

 			espacioBodega.acquire(10);
 			mutex.acquire();
 			articuloDos++;
 			mutex.release();
 			cantArticuloDos.release(1);
 		}
 		else{
 			throw new Exception("No existe un articulo de ese tipo");
 		}
 		
 		System.out.println("Capacidad actual de bodega luego de poner el siguiente paquete: " + (CAPACIDAD_MAXIMA - (int)darCapacidadActual()));
 		System.out.println("Articulos Tipo Uno: " + (int)articuloUno);
 		System.out.println("Articulos Tipo Dos: " + (int)articuloDos);
 	}
 	
 	public void armarPaquete() throws InterruptedException{
 		
		cantArticuloUno.acquire(3);
		cantArticuloDos.acquire(4);
		espacioBodega.release(90);
 		mutex.acquire();
		articuloUno -= 3;
 		articuloDos -= 4;
 		mutex.release();

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
