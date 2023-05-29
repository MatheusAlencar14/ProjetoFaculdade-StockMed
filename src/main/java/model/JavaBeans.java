package model;

public class JavaBeans {
	private String idmaterial;
	private String nome;
	private String codMaterial;
	private String quantidade;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idmaterial, String nome, String codMaterial, String quantidade) {
		super();
		this.idmaterial = idmaterial;
		this.nome = nome;
		this.codMaterial = codMaterial;
		this.quantidade = quantidade;
	}

	public String getIdmaterial() {
		return idmaterial;
	}
	public void setIdmaterial(String idmaterial) {
		this.idmaterial = idmaterial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodMaterial() {
		return codMaterial;
	}
	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public String setQuantidade(String quantidade) {
		return this.quantidade = quantidade;
	}
}
