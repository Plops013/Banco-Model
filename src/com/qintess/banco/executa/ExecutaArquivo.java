package com.qintess.banco.executa;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.qintess.banco.modelo.Cliente;
import com.qintess.banco.modelo.Conta;
import com.qintess.banco.modelo.ContaCorrente;
import com.qintess.banco.modelo.ContaPoupanca;

public class ExecutaArquivo {
	public static void main(String[] args) throws FileNotFoundException {

		Path caminho = Paths.get(System.getProperty("user.home"),
				"eclipse-workspace/contas.txt");	 

		Scanner sc = new Scanner(caminho.toFile());
		
		ArrayList<Conta> contaList = new ArrayList<>();

		while(sc.hasNextLine()) {
			String[] split = sc.nextLine().split(";");
			
			String agencia = split[0];
			String numero = split[1];
			double saldo = Double.parseDouble(split[3].replace(",","."));
			String cpf = split[5];
			String nome = split[6];
			String email = split[7];
			
			Cliente cliente= new Cliente(cpf, nome, email);
			
			if (split[8].equals("CC")) {
				Conta cc = new ContaCorrente(agencia, numero, saldo, cliente);
				contaList.add(cc);
			} else if (split[8].equals("CP")) {
				Conta cp = new ContaPoupanca(agencia, numero, saldo, cliente);	
				contaList.add(cp);
			} else {
				System.out.println("Tipo de Conta Indefinido");
			}
		}
		
		for (Conta conta : contaList) {
			System.out.println(conta);
		}
		
		sc.close();

	}
}
