import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Demonstração de concorrência entre threads\n");
		System.out.println("Cinco pessoas estão tentando acessar dois banheiros públicos."
				+ "\nUtilizarei de semáforo para permitir que apenas uma pessoa por vez acesse um banheiro e que a ordem seja preservada.");
		
		Semaphore semaforo = new Semaphore(2, true); // 2 permissões e o segundo argumento indica para preservar a ordem das threads.
		Banheiro[] banheiro = {new Banheiro(), new Banheiro()};
		Pessoa[] pessoa = {
				new Pessoa(semaforo, "Volothamp Geddarm", banheiro),
				new Pessoa(semaforo, "Elminster Aumar", banheiro),
				new Pessoa(semaforo, "Drizzt Do'Urden", banheiro),
				new Pessoa(semaforo, "Mordenkainen", banheiro),
				new Pessoa(semaforo, "Xanathar", banheiro)
		};
		
		Arrays.stream(pessoa).forEach(p -> p.start()); // Iniciando as threads.
		
	}

}
