package com.qintess.banco.executa;

import com.qintess.banco.modelo.Cliente;

import com.qintess.banco.modelo.ContaCorrente;

public class Executa {

	public static void main(String[] args) {
		
		ContaCorrente contaCliente = new ContaCorrente();
		ContaCorrente contaCliente2 = new ContaCorrente();
		
		contaCliente.setAgencia("123");
		
		Cliente cliente = new Cliente("12312312312", "Fabio Lopes", "fabio.lopes@qintess.com");
		Cliente cli = new Cliente("12312312312", "Fabio Pecora", "fabio.lopes@qintess.com");
		
		contaCliente.setCliente(cliente);
		
		contaCliente2.setCliente(cli);
		contaCliente.depositar(1000);
		
		System.out.println(contaCliente);
		
		contaCliente.transferir(contaCliente2, 500);
		System.out.println(contaCliente);

		System.out.println(contaCliente);
		
		contaCliente.transferir(contaCliente2, 796);
		System.out.println(contaCliente);
	
		contaCliente.depositar(10);
		System.out.println(contaCliente);
	}

}
