package co.edu.ufps.tienda.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

public class Seguir implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "cliente", nullable = false)
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name = "tienda", nullable = false)
	@ManyToOne
	private Tienda tienda;
}
