package com.app.banco;

public class Conta {

	private String agencia;
	private String numero;
	private double saldo;
	private Cliente cliente;
	
	public Conta() {};
	
	public Conta(String agencia, String numero, double saldo, Cliente cliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void sacar(double valor) {
		if (saldo >= valor) {
		this.saldo -= valor;		
		} else {
			System.out.println("Saldo Insuficiente");
		}
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Deposito Realizado com Sucesso no Valor de: " + valor);
	}
	
}
