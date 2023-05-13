import java.sql.Date;

public class Usuario {

	private long id;
	private String nome;
	private String email;
	private String senha;
	private Date dataRegistro = new Date(System.currentTimeMillis());

	public Usuario(String nome, String email, String senha) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuario() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
}
