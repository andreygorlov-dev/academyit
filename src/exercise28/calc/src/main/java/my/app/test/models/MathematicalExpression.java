package my.app.test.models;

import java.io.Serializable;

public class MathematicalExpression implements Serializable  {
	
	private Double value1;
	private Double value2;
	private String action;
	private Double result;
	
	MathematicalExpression(Double value1, Double value2, String action) {
		this.value1 = value1;
		this.value2 = value2;
		this.action = action;
	}
	
	MathematicalExpression() {
	}
	
	public Double getValue1() {
		return value1;
	}
	
	public Double getValue2() {
		return value2;
	}
	
	public String getAction() {
		return action;
	}
	

	public Double getResult() {
		return result;
	}
	
	public void setValue1(Double value1) {
		this.value1 = value1;
	}
	
	public void setValue2(Double value2) {
		this.value2 = value2;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	
	public void setResult() {
		switch (action) {
			case "+":
				result = value1 + value2;
				break;
			case "-":
				result = value1 - value2;
				break;
			case "/":
				result = value1 / value2;
				break;
			case "*":
				result = value1 * value2;
				break;
			default:
				result = 0d;
				break;
		}
	}

}
