import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Pessoa extends Thread{

	public Semaphore semaforo;
	public String nome;
	public Banheiro[] banheiro;

	public Pessoa(Semaphore semaforo, String nome, Banheiro[] banheiro) {
		super(nome);
		this.semaforo = semaforo;
		this.nome = nome;
		this.banheiro = banheiro;
	}

	@Override
	public void run() {

		try {
			System.out.println("<" + this.nome + "> entrou na fila do banheiro.");

			semaforo.acquire();
			
			Banheiro banheiro;
			synchronized (this.banheiro) {
				banheiro = Arrays.stream(this.banheiro)
						.filter(b -> !b.ocupado)
						.findAny()
						.orElse(null);

			}

			banheiro.utilizar(this); // Utiliza o primeiro banheiro que estiver desocupado.

			semaforo.release();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
