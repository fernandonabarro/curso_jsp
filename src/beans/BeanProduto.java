package beans;

public class BeanProduto {

	private Long id;
	private String nome;
	private Integer quantidade;
	private Double valor;
	private Long categoria_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getValorEmTexto(){
		return Double.toString(valor).replace('.', ',');
	}
	public Long getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}
}
