package com.qintess.banco.modelo;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {}
	
	public ContaPoupanca(String agencia, String numero, double saldo, Cliente cliente) {
		super(agencia, numero, saldo, cliente);
	}

}