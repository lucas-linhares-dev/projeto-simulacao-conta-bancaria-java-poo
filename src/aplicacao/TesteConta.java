package aplicacao;

import java.util.Scanner;

import entidades.ContaCorrente;
import entidades.ContaCorrenteEspecial;


public class TesteConta {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		ContaCorrente contaNormal = new ContaCorrente(1234, "Lucas Linhares", 1000);
		ContaCorrenteEspecial contaEspecial = new ContaCorrenteEspecial(12345,"Mario de souza", 1000, 500, 10); 
		
		double valor;
		
		System.out.println("Aperte duas vezes o ENTER a cada entrada de dados. Tentei corrigir esse problema mas nao consegui");
		
		while(true) {
			System.out.println();
			System.out.println("Informe a operação que deseja executar de acordo com a numereção:\n"
					+"1 - Listar contas \n"
					+"2 - Realizar deposito \n"
					+"3 - Realizar saque \n"
					+"4 - Exibir saldo \n"
					+"5 - Sair");
			
			
			int operacao = scr.nextInt();
			
			
			if(operacao == 1) {
				System.out.println(listarContas(contaNormal,contaEspecial));
			}
			
			if(operacao == 2) {
				System.out.println();
				System.out.println("Informe o valor do deposito.");
				valor = scr.nextDouble();
				realizarDeposito(selecionarConta(contaNormal,contaEspecial),valor);
			}
			if(operacao == 3) {
				System.out.println();
				System.out.println("Informe o valor do saque");
				valor = scr.nextDouble();
				realizarSaque(selecionarConta(contaNormal,contaEspecial),valor);
			}
			
			if(operacao == 4) {
				System.out.println(exibirSaldo(selecionarConta(contaNormal,contaEspecial)));
			}
			
			if(operacao == 5) {
				System.exit(0);
			}
			
				
		}
		
	}
	
	
	public static ContaCorrente selecionarConta(ContaCorrente contaNormal, ContaCorrente contaEspecial) {
		while(true) {
			System.out.println();
			System.out.println("Selecione a conta de acordo com a numeração.");
			System.out.println("1 - "+contaNormal);
			System.out.println("2 - "+contaEspecial);
			
			Scanner scr = new Scanner(System.in);
			int contaEscolhida = scr.nextInt();
			
			if(contaEscolhida == 1) {
				System.out.println("Conta "+contaNormal.getNumero()+" selecionada.");
				return contaNormal;
			}
			else if(contaEscolhida == 2) {
				System.out.println("Conta "+contaEspecial.getNumero()+" selecionada.");
				return contaEspecial;
			}
			else {
				System.out.println("Opção inválida! Tente novamente.");
			}
			
		}
		
	}
	
	public static String  listarContas(ContaCorrente contaNormal, ContaCorrente contaEspecial) {
		return "Contas: \n"+contaNormal.toString()+"\n"+contaEspecial.toString();
	}
	
	public static void realizarDeposito(ContaCorrente conta, double valor) {
		conta.depositarValor(valor);
		
		System.out.println("Deposito de $"+valor+" efetuado com sucesso!");
		System.out.println();
		System.out.println("Saldo atual da conta "+conta.getNumero()+": "+conta.exibirSaldo());
		System.out.println();
	}
	
	public static void realizarSaque(ContaCorrente conta, double valor) {
		conta.sacarValor(valor-valor);
		
		if(conta.sacarValor(valor) == true) {
			System.out.println();
			System.out.println("Saque de $"+valor+" efetuado com sucesso!");
			System.out.println();
			System.out.println("Saldo atual da conta "+conta.getNumero()+": "+conta.exibirSaldo());
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("Você não tem saldo o suficiente para sacar este valor!");
			System.out.println();
			System.out.println("Saldo atual da conta "+conta.getNumero()+": "+conta.exibirSaldo());
			System.out.println();
		}
			
	}
	
	public static double exibirSaldo(ContaCorrente conta) {
		System.out.println();
		return conta.exibirSaldo();
	}
	

}
