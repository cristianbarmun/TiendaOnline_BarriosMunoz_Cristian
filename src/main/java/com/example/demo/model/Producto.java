package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_categoria", nullable = true)
	private int id_categoria;
	
	@Column(name = "nombre", nullable = true)
	private String nombre;
	
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	
	@Column(name = "precio", nullable = true)
	private double precio;
	
	@Column(name = "stock", nullable = true)
	private int stock;
	
	@Column(name = "fecha_alta", nullable = true)
	private Date fecha_alta;
	
	@Column(name = "fecha_baja", nullable = true)
	private Date fecha_baja;
	
	@Column(name = "impuesto", nullable = true)
	private float impuesto;
	
	public Producto() {}

	public Producto(int id, int id_categoria, String nombre, String descripcion, double precio, int stock,
			Date fecha_alta, Date fecha_baja, float impuesto) {
		super();
		this.id = id;
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fecha_alta = fecha_alta;
		this.fecha_baja = fecha_baja;
		this.impuesto = impuesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", id_categoria=" + id_categoria + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + ", fecha_alta=" + fecha_alta
				+ ", fecha_baja=" + fecha_baja + ", impuesto=" + impuesto + "]";
	}
}
