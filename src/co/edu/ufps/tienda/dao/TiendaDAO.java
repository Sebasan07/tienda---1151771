package co.edu.ufps.tienda.dao;

import co.edu.ufps.tienda.entity.Tienda;
import co.edu.ufps.tienda.util.Conexion;

public class TiendaDAO extends Conexion<Tienda> implements GenericDao<Tienda>{

	public TiendaDAO(){
		super(Tienda.class);
	}
}
