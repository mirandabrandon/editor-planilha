package com.tunts.desafio.desafiotunts.modelo;

public class Aluno {

	private String nome;
	private String matricula;
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private boolean aprovado;

	public Aluno() {
	}

	public Aluno(String nome, String matricula, double nota1, double nota2, double media, boolean aprovado) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
		this.aprovado = aprovado;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double getMedia() {
		media = (nota1 + nota2 + nota3) / 3;
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

}
