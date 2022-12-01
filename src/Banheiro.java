
public class Banheiro {
	public int id;
	public static int nextId = 1;
	public boolean ocupado = false;
	
	public Banheiro() {
		this.id = nextId;
		nextId++;
	}
	
	public synchronized void utilizar(Pessoa pessoa) {
		try {
			ocupado = true;
			
			System.out.println(String.format("%1$25s UTILIZANDO ", pessoa.nome).concat("<" + this.id + ">"));
			Thread.sleep(5000);
			System.out.println(String.format("%1$26s FINALIZOU ", pessoa.nome).concat("<" + this.id + ">"));
			
			ocupado = false;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
