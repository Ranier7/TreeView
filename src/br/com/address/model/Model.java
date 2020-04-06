package br.com.address.model;

public class Model {
	
	private String linha;
	private String modelo;
	
	public Model(String linha, String modelo) {
		super();
		this.linha = linha;
		this.modelo = modelo;
	}
	
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
