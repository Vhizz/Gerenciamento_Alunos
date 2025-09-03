package com.Vhiz.CRUD2;

import java.util.Objects;

public class Aluno {
	private String nome, curso, matricula;
	private int idade;
	
	
	public Aluno(String nome, int idade, String curso) {
		this.nome = nome;
		this.idade = idade;
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Aluno{" +
				"nome='" + nome + '\'' +
				", idade=" + idade + 
				", curso='" + curso + '\'' +
				'}';
	}
	

	
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
