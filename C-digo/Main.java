package bodeguita;



public class Main {

	private Bodega bodega;
	private Recolector recolector;
	private Deposito depositador;
	
	public Main(){
		bodega = new Bodega(0, 0);
		recolector = new Recolector(this);
		depositador = new Deposito(this);
	}
	
	
	
	public void proceso(){
		recolector.start();
		depositador.start();
	}
	
	
	public void depositarArticulo(double articulo){
		try {
			bodega.colocarArticulo(articulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void armarPaquete(){
		bodega.armarPaquete();
	}
	
	public static void main(String[] args){
		new Main().proceso();
	}
	
}
