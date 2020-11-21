package co.edu.ufps.tienda.dao;

import java.util.List;

public interface GenericDao<T> {

	public <E> T find(E id);

	public List<T> list();

	public void insert(T o);

	public void update(T o);

	public void delete(T o);
}
