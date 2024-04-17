package estoque.adega.model;

public class Item {

	private Integer id;
	private String nome;
	private float preco;
	private int quantidade;
	private int id_categoria;
//	private Categoria categoria;
	
	
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
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public void addQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void removeQuantidade(int quantidade) {
		this.quantidade -= quantidade;
	}
//	public Categoria getCategoria() {
//		return categoria;
//	}
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
	
	
}
