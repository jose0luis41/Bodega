package bodeguita;

 import java.util.Random;
 
 public class Recolector extends Thread{
 
 	private Main principal;
 	private int paquetes;
 	
 	public Recolector(Main principal){
 		this.principal = principal;
 		paquetes = 0;
 	}
 	
 	public void run() {
 		Random time = new Random();
 		while(true){
 			principal.armarPaquete();
 			paquetes++;
 			System.out.println("El recolector creo el paquete numero: " + paquetes);
 			try {
 				Thread.sleep(time.nextInt(3000));
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 		}
 	}
 
 	
 	
 	
 }
