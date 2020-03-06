package com.app.banco;

public class ContaCorrente extends Conta{

	private double valorTaxa;
	
	public ContaCorrente() {}
	
	public ContaCorrente(String agencia, String numero, double saldo, Cliente cliente, double valorTaxa) {
		super(agencia, numero, saldo, cliente);
		this.valorTaxa = valorTaxa;
	}

	public double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}
	
}
