package com.ex1;

public class ContaCorrente {

	private float saldo = 0f;
	private boolean saque = false;
	private boolean deposito = false;
	
	
	public ContaCorrente(float saldo) {
		this.saldo = saldo;
	}
	
	public ContaCorrente() {
		
	}
	
	public void sacar(float quantia) {
		saque = true;
		if(quantia > saldo) {
			System.out.println("Saldo insuficiente.");
		}
		else if(quantia == 0) {
			System.out.println("Quantia inválida.");
		}
		else {
			imprimirOperacao(saldo,quantia);
			saldo -= quantia;
			saque = false;
		}
	}
	
	public void depositar(float quantia) {
		deposito = true;
		if(quantia == 0) {
			System.out.println("Quantia inválida.");
		}
		else {
			imprimirOperacao(saldo,quantia);
			saldo += quantia;
			deposito = false;
		}
	}
	
	public void imprimirOperacao(float saldo, float quantia) {
		if(saque) {
			System.out.println("Movimentação da conta:");
			System.out.println(saldo + " - " + quantia + " = " + (saldo - quantia));
		}
		else if(deposito) {
			System.out.println("Movimentação da conta:");
			System.out.println(saldo + " + " + quantia + " = " + (saldo + quantia));
		}
	}
	

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
