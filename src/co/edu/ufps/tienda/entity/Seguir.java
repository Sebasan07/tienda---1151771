package co.edu.ufps.tienda.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "seguir")

public class Seguir {

	@Id
	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Tienda tienda;
}
