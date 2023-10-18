package com.jsfcourse.calc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalcBB {
	private String x;
	private String y;
	private String c;
	private Double result;

	@Inject
	FacesContext ctx;
	
	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Double getResult() {
		return result;
	}

	public String calc() {
		try {
			double x = Double.parseDouble(this.x); //kwota
			double y = Double.parseDouble(this.y); //miesięczne oprocentowanie
			double c = Double.parseDouble(this.c); //lata
			
			
			result = (x+(x*(y/100))) / (c*12);
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return "showresult"; 
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return null; 
		}
				
	}
	
	

	public String info() {
		return "info"; 
	}
}
