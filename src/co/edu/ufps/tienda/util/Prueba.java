package co.edu.ufps.tienda.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.ufps.tienda.dao.ClienteDAO;
import co.edu.ufps.tienda.dao.SeguirDAO;
import co.edu.ufps.tienda.dao.ServicioDAO;
import co.edu.ufps.tienda.dao.TiendaDAO;
import co.edu.ufps.tienda.entity.Cliente;
import co.edu.ufps.tienda.entity.Seguir;
import co.edu.ufps.tienda.entity.Servicio;
import co.edu.ufps.tienda.entity.Tienda;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");
		EntityManager em = emf.createEntityManager();

		ClienteDAO clienteDao = new ClienteDAO();
		TiendaDAO tiendaDAO = new TiendaDAO();
		SeguirDAO seguirDAO = new SeguirDAO();
		ServicioDAO servicioDAO = new ServicioDAO();

		Cliente c = new Cliente();
		c.setNombre("Juan Sebastian Sanchez Prada");
		c.setEmail("juansebastiansp@ufps.edu.co");
		c.setClave("1234");

		clienteDao.insert(c);

		Tienda t = new Tienda();
		t.setNombre("Alcomprar");
		t.setLema("Al mejor costo, todo es mejor");
		t.setDescripcion("Los mejores precios");
		t.setEmail("tienda@gmail.com");
		t.setClave("1234");
		t.setPropietario("Jairo");
		t.setFacebook("facebook.com");
		t.setWeb("tienda.com");
		t.setImagen("img1");

		tiendaDAO.insert(t);
		
		Servicio s = new Servicio();
		s.setNombre("Calzado");
		s.setDescripcion("venta de calzado");
		
		servicioDAO.insert(s);
		
		Seguir se = new Seguir();

		se.setCliente(c);
		se.setTienda(t);
		
		seguirDAO.insert(se);
		
		clienteDao.update(c);
		tiendaDAO.update(t);
		
		t= tiendaDAO.find(1);
		
		t.setNombre("Alkosto");
		t.setLema("Al mejor costo, todo es mejor");
		t.setDescripcion("Los mejores precios");
		t.setEmail("tienda@gmail.com");
		t.setClave("1234");
		t.setPropietario("Jairo");
		t.setFacebook("facebook.com");
		t.setWeb("https://www.alkosto.com/");
		t.setImagen("img1");	
		tiendaDAO.update(t);
		
		em.close();
	}

}
