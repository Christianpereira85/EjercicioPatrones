package Ejercicio4;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class Ventana {

	private JFrame frame;
	private JTextField txtid;
	private JTextField txtapellido1;
	private JTextField txtapellido2;
	private JTextField txtnombre1;
	private JTextField txtnombre2;
	private JTextField txtdocumento;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnMostrarTodo;
	private DAOPerssona perDAO =  new PersonaDAOImpl ();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 478, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		txtid = new JTextField();
		txtid.setBounds(20, 30, 100, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);

		txtnombre1 = new JTextField();
		txtnombre1.setBounds(20, 80, 100, 20);
		frame.getContentPane().add(txtnombre1);
		txtnombre1.setColumns(10);

		txtnombre2 = new JTextField();
		txtnombre2.setBounds(20, 130, 100, 20);
		frame.getContentPane().add(txtnombre2);
		txtnombre2.setColumns(10);

		txtapellido1 = new JTextField();
		txtapellido1.setBounds(20, 180, 100, 20);
		frame.getContentPane().add(txtapellido1);
		txtapellido1.setColumns(10);

		txtapellido2 = new JTextField();
		txtapellido2.setBounds(20, 230, 100, 20);
		frame.getContentPane().add(txtapellido2);
		txtapellido2.setColumns(10);

		txtdocumento = new JTextField();
		txtdocumento.setBounds(20, 280, 100, 20);
		frame.getContentPane().add(txtdocumento);
		txtdocumento.setColumns(10);

		JButton btnAlta = new JButton("Alta");
		btnAlta.setBackground(Color.PINK);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String documento = txtdocumento.getText();
				String nombre1 = txtnombre1.getText();
				String nombre2 = txtnombre2.getText();
				String apellido1 = txtapellido1.getText();
				String apellido2 = txtapellido2.getText();
				int id = Integer.parseInt(txtid.getText());
				Persona e = new Persona(id, documento, apellido1, apellido2,nombre1, nombre2);
				perDAO.insert(e);
				JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAlta.setBounds(150, 30, 89, 20);
		frame.getContentPane().add(btnAlta);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.PINK);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String documento = txtdocumento.getText();
				String nombre1 = txtnombre1.getText();
				String nombre2 = txtnombre2.getText();
				String apellido1 = txtapellido1.getText();
				String apellido2 = txtapellido2.getText();
				int id = Integer.parseInt(txtid.getText());
				Persona e1 = new Persona(id, documento, apellido1, apellido2,nombre1, nombre2);
				perDAO.delete(e1);
				JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEliminar.setBounds(150, 80, 89, 20);
		frame.getContentPane().add(btnEliminar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.PINK);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(txtid.getText());
				Persona re = perDAO.find(id);

				txtnombre1.setText(re.getNombre1());
				txtapellido1.setText(re.getApellido1());
				txtnombre2.setText(re.getNombre2());
				txtapellido2.setText(re.getApellido2());
				txtid.setText(Integer.toString(re.getId()));
				txtdocumento.setText(re.getDocumento());
			}
		});
		btnBuscar.setBounds(150, 130, 89, 20);
		frame.getContentPane().add(btnBuscar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.PINK);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String documento = txtdocumento.getText();
				String nombre1 = txtnombre1.getText();
				String nombre2 = txtnombre2.getText();
				String apellido1 = txtapellido1.getText();
				String apellido2 = txtapellido2.getText();
				int id = Integer.parseInt(txtid.getText());
				Persona e1 = new Persona(id, documento, apellido1, apellido2, nombre1, nombre2);
				perDAO.update(e1);
				JOptionPane.showMessageDialog(null, "Exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnModificar.setBounds(150, 180, 89, 20);
		frame.getContentPane().add(btnModificar);

		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.setBackground(Color.PINK);
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarTodo mt = new MostrarTodo();
				mt.mostrar();
			}
		});
		btnMostrarTodo.setBounds(150, 292, 247, 58);
		frame.getContentPane().add(btnMostrarTodo);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(20, 10, 70, 14);
		frame.getContentPane().add(lblid);

		JLabel lblnombre1 = new JLabel("Primer nombre");
		lblnombre1.setBounds(20, 60, 100, 14);
		frame.getContentPane().add(lblnombre1);

		JLabel lblnombre2 = new JLabel("Segundo nombre");
		lblnombre2.setBounds(20, 110, 100, 14);
		frame.getContentPane().add(lblnombre2);

		JLabel lblapellido1 = new JLabel("Primer apellido");
		lblapellido1.setBounds(20, 160, 100, 14);
		frame.getContentPane().add(lblapellido1);

		JLabel lblapellido2 = new JLabel("Segundo apellido");
		lblapellido2.setBounds(20, 210, 100, 14);
		frame.getContentPane().add(lblapellido2);

		JLabel lbldocumento = new JLabel("Documento");
		lbldocumento.setBounds(20, 260, 70, 14);
		frame.getContentPane().add(lbldocumento);

	}
}
