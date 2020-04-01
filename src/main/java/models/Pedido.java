package models;

public class Pedido {

	// Atributos relativos ao produto e ao frete
	
	private double valorTotal;
	private double valorProduto;
	private double valorFrete;
	
	// Atributos relativos a informacoes de usuario
	
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String telefone;
	
	// Atributos relativos a informacoes do endereco
	private String rua;
	private String cidade;
	private String cep;
	private String estado;
	private String aliasEndereco;
	
	// Construtores
	
	public Pedido() {
		
	}
	
	public Pedido(double valorProduto, double valorFrete, String email) {
		super();
		this.valorProduto = valorProduto;
		this.valorFrete = valorFrete;
		this.email = email;
	}
	
	public Pedido(double valorProduto, double valorFrete, String nome, String sobrenome, String email, String senha,
			String telefone, String rua, String cidade, String cep, String estado, String aliasEndereco) {
		super();
		this.valorProduto = valorProduto;
		this.valorFrete = valorFrete;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.aliasEndereco = aliasEndereco;
	}
	
	// Getters e Setters
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAliasEndereco() {
		return aliasEndereco;
	}
	public void setAliasEndereco(String aliasEndereco) {
		this.aliasEndereco = aliasEndereco;
	}
	
	
	
}
