package com.qintess.banco.modelo;

public abstract class Conta {

	private String agencia;
	private String numero;
	protected double saldo;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public abstract int verificarSaldo(double valor);
	
	public abstract void transferir(Conta conta, double valor);

	public abstract void sacar(double valor);

	public abstract void depositar(double valor);
	
	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}	
}
