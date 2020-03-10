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

	public int verificarSaldo(double valor) {
		//1 Verifica se Saldo é maior que Valor + a taxa de Saque
		if (this.saldo >= (valor + this.taxaSaque)){
			return 1;
		//2 Verifica se saldo + cheque especial é maior que o valor + a taxa de limite
		} else if ((this.saldo + this.chequeEspecial) >= (valor + this.taxaLimite)){
			return 2;
		//3 Verifica se o saldo + limite é igual o valor, nesse caso ele guarda as taxas para depois
		} else if ((this.saldo + this.chequeEspecial) == valor){
			return 3;
		//4 Saldo insuficiente
		} else {
			return 4;
		}
	}

	@Override
	public void transferir(Conta conta, double valor) {
		switch(verificarSaldo(valor)) {
		case 1: {
			this.sacar(valor + taxaTransferencia - taxaSaque);
			conta.depositar(valor);
			break;
		}
		case 2: {
			this.sacar(valor + taxaTransferencia - taxaLimite);
			conta.depositar(valor);
			break;
		}
		case 3: {
			taxaAPagar += taxaTransferencia;
			this.sacar(valor - taxaLimite);
			conta.depositar(valor);
			break;
		}
		case 4: {
			System.out.println("Transferencia não realizada, Saldo insuficiente");
			break;
		}
		}
	}

	@Override
	public void sacar(double valor) {
		switch(verificarSaldo(valor)) {
		case 1: {
			super.saldo -= valor + taxaSaque;
			break;
		}
		case 2: {
			super.saldo -= valor + taxaLimite;
			break;
		}
		case 3: {
			super.saldo -= valor;
			taxaAPagar += taxaLimite;
			break;
		}
		case 4: {
			System.out.println("Saldo Insuficiente");
			break;
		}
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

	public double getLimite() {
		if (super.saldo > 0) {
			return chequeEspecial;
		} else {
			return this.chequeEspecial + super.saldo;
		}
	}
	
//	@Override
//	public String toString() {
//		return "ContaCorrente [taxaAPagar=" + taxaAPagar + ", saldo=" + saldo + ", limite="+ this.getLimite() + "]";
//	}



}
