package estoque.adega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.adega.model.Item;

public class ItemDAO {

	private final String SQLSELECT = "SELECT id, nome, preco, quantidade, id_categoria FROM item";
	
	private final String SQLINSERT = "SELECT nome = ?, preco = ?, quantidade = ?, id_categoria = ? FROM item";
	
	
	public int novo(Item item) {
		Connection con = null;
		try {
			con = dao.conexao();
			
			con.setAutoCommit(false);
			
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT);
				
				ps.setString(1, item.getNome());
				ps.setFloat(2, item.getPreco());
				ps.setInt(3, item.getQuantidade());
				ps.setInt(4, item.getId_categoria());
				
				ps.execute();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				con.rollback();
				
			} catch (SQLException e1) {
 
			}
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item.getId();
		
	}
	
	public List<Item> listaCompleta(){
		
		List<Item> itens = new ArrayList<Item>();
		
		try {
			Connection con = dao.conexao();
			
			if (!con.isClosed()){
				PreparedStatement ps = con.prepareStatement(SQLSELECT);	
				ResultSet rs = ps.executeQuery();
				
				Item tmp = null;
				
				
				while(rs.next()) {
					tmp = new Item();
					
					tmp.setId(rs.getInt("id"));
					tmp.setNome(rs.getString("nome"));
					tmp.setPreco(rs.getFloat("preco"));
					tmp.setId_categoria(rs.getInt("id_categoria"));
					
					itens.add(tmp);
				}
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return itens;
	}
	
	
	
}