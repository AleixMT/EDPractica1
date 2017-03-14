package Dades;
/**
 * Classe Node per a crear la cua dinamica. Conte el valor i la referencia al node anterior
 * @author Aleix Marine
 *
 */
public class Node {
	private int valor;
	private Node anterior;
	
	public Node(Node node, int value){
		this.valor=value;
		this.anterior=node;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Node getAnterior() {
		return anterior;
	}

	public void setAnterior(Node anterior) {
		this.anterior = anterior;
	}
	
}
	