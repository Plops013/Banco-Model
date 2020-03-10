package com.qintess.banco.modelo;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {}

	public ContaPoupanca(String agencia, String numero, double saldo, Cliente cliente) {
		super(agencia, numero, saldo, cliente);
	}

	@Override
	public void transferir(Conta conta, double valor) {
		switch(verificarSaldo(valor)) {
		case 1:{
			this.sacar(valor);
			conta.depositar(valor);
			break;
		}
		case 2:
			System.out.println("Deposito não realizado");
			break;
		}
	}

	@Override
	public void sacar(double valor) {
		switch(verificarSaldo(valor)) {
		case 1:{
			saldo -= valor;
			break;
		}
		case 2:{
			System.out.println("Saldo insuficiente");
			break;
		}
		}
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public int verificarSaldo(double valor) {
		//1 Verifica se Saldo é maior que Valor
		if (super.saldo >= (valor)){
			return 1;
		//2 Saldo menor que valor, impossivel realizar operação
		} else {
			return 2;
		}
	}

}
