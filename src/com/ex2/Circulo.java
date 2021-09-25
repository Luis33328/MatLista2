package com.ex2;

public class Circulo {

	private float raio;
	private float pi = 3.14f;
	
	public Circulo(float raio) {
		this.raio = raio;
	}
	
	public void perimetroC() {
		System.out.println("Per�metro do c�rculo: " + (2*pi*raio));
	}
	
	public void areaC() {
		System.out.println("�rea do c�rculo: " + (pi*(raio*raio)));
	}
	
	public float getRaio() {
		return raio;
	}
	public void setRaio(float raio) {
		this.raio = raio;
	}
	public float getPi() {
		return pi;
	}
	public void setPi(float pi) {
		this.pi = pi;
	} 
	
	
	
}
