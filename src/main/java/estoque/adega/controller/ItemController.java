package estoque.adega.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import estoque.adega.dao.ItemDAO;
import estoque.adega.model.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/item")
public class ItemController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ItemDAO dao = new ItemDAO();
		
		List<Item> itens = dao.listaCompleta();
		
		String texto = "";
		
		try {
			Gson gson = new Gson();
			
			texto = gson.toJson(itens);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		resp.getWriter().append(texto);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = req.getReader();
		
		String json = "";
		String linha = "";
		
		while((linha = br.readLine()) != null) {
			json += linha;
		}
		
		Gson gson = new Gson();
		
		Item item = gson.fromJson(json, Item.class);
		
		ItemDAO dao = new ItemDAO();
		
		dao.novo(item);
	}
	
}
