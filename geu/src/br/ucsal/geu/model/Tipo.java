package br.ucsal.geu.model;

public class Tipo {

	private Integer idTipo;
	private String nome;
	private String descricao;

	public Tipo(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Tipo() {
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}