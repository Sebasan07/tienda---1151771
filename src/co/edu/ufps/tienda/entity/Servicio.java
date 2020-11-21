package co.edu.ufps.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "servicio")
@NamedQuery(name = "Servicio.findAll", query = "SELECT u FROM Servicio u")

public class Servicio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 200)
	private String nombre;
	
	private String descripcion;
	
	@ManyToOne
	private Tienda tienda;
}
