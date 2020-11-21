package co.edu.ufps.tienda.dao;

import co.edu.ufps.tienda.entity.Cliente;
import co.edu.ufps.tienda.util.Conexion;

public class ClienteDAO extends Conexion<Cliente> implements GenericDao<Cliente>{

	public ClienteDAO(){
		super(Cliente.class);
	}
}
