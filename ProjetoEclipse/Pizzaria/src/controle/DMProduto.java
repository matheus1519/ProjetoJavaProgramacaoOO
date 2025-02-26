package controle;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.Produto;
import java.util.*;

public class DMProduto {
	private Connection conexao = null;
	private String sql;
	
	public DMProduto() {
		conexao = DM.conectar();
	}
	
	public boolean salvar(Produto p)
	{
		
		PreparedStatement stm = null;
		sql = "INSERT INTO produto(nome, descricacao, preco) VALUES (?,?,?)";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, p.getNome());
			stm.setString(2, p.getDescricao());
			stm.setFloat(3, p.getPreco());
			stm.executeUpdate();
			return true;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Erro - Salvar");
			System.out.println(e);
			return false;
		}
		finally
		{
			DM.fecharConexao(conexao, stm);
		}
	}

	public List<Produto> consultar(String nome)
	{
		sql = "SELECT * FROM produto WHERE nome LIKE ?;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			stm = conexao.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			rs = stm.executeQuery();
			if(rs.next())
			{
				do
				{
					Produto prod = new Produto(rs.getString("nome"),rs.getString("descricacao"),rs.getFloat("preco"));
					prod.setIdProduto(rs.getString("id_produto"));
					produtos.add(prod);
				} while((rs.next()));				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}
		return produtos;
		
	}
	
	public List<Produto> consultar()
	{
		sql = "SELECT * FROM produto;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			stm = conexao.prepareStatement(sql);
			rs = stm.executeQuery();
			rs.next();
			
			do
			{
				Produto prod = new Produto(rs.getString("nome"),rs.getString("descricacao"),rs.getFloat("preco"));
				prod.setIdProduto(rs.getString("id_produto"));
				produtos.add(prod);
			} while((rs.next()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}
		return produtos;
		
	}

	public boolean atualizar(Produto p)
	{
		
		PreparedStatement stm = null;
		String campo = "";
		Produto prodComp = null;
		
		sql = "UPDATE produto SET nome = ?, descricacao = ?, preco = ? WHERE id_produto = '"+ p.getIdProduto() +"';";
		
		try 
		{
			
			stm = conexao.prepareStatement(sql);
			stm.setString(1, p.getNome());
			stm.setString(2, p.getDescricao());
			stm.setFloat(3, p.getPreco());
			stm.executeUpdate();
			
			return true;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Erro - Salvar");
			System.out.println(e);
			return false;
		}
		finally
		{
			DM.fecharConexao(conexao, stm);
		}
	}
	
	public boolean apagar(Produto prod)
	{
		
		PreparedStatement stm = null;
		sql = "delete from produto where id_produto = ?;";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, prod.getIdProduto());
			stm.execute();
			return true;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Erro - Deletar");
			System.out.println(e);
			return false;
		}
		finally
		{
			DM.fecharConexao(conexao, stm);
		}
	}

}
