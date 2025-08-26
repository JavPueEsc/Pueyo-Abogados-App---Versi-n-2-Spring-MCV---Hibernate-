package com.jpueyodev;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="abogados")
public class Lawyer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAbogado")
	private Integer id;
	@Column(name="nombreAbogado")
	@NotBlank(message="El campo 'Nombre' no puede quedarse vacío")
	@Size(min=2, max=45, message="El nombre debe tener entre 2 y 45 caracteres.")
	private String nombre;
	@Column(name="apellidosAbogado")
	@NotBlank(message="El campo 'Apellidos' no puede quedarse vacío")
	@Size(min=2, max=100, message="Los apellidos deben tener entre 2 y 100 caracteres.")
	private String apellidos;
	@Column(name="dniAbogado")
	private String dni;
	@Column(name="telefonoAbogado")
	@NotBlank(message="El campo 'Telefono' no puede quedarse vacío")
	private String telefono;
	@Column(name="mailAbogado")
	@NotBlank(message="El campo 'Mail' no puede quedarse vacío")
	@Email(message = "Debe tener un formato válido de correo electrónico")
	private String mail;
	@Column(name="fechaAltaAbogado")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull(message="El campo 'Fecha de alta' no puede quedarse vacío")
	private LocalDate fechaAlta;
	@Column(name="numColegiadoAbogado")
	@NotNull(message="El campo 'Número de colegiado' no puede quedarse vacío")
	@Positive(message="El número de colegiado debe ser mayor que 0")
	private int numColegiado;
	@Column(name="honorariosAbogado")
	@NotNull(message="El campo 'Honorarios' no puede quedarse vacío")
	@Digits(integer = 8, fraction = 2, message = "Máx 8 enteros y 2 decimales")
	@DecimalMin(value = "0.00", inclusive = false, message = "Los honorarios deben ser mayores que cero")
	private BigDecimal honorarios;
	
	public Lawyer() {}

	public Lawyer(String nombre, String apellidos, String dni, String telefono, String mail, LocalDate fechaAlta,
			int numColegiado, BigDecimal honorarios) {
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

	public int getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(int numColegiado) {
		this.numColegiado = numColegiado;
	}

	public BigDecimal getHonorarios() {
		return honorarios;
	}

	public void setHonorarios(BigDecimal honorarios) {
		this.honorarios = honorarios;
	}

	@Override
	public String toString() {
		return "Lawyer [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
				+ telefono + ", mail=" + mail + ", fechaAlta=" + fechaAlta + ", numColegiado=" + numColegiado
				+ ", honorarios=" + honorarios + "]";
	}
	
}
