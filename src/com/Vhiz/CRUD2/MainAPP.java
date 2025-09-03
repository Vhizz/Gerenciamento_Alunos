package com.Vhiz.CRUD2;

import java.util.Scanner;

public class MainAPP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlunoService alunoService = new AlunoService();
		int opcao = -1, idade = 0;
		String matBusca, curso = null, matricula = null, nome;
		
		
		do {
            System.out.println("\n=== Sistema de Gerenciamento de Alunos ===");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Listar alunos");
            System.out.println("3. Buscar aluno por matrícula");
            System.out.println("4. Atualizar aluno");
            System.out.println("5. Remover aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            
            
            try {
            opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            	System.out.println("Opção inválida! Tente novamente.");
            }
            switch (opcao) {
            
            //Adiciona alunos à lista
            case 1:
            	do {
            	System.out.println("Nome: ");
            	nome = sc.nextLine();
            	nome = nome.replaceAll("\\s", "");
            	if (nome.isEmpty())
            		System.out.println("O nome está vazio! Insira um nome válido!");
            	} while (nome.isEmpty());
            	
            	
            	System.out.println("Idade: ");
            	System.out.println("ATENÇÃO: Idade mínima para prestação de nossos cursos de 18 Anos!");
            	
            	try {
            	idade = Validador.adicionarIdadeAluno(sc);
            	} catch (IdadeException e) {
            		System.out.println(e.getMessage());
            		break;
            	}
            	
            	
            	do {
            	System.out.println("Curso: ");
            	curso = sc.nextLine();
            	curso = curso.replaceAll("\\s", "");
            	if (curso.isEmpty())
            		System.out.println("O curso está vazio! Insira um curso válido!");
            	} while (curso.isEmpty());
            	
            	
            	do {
            	System.out.println("Matricula: ");
            	matricula = sc.nextLine();
            	matricula = matricula.replaceAll("\\s", "");
            	if (matricula.isEmpty())
            		System.out.println("A matricula está vazia! Insira uma matricula válida!");
            	} while (matricula.isEmpty());
            	
            	Aluno novoAluno = new Aluno(nome, idade, curso, matricula);
            	alunoService.adicionarAluno(matricula, novoAluno);
            	
            	break;
            
            //Lista todos os alunos
            case 2:
            	alunoService.listarAlunos();
            	break;
            	
            //Busca aluno por matrícula e exibe o resultado.
            case 3:
            	System.out.println("Digite a matricula: ");
            	matBusca = sc.nextLine();
            	alunoService.buscarPorMatricula(matBusca)
            		.ifPresentOrElse(
            				System.out::println,
            				() -> System.out.println("Aluno não encontrado")
            				);
            	break;
            
            //Atualiza o aluno da matricula escolhida.
            case 4:
            	System.out.println("Digite a Matricula do aluno a atualizar: ");
            	matBusca = sc.nextLine();
            	
            	System.out.println("ATENÇÃO: Em caso de não alteração, preencha com os mesmos dados de anteriormente...");
            	System.out.println();
            	System.out.println("Digite o novo nome do aluno: ");
            	nome = sc.nextLine();
            	
            	System.out.println("Digite a nova idade do aluno: ");
            	try {
                	idade = Validador.adicionarIdadeAluno(sc);
                	} catch (IdadeException e) {
                		System.out.println(e.getMessage());
                		break;
                	}
            	
            	System.out.println("Digite o novo curso do aluno: ");
            	curso = sc.nextLine();
            	
            	alunoService.atualizarAluno(matBusca, nome, idade, curso);
            	System.out.println(alunoService.buscarPorMatricula(matBusca));
            	break;
            	
            //Exclui o aluno através do numero de matricula passado.
            case 5:
            	System.out.println("Digite a Matricula do aluno a ser deletado:");
            	matBusca = sc.nextLine();
            	alunoService.removerAluno(matBusca);
            	break;
            	
            //Finaliza o sistema.
            case 0:
            	System.out.println("O Sistema está fechando agora!");
            	break;
            
            default:
            	System.out.println("Opção inválida! Tente novamente.");
            	
		}       
	}	while(opcao != 0);
		sc.close();
		
	}
	}
	