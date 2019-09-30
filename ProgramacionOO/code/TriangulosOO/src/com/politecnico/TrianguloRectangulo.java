package com.politecnico;

public class TrianguloRectangulo {
	private double cateto1, cateto2, hipotenusa;

	public TrianguloRectangulo(){

	}

	public void setCateto1(double cateto1) {
		this.cateto1 = cateto1;
	}

	public void setCateto2(double cateto2) {
		this.cateto2 = cateto2;
	}

	public void setHipotenusa(double hipotenusa) {
		this.hipotenusa = hipotenusa;
	}

	public double getCateto1() {
		return cateto1;
	}

	public double getCateto2() {
		return cateto2;
	}

	public double getHipotenusa(){
		return hipotenusa;
	}

	public double area(){
		return cateto1 * cateto2;
	}

	public double perimetro(){
		return cateto1 + cateto2 + hipotenusa;
	}

	public double hipotenusaPorCatetos(){
		if ((cateto1 > 0) && (cateto2 > 0))
			hipotenusa = Math.sqrt(Math.pow(cateto1,2) + Math.pow(cateto2,2));
		else
			hipotenusa = 0;
		return hipotenusa;
	}

	public double cateto2PorHipotenusaYCateto1(){
		if ((cateto1 > 0) && (hipotenusa > 0))
			cateto2 = Math.sqrt(Math.pow(hipotenusa,2) - Math.pow(cateto1,2));
		else
			cateto2 = 0;
		return cateto2;
	}

	public void inicializarLados(){
		cateto1 = cateto2 = hipotenusa = 0;
	}
}
