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
		System.out.println(contaCliente);
		contaCliente.sacar(300);
		System.out.println(contaCliente);
		contaCliente.depositar(3
				);
		System.out.println(contaCliente);
	}

}
