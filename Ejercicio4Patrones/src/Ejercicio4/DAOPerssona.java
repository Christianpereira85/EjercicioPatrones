package Ejercicio4;


import java.util.LinkedList;

public interface DAOPerssona {

	
	public boolean insert (Persona persona);
	public boolean update (Persona persona);
	public boolean delete (Persona persona);
	public LinkedList<Persona> findAll();
	public Persona find(int id);
}
