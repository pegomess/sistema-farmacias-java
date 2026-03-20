/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Pedro
 */
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Pedido;
  import java.sql.ResultSet;


public class PedidoDAO {
public List<Pedido> listar() throws Exception {
    List<Pedido> lista = new ArrayList<>();

    Connection conn = Conexao.conectar();
    String sql = "SELECT * FROM pedidos";

    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        Pedido p = new Pedido();
        
        p.setCliente(rs.getString("cliente"));
        p.setVendedor(rs.getString("vendedor"));
        p.setProduto(rs.getString("produto"));
        p.setItens(rs.getString("itens"));
        p.setTotal(rs.getDouble("total"));
        

        lista.add(p);
    }

    return lista;
}
    public void salvar(Pedido p) {

        String sql = "INSERT INTO pedidos (cliente, produto, itens, vendedor, total) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getCliente());
            stmt.setString(2, p.getProduto());
            stmt.setString(3, p.getItens());
            stmt.setString(4, p.getVendedor());
            stmt.setDouble(5, p.getTotal());

            stmt.execute();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

