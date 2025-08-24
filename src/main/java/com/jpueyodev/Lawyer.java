package com.jpueyodev;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abogados")
public class Lawyer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAbogado")
	private Integer id;
	@Column(name="nombreAbogado")
	private String nombre;
	@Column(name="apellidosAbogado")
	private String apellidos;
	@Column(name="dniAbogado")
	private String dni;
	@Column(name="telefonoAbogado")
	private String telefono;
	@Column(name="mailAbogado")
	private String mail;
	@Column(name="fechaAltaAbogado")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaAlta;
	@Column(name="numColegiadoAbogado")
	private String numColegiado;
	@Column(name="honorariosAbogado")
	private Double honorarios;
	
	public Lawyer() {}

	public Lawyer(String nombre, String apellidos, String dni, String telefono, String mail, LocalDate fechaAlta,
			String numColegiado, Double honorarios) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaAlta = fechaAlta;
		this.numColegiado = numColegiado;
		this.honorarios = honorarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public Double getHonorarios() {
		return honorarios;
	}

	public void setHonorarios(Double honorarios) {
		this.honorarios = honorarios;
	}

	@Override
	public String toString() {
		return "Lawyer [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
				+ telefono + ", mail=" + mail + ", fechaAlta=" + fechaAlta + ", numColegiado=" + numColegiado
				+ ", honorarios=" + honorarios + "]";
	}
	
}
