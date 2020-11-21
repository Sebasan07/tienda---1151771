package co.edu.ufps.tienda.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tienda")
@NamedQuery(name = "Tienda.findAll", query = "SELECT u FROM Tienda u")

public class Tienda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 200)
	private String lema;
	
	private String descripcion;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 100)
	private String clave;
	
	@Column(length = 100)
	private String propietario;
	
	@Column(length = 100)
	private String facebook;
	
	@Column(length = 100)
	private String web;
	
	@Column(length = 500)
	private String imagen;
	
	@OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
	private Set<Seguir> seguir = new HashSet<Seguir>();
	
	@OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
	private Set<Servicio> servicios = new HashSet<Servicio>();
}
