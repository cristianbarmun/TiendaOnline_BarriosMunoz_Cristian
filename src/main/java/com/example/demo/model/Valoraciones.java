package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// default package
// Generated 04-may-2021 10:40:51 by Hibernate Tools 5.4.12.Final

/**
 * Valoraciones generated by hbm2java
 */
@Entity
@Table(name="valoraciones")
public class Valoraciones implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_producto", nullable = true)
	private Integer idProducto;
	
	@Column(name = "id_usuario", nullable = true)
	private Integer idUsuario;
	
	@Column(name = "valoracion", nullable = true)
	private Integer valoracion;
	
	@Column(name = "comentario", nullable = true)
	private String comentario;

	public Valoraciones() {
	}

	public Valoraciones(Integer idProducto, Integer idUsuario, Integer valoracion, String comentario) {
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}