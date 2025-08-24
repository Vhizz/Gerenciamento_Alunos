package com.Vhiz.CRUD2;

import java.util.Scanner;

public class Validador {
	public static int adicionarIdadeAluno(Scanner sc) {
		int idade = 0;
		do {
			try {
				idade = Integer.parseInt(sc.nextLine());
				if (idade < 18) {
					throw new IdadeException("Idade abaixo da idade mínima permitida!");
				}
				}
			catch (NumberFormatException e) {
				System.out.println("Opção inválida! Tente novamente.");
				idade = 0;
				}
			}
		while (idade == 0);
		return idade;
}

}