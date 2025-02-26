package modelo;
import java.util.*;

import javax.swing.JOptionPane;

import persistencia.DMProduto;

/**
 * 
 */
public class Produto {
	
	private String idProduto;
    private String nome;
    private String descricao;
    private float preco;
    private DMProduto dmProduto;
    
    public Produto() {
		// TODO Auto-generated constructor stub
	}
    
    public Produto(String nome, String descricao, float preco) {
    	this.nome = nome;
    	this.descricao = descricao;
    	this.preco = preco;
    	dmProduto = new DMProduto();
    }
    
	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public float getPreco() 
	{
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
    public boolean salvar()
    {
    	if(dmProduto.salvar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

   
    public List<Produto> consultar()
    {
    	List<Produto> produtos = null;
    	produtos = dmProduto.consultar();
    	if(produtos == null)
    	{
    		JOptionPane.showMessageDialog(null, "Erro ao Consultar");
    	}
    	return produtos;
    }
    
    public List<Produto> consultar(String nome)
    {
    	List<Produto> produtos = null;
    	produtos = dmProduto.consultar(nome);
    	if(produtos == null)
    	{
    		JOptionPane.showMessageDialog(null, "Erro ao Consultar");
    	}
    	return produtos;
    }
    
    public boolean atualizar()
    {
    	if(dmProduto.atualizar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    public boolean apagar()
    {
    	if(dmProduto.apagar(this))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}