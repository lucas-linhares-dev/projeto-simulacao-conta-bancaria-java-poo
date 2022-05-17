package entidades;

public class ContaCorrenteEspecial extends ContaCorrente {
	
	private double limite;
	private double juros;
	
	public ContaCorrenteEspecial(int numero, String nome, double saldo, double limite, double juros) {
		super(numero, nome, saldo);
		
		this.limite = limite;
		this.juros = juros;
	}
	

	public double getLimite() {
		return limite;
	}


	public double getJuros() {
		return juros;
	}
	
	
	public void depositarValor(double valor) {
		if(getSaldo()<0 && valor>=Math.abs(getSaldo())*(juros/100)) {
			valor-=(Math.abs(getSaldo())*(juros/100));
			super.depositarValor(valor);
			juros = 0;
			System.out.println("Juros do credito pago!");
			
		}
		else if(getSaldo()<0 && valor<=Math.abs(getSaldo())*(juros/100)) {
			System.out.println();
			System.out.println("Deposite no minimo um valor que pague o juros de: "+Math.abs(getSaldo())*(juros/100));
			System.out.println("Seu deposito de $"+valor+" foi cancelado! Desconsidere a mensagem a seguir.");
			
		}
		else {
			super.depositarValor(valor);
			
		}
	}
	
	public boolean sacarValor(double valor) {
		double diferenca;
		
		if(getSaldo()>=valor) {
			diferenca = getSaldo()-valor;
			setSaldo(diferenca);
			return true;
			
		}else if(getSaldo()<valor && getSaldo()+limite>=valor && getSaldo()>0) {
			diferenca = getSaldo()-valor;
			setSaldo(diferenca);
			limite-=Math.abs(diferenca);
			System.out.println();
			System.out.println("ATENCAO : Voce utilizou "+Math.abs(diferenca)+"$ do limite disponivel");
			return true;
		} 
		else if(getSaldo()<=0 && limite>=valor) {
			setSaldo(getSaldo()-valor);
			limite-=valor;
			System.out.println("ATENCAO : Voce utilizou "+valor+"$ do limite disponivel");
			return true;
		}
		else {
			return false;
		}
	
		
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}


	public double exibirSaldo() {
		if(getSaldo()<0 && limite>0) {
			System.out.println("ATENCAO : Voce esta com divida do cartao de credito! Os depositos seguintes serao usados para paga-la.");
			System.out.println();
			System.out.println("O saldo apresentado a seguir é de seu limite.");
			return limite;
		}

		return super.exibirSaldo()+limite;
	}
	
	
	public String toString() {
		return getNumero()+" - "+getNome();
	}

	
	
}
