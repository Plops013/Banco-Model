package com.app.banco;

public class Executa {

	public static void main(String[] args) {
		
		Conta contaCliente = new Conta();
		contaCliente.setAgencia("123");
		Cliente cliente = new Cliente("12312312312","Fabio Lopes");
		
		contaCliente.setCliente(cliente);
		
		System.out.println(contaCliente.getCliente().getNome());
		
		
	}
	
}
