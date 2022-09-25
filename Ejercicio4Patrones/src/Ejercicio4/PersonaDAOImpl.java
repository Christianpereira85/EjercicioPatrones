package Ejercicio4;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
public class PersonaDAOImpl implements DAOPerssona {

	private static final String ALL_PERSONAS = "SELECT * FROM PERSONA";
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA, DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2) VALUES (?,?,?,?,?,?)";
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=? WHERE ID_PERSONA=?";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
	private static final String PERSONA_CI = "SELECT * FROM PERSONA WHERE ID_PERSONA=?";
	
	@Override
	public boolean insert(Persona persona) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONA);

			statement.setInt(1, persona.getId());
			statement.setString(2, persona.getDocumento());
			statement.setString(3, persona.getApellido1());
			statement.setString(4, persona.getApellido2());
			statement.setString(5, persona.getNombre1());
			statement.setString(6, persona.getNombre2());

			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Persona persona) {
		try {
			PreparedStatement statement =  DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONA);

			statement.setString(1, persona.getDocumento());
			statement.setString(2, persona.getApellido1());
			statement.setString(3, persona.getApellido2());
			statement.setString(4, persona.getNombre1());
			statement.setString(5, persona.getNombre2());
			statement.setInt(6, persona.getId());

			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Persona persona) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_PERSONA);
			statement.setInt(1, persona.getId());

			int retorno = statement.executeUpdate();
			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public LinkedList<Persona> findAll() {
		LinkedList<Persona> personas = new LinkedList<>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Persona persona = getPersonaFromResultSet(resultado);
				personas.add(persona);
			}
			return personas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Persona find(int id) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(PERSONA_CI);
			statement.setInt(1, id);

			ResultSet resultado = statement.executeQuery();
			Persona persona = null;
			if (resultado.next()) {
				persona = getPersonaFromResultSet(resultado);
			}
			return persona;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Persona getPersonaFromResultSet(ResultSet resultado) throws SQLException {

		String nombre1 = resultado.getString("NOMBRE1");
		String apellido1 = resultado.getString("APELLIDO1");
		String documento = resultado.getString("DOCUMENTO");
		String nombre2 = resultado.getString("NOMBRE2");
		String apellido2 = resultado.getString("APELLIDO2");
		int id = resultado.getInt("ID_PERSONA");

		Persona persona = new Persona(id, documento, apellido1, apellido2,  nombre1, nombre2);

		return persona;
	}
}
