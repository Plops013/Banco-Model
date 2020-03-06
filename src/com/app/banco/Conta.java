package com.app.banco;

public abstract class Conta {

	private String agencia;
	private String numero;
	private double saldo;
	private Cliente cliente;
	double taxaTransferencia = 4;
	double taxaSaque = 0.3;
	double taxaLimite = 2;
	double chequeEspecial = 300;

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
	
	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public void retirarDinheiro(double valor) {
		saldo -= valor;
	}
	
	public void transferir(Conta conta, double valor){
		if(this.sacar(valor + taxaTransferencia)) {
			conta.depositar(valor);
		} else {
			System.out.println("Transferencia não realizada, Saldo insuficiente");
		}
	}

	public  boolean sacar(double valor) {
		if (this.saldo >= valor + this.taxaSaque) {
			this.saldo -= valor + this.taxaSaque;
			return true;
		} else if ( (this.saldo + this.chequeEspecial) >= valor + this.taxaLimite) {
			this.saldo -= valor + this.taxaLimite;
			return true;	
		} else {
			System.out.println("Saldo Insuficiente");
			return false;
		}
	}

	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Deposito Realizado com Sucesso no Valor de: " + valor + " Na conta de: " + this.getCliente().getNome());
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}

}
