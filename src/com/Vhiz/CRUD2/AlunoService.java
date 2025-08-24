package com.Vhiz.CRUD2;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AlunoService {
	
	private Set<Aluno> alunos;
	
	public AlunoService(){
		alunos = new HashSet<>();
	}
	
	public void adicionarAluno(Aluno aluno) {
		boolean adicionou = alunos.add(aluno);
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
			alunos.forEach(System.out::println);
		}
	}
	
	public Optional<Aluno> buscarPorMatricula(String matricula){
		return alunos.stream()
				.filter(a -> a.getMatricula().equalsIgnoreCase(matricula))
				.findFirst();
	}
	
	public void removerAluno(String matricula) {
		Optional<Aluno> aluno = buscarPorMatricula(matricula);
		if(aluno.isPresent()) {
			alunos.remove(aluno.get());
			System.out.println("O Aluno foi removido.");
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}
	    public void atualizarAluno(String matricula, String novoNome, int novaIdade, String novoCurso) {
	        Optional<Aluno> aluno = buscarPorMatricula(matricula);
	        if (aluno.isPresent()) {
	            aluno.get().setNome(novoNome);
	            aluno.get().setIdade(novaIdade);
	            aluno.get().setCurso(novoCurso);
	            System.out.println("Aluno atualizado com sucesso!");
	        } else {
	            System.out.println("Aluno não encontrado.");
	        }
	    }
}
			
			
	


