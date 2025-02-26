package persistencia;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import modelo.Funcionario;
import modelo.Produto;
import java.util.*;

public class DMFuncionario {
	private Connection conexao = null;
	private String sql;
	
	public DMFuncionario() {
		conexao = DM.conectar();
	}
	
	public boolean salvar(Funcionario fun)
	{
		
		PreparedStatement stm = null;
		sql = "INSERT INTO funcionario(nome, cpf, data_nascimento, salario,funcao) VALUES (?,?,?,?,?)";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, fun.getNome());
			stm.setString(2, fun.getCpf());
			stm.setString(3, fun.getDataNascimento());
			stm.setFloat(4, fun.getSalario());
			stm.setString(5, fun.getFuncao());
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

	public List<Funcionario> consultar(String nome)
	{
		sql = "SELECT * FROM funcionario WHERE nome LIKE ?;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			stm = conexao.prepareStatement(sql);
			stm.setString(1, "%"+nome+"%");
			rs = stm.executeQuery();
			if(rs.next())
			{
				do
				{
					Funcionario cli = new Funcionario(rs.getString("id_funcionario"),rs.getString("nome"),rs.getString("cpf"),rs.getString("data_nascimento"), rs.getFloat("salario"),rs.getString("funcao"));
					funcionarios.add(cli);
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
		return funcionarios;
		
	}
	
	public Funcionario consultarUm(int id)
	{
		sql = "SELECT * FROM funcionario where id_funcionario = ?;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		Funcionario fun = null;
		
		try {
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			if(rs.next())
			{			
				fun = new Funcionario(rs.getString("id_funcionario"),rs.getString("nome"),rs.getString("cpf"),rs.getString("data_nascimento"), rs.getFloat("salario"),rs.getString("funcao"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}

		return fun;
		
	}
	
	public Funcionario consultarUm(String nome)
	{
		sql = "SELECT * FROM funcionario WHERE nome = ?;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		Funcionario fun = null;
		
		try {
			stm = conexao.prepareStatement(sql);
			stm.setString(1, nome);
			rs = stm.executeQuery();
			
			if(rs.next())
			{			
				fun = new Funcionario(rs.getString("id_funcionario"),rs.getString("nome"),rs.getString("cpf"),rs.getString("data_nascimento"), rs.getFloat("salario"),rs.getString("funcao"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}

		return fun;
		
	}
	
	public List<Funcionario> consultar()
	{
		sql = "SELECT * FROM funcionario;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			stm = conexao.prepareStatement(sql);
			rs = stm.executeQuery();
			
			if(rs.next())
			{			
				do
				{
					Funcionario fun = new Funcionario(rs.getString("id_funcionario"),rs.getString("nome"),rs.getString("cpf"),rs.getString("data_nascimento"), rs.getFloat("salario"),rs.getString("funcao"));
					funcionarios.add(fun);
				} while((rs.next()));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}
		return funcionarios;
		
	}
	
	public List<String> consultarNomes()
	{
		sql = "SELECT * FROM funcionario;";
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		List<String> listaNomeFuncionarios = new ArrayList<String>();
		listaNomeFuncionarios.add("Selecione um Funcionário");
		
		try {
			stm = conexao.prepareStatement(sql);
			rs = stm.executeQuery();
			
			if(rs.next())
			{			
				do
				{
					listaNomeFuncionarios.add(rs.getString("nome"));
				} while((rs.next()));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally
		{
			DM.fecharConexao(conexao, stm, rs);
		}
		return listaNomeFuncionarios;
		
	}

	public boolean atualizar(Funcionario fun)
	{
		
		PreparedStatement stm = null;
		Produto prodComp = null;
		
		sql = "UPDATE funcionario SET nome = ?, cpf = ?, data_nascimento = ?, salario = ?, funcao = ? WHERE id_funcionario = ?;";
		
		try 
		{
			
			stm = conexao.prepareStatement(sql);
			stm.setString(1, fun.getNome());
			stm.setString(2, fun.getCpf());
			stm.setString(3, fun.getDataNascimento());
			stm.setFloat(4, fun.getSalario());
			stm.setString(5, fun.getFuncao());
			stm.setString(6, fun.getIdFuncionario());
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
	
	public boolean apagar(Funcionario fun)
	{
		
		PreparedStatement stm = null;
		sql = "delete from funcionario where id_funcionario = ?;";
		
		try 
		{
			stm = conexao.prepareStatement(sql);
			stm.setString(1, fun.getIdFuncionario());
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
