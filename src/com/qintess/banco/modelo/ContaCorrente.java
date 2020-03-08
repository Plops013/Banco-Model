package com.qintess.banco.modelo;

public class ContaCorrente extends Conta{

	double taxaTransferencia = 4;
	double taxaSaque = 0.3;
	double taxaLimite = 2;
	double chequeEspecial = 300;
	double taxaAPagar = 0;

	public ContaCorrente() {}

	public ContaCorrente(String agencia, String numero, double saldo, Cliente cliente) {
		super(agencia, numero, saldo, cliente);
	}

	public double getTaxaTransferencia() {
		return taxaTransferencia;
	}

	public void setTaxaTransferencia(double taxaTransferencia) {
		this.taxaTransferencia = taxaTransferencia;
	}

	public double getTaxaSaque() {
		return taxaSaque;
	}

	public void setTaxaSaque(double taxaSaque) {
		this.taxaSaque = taxaSaque;
	}

	public double getTaxaLimite() {
		return taxaLimite;
	}

	public void setTaxaLimite(double taxaLimite) {
		this.taxaLimite = taxaLimite;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}



	@Override
	public void transferir(Conta conta, double valor) {
		if(super.verificarSaldo(super.saldo + this.chequeEspecial , valor + taxaTransferencia)){
			System.out.println("Você pagou uma taxa de 4 reais pela transferencia");
			this.sacar(valor);
			conta.depositar(valor);
		} else if (super.verificarSaldo(super.saldo + this.chequeEspecial , valor)){
			taxaAPagar += taxaTransferencia;
			this.sacar(valor);
			conta.depositar(valor);
		} else {
			System.out.println("Transferencia não realizada, Saldo insuficiente");
		}
	}

	@Override
	public void sacar(double valor) {
		if (super.verificarSaldo(super.getSaldo(), (valor + this.taxaSaque))){
			super.saldo -= valor = taxaSaque;
			System.out.println("Retirado da sua conta : "
					+ valor);
		} else if (super.verificarSaldo((this.getSaldo() + this.chequeEspecial), (valor + this.taxaLimite))){
			super.saldo -= valor + taxaLimite;
			System.out.println("Retirado da sua conta  : "
					+ valor);
		} else if(super.verificarSaldo((this.getSaldo() + this.chequeEspecial) , valor )){
			super.saldo -= valor;
			taxaAPagar += taxaLimite;
			System.out.println("Retirado da sua conta  : "
					+ valor
					+ " Você sacou todo limite, pagará a taxa no proximo deposito no valor de: "
					+ taxaAPagar);
		} else {
			System.out.println("Saldo Insuficiente");
		}
	}

	@Override
	public void depositar(double valor) {
		if(taxaAPagar != 0 && valor >= taxaAPagar) {
			super.saldo += valor - taxaAPagar;
			System.out.println("Deposito Realizado com Sucesso no Valor de: " 
					+ valor 
					+ " Na conta de: " 
					+ this.getCliente().getNome() 
					+ " Você pagou taxa de: " 
					+ taxaAPagar
					+ " Por utilizar todo seu limite.");
			taxaAPagar = 0;
		} else if(taxaAPagar != 0) {
			taxaAPagar -= valor;
			System.out.println("Deposito Realizado com Sucesso no Valor de: " 
					+ valor 
					+ " Na conta de: " 
					+ this.getCliente().getNome() 
					+ " Você pagou taxa de: " 
					+ taxaAPagar
					+ " Por utilizar todo seu limite."
					+ " \n Voce ainda tem debito de: "
					+ taxaAPagar
					+ " em taxa a pagar");
		} else{
			super.saldo += valor;
			System.out.println("Deposito Realizado com Sucesso no Valor de: " 
					+ valor 
					+ " Na conta de: "
					+ this.getCliente().getNome());
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente [taxaAPagar=" + taxaAPagar + ", saldo=" + saldo + "]";
	}



}
