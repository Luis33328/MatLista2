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
		System.out.println("Perímetro do quadrilátero: " + (comprimento + largura + comprimento + largura));
	}
	
	public void areaQ() {
		System.out.println("Área do quadrilátero: " + (comprimento * largura));
	}
	
}
