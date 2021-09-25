package com.ex1;

public class Main {

	public static void main(String[] args) {
		
		ContaCorrente minhaConta = new ContaCorrente(20f);
		
		minhaConta.depositar(50f);
		minhaConta.sacar(20f);
		minhaConta.sacar(60f);
	}
	
}
