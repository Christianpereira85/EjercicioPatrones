package Ejercicio4;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class MostrarTodo {


	private DAOPerssona perDAO;

	public void mostrar() {

		perDAO = new PersonaDAOImpl();
		
		JFrame frame = new JFrame("Mostrar");

		DefaultTableModel modelo = new DefaultTableModel();

		
		final JTable table = new JTable(modelo);

		final String[] columnNames = { "ID", "Documento", "Primer Apellido", "Segundo Apellido", "Primer Nombre", "Segundo Nombre",};

		for (int column = 0; column < columnNames.length; column++) {
			
			modelo.addColumn(columnNames[column]);
		}


		Object[] fila = new Object[columnNames.length];
		
		LinkedList<Persona> todosPersona = perDAO.findAll();

		for(int i=0;i<todosPersona.size();i++) {
			
			int id = todosPersona.get(i).getId();
			String nombre1 = todosPersona.get(i).getNombre1();
			String nombre2 = todosPersona.get(i).getNombre2();
			String apellido1 = todosPersona.get(i).getApellido1();
			String apellido2 = todosPersona.get(i).getApellido2();
			String documento = todosPersona.get(i).getDocumento();
			
			fila[0] = id;
			fila[1] = documento;
			fila[2] = apellido1;
			fila[3] = apellido2;
			fila[4] = nombre1;
			fila[5] = nombre2;
						
			modelo.addRow(fila);
		}
		
		
				table.setPreferredScrollableViewportSize(new Dimension(600, 100));
				
				JScrollPane scrollPane = new JScrollPane(table);
				
				JPanel panel = new JPanel();
				
				panel.add(scrollPane);		

				frame.add(panel);
				frame.pack();

				frame.setVisible(true);
				frame.setResizable(false);
	}

}
