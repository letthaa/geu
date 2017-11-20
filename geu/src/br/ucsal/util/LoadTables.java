package br.ucsal.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadTables {

    public void creatScherma(Connection c) throws SQLException {

	Statement stmt = c.createStatement();

	stmt.execute("CREATE TABLE ESPACOS ( ID INTEGER IDENTITY PRIMARY KEY,  IDENTIFICACAO VARCHAR(255),"
		+ " ANDAR  VARCHAR(255), BLOCO_ID INTEGER, TIPO_ID INTEGER );");
	stmt.execute("CREATE TABLE BLOCOS ( ID INTEGER IDENTITY PRIMARY KEY,  NOME VARCHAR(255),"
		+ " LETRA  VARCHAR(255), LATITUDE VARCHAR(255), LONGITUDE VARCHAR(255) );");
	stmt.execute("ALTER TABLE ESPACOS ADD FOREIGN KEY (BLOCO_ID) REFERENCES BLOCOS(ID);");
	stmt.execute(
		"CREATE TABLE TIPOS ( ID INTEGER IDENTITY PRIMARY KEY, NOME VARCHAR(255), DESCRICAO  VARCHAR(255));");
	stmt.execute("ALTER TABLE ESPACOS ADD FOREIGN KEY (TIPO_ID) REFERENCES TIPOS(ID);");

    }
}