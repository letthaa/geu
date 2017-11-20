package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Tipo;
import br.ucsal.util.Conexao;

public class EspacoDAO {

    private Conexao conexao;

    public EspacoDAO() {
	this.conexao = Conexao.getConexao();
    }

    public List<Espaco> listar() {
	Statement stmt;
	List<Espaco> espacos = new ArrayList<>();
	try {
	    stmt = conexao.getConnection().createStatement();
	    ResultSet rs = stmt.executeQuery(
		    "select espacos.id,identificacao,andar,blocos.id, blocos.nome,letra,latitude,longitude,tipos.id, tipos.nome,descricao from espacos,blocos,tipos where bloco_id = blocos.id and tipo_id=tipos.id;");
	    while (rs.next()) {
		Espaco e = new Espaco();
		e.setId(rs.getInt("id"));
		e.setIdentificacao(rs.getString("identificacao"));
		e.setAndar(rs.getString("andar"));

		Bloco bloco = new Bloco();
		bloco.setId(rs.getInt("id"));
		bloco.setNome(rs.getString("nome"));
		bloco.setLetra(rs.getString("letra"));
		bloco.setLatitude(rs.getString("latitude"));
		bloco.setLongitude(rs.getString("longitude"));

		Tipo tipo = new Tipo();
		tipo.setIdTipo(rs.getInt("id"));
		tipo.setNome(rs.getString("nome"));
		tipo.setDescricao(rs.getString("descricao"));

		e.setTipo(tipo);
		e.setBloco(bloco);
		espacos.add(e);
	    }
	    stmt.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return espacos;
    }

    public void inserir(Espaco espaco) {
	try {

	    PreparedStatement ps = conexao.getConnection()
		    .prepareStatement("insert into espacos (identificacao,andar,bloco_id, tipo_id) values (?,?,?,?);");
	    ps.setString(1, espaco.getIdentificacao());
	    ps.setString(2, espaco.getAndar());
	    ps.setInt(3, espaco.getBloco().getId());
	    ps.setInt(4, espaco.getTipo().getIdTipo());
	    ps.execute();
	    ps.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
