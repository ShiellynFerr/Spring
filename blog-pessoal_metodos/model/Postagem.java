package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; //equivalente ao bigInt
	
	@NotNull(message = "O campo titulo é obrigatório")
	@Size(min = 5, max = 100, message = "O titulo deve conter no mínimo 5 caracteres")
	private String titulo;
	
	@NotNull(message = "O campo titulo é obrigatório")
	@Size(min = 50, max = 1000, message = "O texto deve conter no mínimo 50 caracteres")
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	 private Date data=new java.sql.Date(System.currentTimeMillis());

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	

}
