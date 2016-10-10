package bodeguita;
 
 import java.util.Random;
 
 public class Deposito extends Thread{
 
 	private Main principal;
 	
 	public Deposito(Main principal){
 		this.principal = principal;
 	}
 	
 	
 	public void run() {
 		
 		Random time = new Random();
 		Random tipoPaquete = new Random();
 		while(true){
 			int tipo = tipoPaquete.nextInt(2)+1;
 			principal.depositarArticulo(tipo);
 			System.out.println("El depositador colocó un paquete tipo: " + tipo);
 			try {
 				
 				Thread.sleep(time.nextInt(3000));
 				
 			} catch (InterruptedException e) {
 				
 				e.printStackTrace();
 			}
 		}
 	}
 
 	
 	
 	
 	
 	
 }
