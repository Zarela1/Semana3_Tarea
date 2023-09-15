package com.empresa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	
	private String nombre;
	private String dni; 
	private Date fechaRegistro;
	
	
	@ManyToOne /*De 1 a muchos*/
	@JoinColumn(name = "idTipo") /*Para especificar el ID*/
	private Tipo tipo;
	
	@ManyToOne /*De 1 a muchos*/
	@JoinColumn(name = "idPais") /*Para especificar el ID*/
	private Pais pais;
	
	@PrePersist
    protected void onCreate() {
        fechaRegistro = new Date(); // Configurar la fecha actual antes de la inserción
 }
}
