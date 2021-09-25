package com.ex2;

public class Quadrilatero {

	private float comprimento;
	private float largura;
	
	public Quadrilatero(float comprimento, float largura) {
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public Quadrilatero(float lado) {
		this.comprimento = lado;
		this.largura = lado;
	}
	
	public void perimetroQ() {
		System.out.println("Per�metro do quadril�tero: " + (comprimento + largura + comprimento + largura));
	}
	
	public void areaQ() {
		System.out.println("�rea do quadril�tero: " + (comprimento * largura));
	}
	
}
