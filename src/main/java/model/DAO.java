package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbstockmed?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return con;
		}
	}

	/** CRUD CREATE **/
	public void inserirMaterial(JavaBeans material) {
		String create = "insert into materiais (nome, codMaterial, quantidade) values (?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir parametros (?) pelo conteudo das var JavaBeans
			pst.setString(1, material.getNome());
			pst.setString(2, material.getCodMaterial());
			pst.setString(3, material.getQuantidade());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarMateriais() {
		// criando objeto pra acessar a classe JavaBeans
		ArrayList<JavaBeans> materiais = new ArrayList<>();
		String read = "select * from materiais order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// este laço será rexecutado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do BD
				String idmaterial = rs.getString(1);
				String nome = rs.getString(2);
				String codMaterial = rs.getString(3);
				String quantidade = rs.getString(4);
				// populando o ArrayList
				materiais.add(new JavaBeans(idmaterial, nome, codMaterial, quantidade));
			}
			con.close();
			return materiais;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD UPDATE **/
	//selecionar o material
	public void selecionarMaterial(JavaBeans material) {
		String read2 = "select * from materiais where idmaterial = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, material.getIdmaterial());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//setar as variaveis JavaBeans
				material.setIdmaterial(rs.getString(1));
				material.setNome(rs.getString(2));
				material.setCodMaterial(rs.getString(3));
				material.setQuantidade(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//editar contato
	public void alterarMaterial(JavaBeans material) {
		String create = "update materiais set nome=?,codMaterial=?,quantidade=? where idmaterial=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, material.getNome());
			pst.setString(2, material.getCodMaterial());
			pst.setString(3, material.getQuantidade());
			pst.setString(4, material.getIdmaterial());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
