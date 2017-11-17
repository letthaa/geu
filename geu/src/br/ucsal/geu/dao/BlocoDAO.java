package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Bloco;
import br.ucsal.util.Conexao;

public class BlocoDAO {

	private Conexao conexao;

	public BlocoDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Bloco> listar() {
		Statement stmt;
		List<Bloco> blocos = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id,nome,letra,latitude,longitude from blocos;");
			while (rs.next()) {
				Bloco b = new Bloco();
				b.setId(rs.getInt("id"));
				b.setNome(rs.getString("nome"));
				b.setLetra(rs.getString("letra"));
				b.setLatitude(rs.getString("latitude"));
				b.setLongitude(rs.getString("longitude"));
				blocos.add(b);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return blocos;
	}

	public void inserir(Bloco bloco) {
		try {

			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("insert into blocos (nome,letra,latitude,longitude) values (?,?,?,?);");
			ps.setString(1, bloco.getNome());
			ps.setString(2, bloco.getLetra());
			ps.setString(3, bloco.getLatitude());
			ps.setString(4, bloco.getLongitude());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Bloco getByID(int id) {
		Bloco b = null;
		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("select id,nome,letra,latitude,longitude from blocos where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = new Bloco();
				b.setId(rs.getInt("id"));
				b.setNome(rs.getString("nome"));
				b.setLetra(rs.getString("letra"));
				b.setLatitude(rs.getString("latitude"));
				b.setLongitude(rs.getString("longitude"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public void close() {
		conexao.closeConnection();
	}

}
