/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
public class DTDGenerico {

    public DTDGenerico() {
    }

    public List<DTDConsulta> consultaPublicacao(String bn, String titulo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<DTDConsulta> lista = null;
        System.out.print(bn + "" + titulo);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            Statement cSQL = conexao.createStatement();
            ResultSet rs = cSQL.executeQuery("SELECT publicacao.isbn, publicacao.titulo, publicacao.autor, publicacao.editora, exemplar.numero, exemplar.preco, emprestimo.codigo, emprestimo.Codigo_Assoc, emprestimo.Data_Emp, emprestimo.Data_Devol  FROM publicacao\n"
                    + "JOIN exemplar ON publicacao.isbn=exemplar.isbn left join emprestimo on emprestimo.nro_exemplar=exemplar.numero and emprestimo.isbn=publicacao.isbn where publicacao.isbn='" + bn + "' or publicacao.titulo='" + titulo + "'");
            while (rs.next()) {
                DTDConsulta result = new DTDConsulta();
                result.setIsbn(rs.getString(0));
                result.setTitulo(rs.getString(1));
                lista.add(result);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro !" + e.getErrorCode());
        }
        return null;
    }
}
