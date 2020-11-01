package funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Conexao {

    public static void criarTabela() {
        PreparedStatement ps = null;
        try {
            ps = conexao().prepareStatement("CREATE TABLE ALUNO2(nome varchar(50) not null)");///criar tabela
            ps.executeUpdate();
            System.out.println("TABELA CRIADA");
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }
    }

    public static void adcionar() {
        PreparedStatement ps = null;
        try {
            ps = conexao().prepareStatement("INSERT INTO aluno2 values('wenner')");///criar tabela
            ps.executeUpdate();
            System.out.println("add");
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
        }
    }
    static ArrayList<Funcionario> lista = new ArrayList<>();

    public static ArrayList<Funcionario> lista() {
        PreparedStatement ps = null;
        try {
            ps = conexao().prepareStatement("SELECT * FROM aluno2");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = ps.executeQuery();//excutando
            while (rs.next()) {
                Funcionario f = new Funcionario("", "", 0, 0, "");
                f.setNome(rs.getString("nome"));
                lista.add(f);///
            }
        } catch (SQLException ex) {

        }
        return lista;
    }

    public static Connection conexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/escola", "root", "1914");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
    }
}
