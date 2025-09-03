package com.Vhiz.CRUD2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AlunoService {
	
	private Map<String, Aluno> alunos;
	
	public AlunoService(){
		alunos = new HashMap<>();
	}
	
	public void adicionarAluno(String matricula, Aluno aluno) {
		boolean adicionou = alunos.put(matricula ,aluno) == null;
		if(adicionou) {
			System.out.println("Novo aluno adicionado com sucesso!");
		} else {
		System.out.println("Aluno não adicionado.");
		}
	}
	
	public void listarAlunos() {
		if(alunos.isEmpty()){
			System.out.println("Não há alunos cadastrados");
		} else {
			for(Map.Entry<String, Aluno> entry : alunos.entrySet()) {
				System.out.println("Matricula:" + entry.getKey() + " Dados: " + entry.getValue());
			}
		}
	}
	
	public Optional<Aluno> buscarPorMatricula(String matricula){
		return Optional.ofNullable(alunos.get(matricula));
	}
	
	public void removerAluno(String matricula) {
		Optional<Aluno> aluno = buscarPorMatricula(matricula);
		if(aluno.isPresent()) {
			alunos.remove(matricula);
			System.out.println("O Aluno foi removido.");
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}
	    public void atualizarAluno(String matricula, String novoNome, int novaIdade, String novoCurso) {
	        Optional<Aluno> aluno = buscarPorMatricula(matricula);
	        	aluno.ifPresent (a -> {
	            a.setNome(novoNome);
	            a.setIdade(novaIdade);
	            a.setCurso(novoCurso);
	            System.out.println("Aluno atualizado com sucesso!");
	        }); 
	        	if (aluno.isEmpty())
	            System.out.println("Aluno não encontrado.");
	        }
	    }

			
			
	


