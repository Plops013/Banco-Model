package com.qintess.banco.executa;

import com.qintess.banco.modelo.Cliente;
import com.qintess.banco.modelo.Conta;
import com.qintess.banco.modelo.ContaCorrente;

public class Executa {

	public static void main(String[] args) {
		
		Conta contaCliente = new ContaCorrente();
		Conta contaCliente2 = new ContaCorrente();

		contaCliente.setAgencia("123");
		
		Cliente cliente = new Cliente("12312312312", "Fabio Lopes", "fabio.lopes@qintess.com");
		Cliente cli = new Cliente("12312312312", "Fabio Pecora", "fabio.lopes@qintess.com");
		
		contaCliente.setCliente(cliente);
		
		contaCliente2.setCliente(cli);
		contaCliente.depositar(100);
		
		System.out.println(contaCliente);
		
		contaCliente.sacar(150);
		System.out.println(contaCliente);
		
	}

}
