package com.ex2;

public class Main {

	public static void main(String[] args) {
		
		Circulo jorge = new Circulo(6f);
		jorge.perimetroC();
		jorge.areaC();
		
		Quadrilatero retangulo = new Quadrilatero(5f, 2f);
		retangulo.perimetroQ();
		retangulo.areaQ();
		
		Quadrilatero quadrado = new Quadrilatero(4f);
		quadrado.perimetroQ();
		quadrado.areaQ();
	}
	
}
