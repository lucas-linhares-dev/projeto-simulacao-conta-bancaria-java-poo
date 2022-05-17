package entidades;
 
public class ContaCorrente {
	private int numero;
	private String nome;
	private double saldo;
	
	
	public ContaCorrente(int numero, String name, double saldo) {
		this.numero = numero;
		this.nome = name;
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	public void depositarValor(double valor) {
		saldo+=valor;
	}
	
	public boolean sacarValor(double valor) {
		
		if(saldo>=valor) {
			saldo-=valor;
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public double exibirSaldo() {
		return saldo;
	}
	
	
	public String toString() {
		return getNumero()+" - "+getNome();
	}
	
}

