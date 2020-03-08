package com.qintess.banco.modelo;

public abstract class Conta {

	private String agencia;
	private String numero;
	protected double saldo;
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

	public boolean verificarSaldo(double saldo, double valor) {
		if (saldo >= valor){
			return true;
		}
		else {
			return false;
		}
	}

	public void transferir(Conta conta, double valor){
		if(this.verificarSaldo(this.saldo, valor)) {
			this.sacar(valor);
			conta.depositar(valor);
		} else {
			System.out.println("Transferencia não realizada, Saldo insuficiente");	
		}
	}

		public void sacar(double valor) {
			if (verificarSaldo(this.saldo , valor)) {
				this.saldo -= valor;
			} else {
				System.out.println("Saldo Insuficiente");
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
