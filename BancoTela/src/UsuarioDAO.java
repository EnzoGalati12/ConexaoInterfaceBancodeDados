import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	
	  private  static Connection conexao;

	    public UsuarioDAO() {
	        conectarDAO();
	    }

	    public static Connection conectarDAO(){
	        if(conexao == null){
	            conexao = new ConnectionFactory().conectar();
	        }
	        return conexao;
	    }

	    //insert
	    public void insert(Usuario usuario) throws SQLException {
	        String sql = "INSERT INTO USUARIOS(nome, email, senha, dataregistro) VALUES (?,?,?,?)";

	        PreparedStatement stmt = conexao.prepareStatement(sql);

	        stmt.setString(1, usuario.getNome());
	        stmt.setString(2, usuario.getEmail());
	        stmt.setString(3, usuario.getSenha());
	        stmt.setDate(4,usuario.getDataRegistro());

	        stmt.execute();
	        stmt.close();

	    }

	    //delete
	    public void delete(Long id) throws SQLException{
	        String sql = "DELETE FROM USUARIOS WHERE id=?";
	        try{
	            PreparedStatement stmt = conexao.prepareStatement(sql);
	            stmt.setLong(1, id);

	            stmt.execute();
	            stmt.close();
	        } catch (SQLException ex){
	            throw new RuntimeException(ex);
	        }
	    }

	    //update
	    public void update(Usuario usuario) throws SQLException {
	        String sql = "UPDATE USUARIOS SET nome=?, email=?, senha=? WHERE id=?";
	        try{
	            PreparedStatement stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, usuario.getNome());
	            stmt.setString(2, usuario.getEmail());
	            stmt.setString(3, usuario.getSenha());
	            stmt.setLong(4,usuario.getId());

	            stmt.execute();
	            stmt.close();
	        } catch (Exception ex){
	            throw new RuntimeException(ex);
	        }
	    }

	    //select

	    //selectAll
	    public List<Usuario> select() throws Exception {
	        List<Usuario> usuarios = new ArrayList<Usuario>();
	        String sql = "select * from usuarios";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()){
	            Usuario usuario = new Usuario();
	            usuario.setId(rs.getLong("id"));
	            usuario.setNome(rs.getString("nome"));
	            usuario.setEmail(rs.getString("email"));
	            usuario.setSenha(rs.getString("senha"));
	            usuario.setDataRegistro(rs.getDate("dataregistro"));

	            usuarios.add(usuario);
	        }
	        rs.close();
	        stmt.close();
	        return usuarios;
	    }


	    //selectById
	    public Usuario selectById(Long id) throws Exception {
	        Usuario usuario = null;
	        String sql = "select * from usuarios where id=?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setLong(1,id);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()){
	            usuario = new Usuario();
	            usuario.setId(rs.getLong("id"));
	            usuario.setNome(rs.getString("nome"));
	            usuario.setEmail(rs.getString("email"));
	            usuario.setSenha(rs.getString("senha"));
	            usuario.setDataRegistro(rs.getDate("dataregistro"));


	        }
	        rs.close();
	        stmt.close();
	        return usuario;
	    }
	
	

}
