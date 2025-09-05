package com.Vhiz.CRUD2;

import java.util.Scanner;

public class Validador {
	public static int addIdadeAluno(Scanner sc) {
		int idade = 0;
		do {
			System.out.printf("Insira a idade do Aluno: \nATENÇÃO! A idade deve ser entre 18 e 100 anos!");
			try {
				idade = Integer.parseInt(sc.nextLine());
				if (idade < 18 || idade > 100) {
					throw new IdadeException("Idade não permitida! \nA idade deve estar entre 18 e 99 anos!\nO Sistema está sendo encerrado.");
					//Exception utilizada somente para fins de treino.
				}
				}
			catch (NumberFormatException e) {
				System.out.println("Opção inválida! Tente novamente.");
				idade = 0;
				}
			}
		while (idade == 0);
		System.out.println("Idade Adicionada com Sucesso!");
		return idade;
}

	//Checa um imput de string e adiciona caso passe na verificação.
	public static String CheckAndAdd(Scanner sc) {
		String nome;
		
		do {
			nome = sc.nextLine().trim();
			if (nome.isBlank() || !nome.matches("[a-zA-Z\\s]+")) {
				System.out.printf("O nome inserido é invalido! \nNão são permitidos números, caracteres especiais ou acentuações!");
			} 
			} 
		while (nome.isBlank() || !nome.matches("[a-zA-Z\\s]+"));
		return nome;
	}
	
	
	public static String checaMatricula(Scanner sc) {
		String matricula;
		
		do {
			System.out.println("Insira a matricula do aluno:");
			matricula = sc.nextLine();
			if (matricula.isBlank() || !matricula.matches("\\d+")) {
				System.out.printf("Matricula invalida! \nA Matricula deve conter apenas numeros!");
			}
		}
		while (matricula.isBlank());
		return matricula;
	}
}