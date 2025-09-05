package com.Vhiz.CRUD2;

import java.util.Scanner;

public class MainAPP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlunoService alunoService = new AlunoService();
		int opcao = -1, idade = 0;
		String matBusca, curso, matricula, nome;
		
		
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

            	//Adiciona o nome ao Aluno.
            	System.out.println("Insira o nome do Aluno: ");
            	nome = Validador.CheckAndAdd(sc);
            	System.out.println("Nome adicionado com sucesso!");
            	System.out.println("----------------------------");
            	
            	
            	//Adiciona a idade ao Aluno.
            	try {
            	idade = Validador.addIdadeAluno(sc);
            	} catch (IdadeException e) {
            		System.out.println(e.getMessage());
            		break;
            	}
            	System.out.println("----------------------------");
            	
            	
            	//Adiciona o curso ao Aluno.
            	System.out.println("Insira o nome do Curso:");
            	curso = Validador.CheckAndAdd(sc);
            	System.out.println("Curso adicionado com sucesso!");
            	System.out.println("-----------------------------");
            	
            	//Cadastra a matricula ao aluno.
            	matricula = Validador.checaMatricula(sc);
            	System.out.println("Matricula cadastrada com sucesso!");
            	System.out.println("---------------------------------");
            	
            	
            	//Adiciona os dados passados ao usuário e cria o objeto aluno.
            	Aluno novoAluno = new Aluno(nome, idade, curso, matricula);
            	alunoService.adicionarAluno(matricula, novoAluno);
            	
            	break;
            
            //Lista todos os alunos
            case 2:
            	alunoService.listarAlunos();
            	break;
            	
            //Busca aluno por matrícula e exibe o resultado.
            case 3:
            	System.out.println("Digite o número de matricula: ");
            	matBusca = Validador.checaMatricula(sc);
            	alunoService.buscarPorMatricula(matBusca)
            		.ifPresentOrElse(
            				System.out::println,
            				() -> System.out.println("Aluno não encontrado!")
            				);
            	break;
            
            //Atualiza o aluno da matricula escolhida.
            case 4:
            	System.out.println("Digite a Matricula do aluno a atualizar: ");
            	matBusca = Validador.checaMatricula(sc);
            	
            	
            	System.out.println("ATENÇÃO: Em caso de não alteração, preencha com os mesmos dados de anteriormente...");
            	System.out.println("Digite o novo nome do aluno: ");
            	nome = Validador.CheckAndAdd(sc);
            	
            	
            	System.out.println("Digite a nova idade do aluno: ");
            	try {
                	idade = Validador.addIdadeAluno(sc);
                	} catch (IdadeException e) {
                		System.out.println(e.getMessage());
                		break;
                	}
            	
            	
            	System.out.println("Digite o novo curso do aluno: ");
            	curso = Validador.CheckAndAdd(sc);
            	
            	alunoService.atualizarAluno(matBusca, nome, idade, curso);
            	System.out.println(alunoService.buscarPorMatricula(matBusca));
            	break;
            	
            //Exclui o aluno através do numero de matricula passado.
            case 5:
            	System.out.println("Digite a Matricula do aluno a ser deletado:");
            	matBusca = Validador.checaMatricula(sc);
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
	