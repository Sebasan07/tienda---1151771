package co.edu.ufps.tienda.dao;

import co.edu.ufps.tienda.entity.Servicio;
import co.edu.ufps.tienda.util.Conexion;

public class ServicioDAO extends Conexion<Servicio> implements GenericDao<Servicio>{

	public ServicioDAO(){
		super(Servicio.class);
	}
}
