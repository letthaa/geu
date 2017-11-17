package br.ucsal.geu.model;

public class Bloco {
	
	private Integer id;
	private String nome;
	private String letra;
	private String latitude;
	private String longitude;	
	

	
	
	public Bloco(String nome, String letra, String latitude, String longitude) {
		super();
		this.nome = nome;
		this.letra = letra;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public Bloco() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
}


