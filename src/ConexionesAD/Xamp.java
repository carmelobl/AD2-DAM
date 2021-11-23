package ConexionesAD;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Xamp extends JFrame implements ActionListener {
	static JFrame añadirframe;
	static JTextField Nombre;
	static JTextField Edad;
	static JPanel listaPosicion;
	static DefaultListModel<Persona> dlm;
	DefaultListModel dm = new DefaultListModel();
	static JButton añadir;
	static JButton editar;
	static JButton guardar;
	static JButton eliminar;
	JButton OrdenarNombre;
	JButton OrdenarEdad;
	static JList<Persona> lista;
	static Xamp p1;
	public static void main(String[] args)  {

		 p1=new Xamp();
	}
	public void loadlist() {
		try {
			String query = "select * from personas1";
			PreparedStatement pst = Prueba01.Conectar().prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			while (rs.next()) {
				Persona aux=new Persona(rs.getString("nombre"), rs.getString("edad"));
					if (lista.isSelectionEmpty()) {
						dlm.addElement(aux);
					}
					else {
						dlm.setElementAt(aux, lista.getSelectedIndex());
					}
				}
				pack();
				setVisible(true);
			lista.updateUI();
			pst.close();
			rs.close();



		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public Xamp() {

		setTitle("Coleccion Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel marco = new JPanel(new FlowLayout(FlowLayout.CENTER));
		marco.add(añadir = new JButton("Añadir"));
		dlm = new DefaultListModel<Persona>();
		añadir.addActionListener(this);
		lista = new JList<Persona>(dlm);
		listaPosicion = new JPanel();
		listaPosicion.add(lista);
		listaPosicion.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(listaPosicion, BorderLayout.NORTH);
		add(marco, BorderLayout.CENTER);

		marco.add(editar = new JButton("Eliminar"));
		editar.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));
		
		
		marco.add(OrdenarNombre = new JButton("Ordenar por Nombre"));
		OrdenarNombre.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));
		
		marco.add(OrdenarEdad = new JButton("Ordenar por Edad"));
		OrdenarEdad.addActionListener(this);
		setLocation(850, 450);
		setMinimumSize(new Dimension(400, 100));
		
		add(marco);

		pack();
		setVisible(true);
		loadlist();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String botones = e.getActionCommand();
		if (botones.equals("Ordenar por Nombre")) {
			dm.clear();
			OrdenarNombre();		
		}
		if (botones.equals("Ordenar por Edad")) {
			dm.clear();
			OrdenarEdad();		
		}
		if (botones.equals("Añadir")) {

			añadir();
		}
		if (botones.equals("Eliminar")) {
			
			eliminar();
			dm.clear();

		}
		if (botones.equals("Guardar")) {
			guardar();
		}
		if (botones.equals("Cancelar")) {
			añadirframe.dispose();
			setVisible(true);
		}
	}


	public void añadir() {
		añadirframe = new JFrame();
		añadirframe.setTitle("Personas");
		JPanel save = new JPanel(new GridLayout(4, 2, 5, 10));
		añadirframe.add(save);
		save.add(new JLabel("Nombre"));
		save.add(Nombre = new JTextField(10));
		save.add(new JLabel("Edad"));
		save.add(Edad = new JTextField(10));

		añadirframe.setMinimumSize(new Dimension(400, 100));
		añadirframe.setLocation(850, 450);

		save.add(guardar = new JButton("Guardar"));

		JButton cancelar;
		save.add(cancelar = new JButton("Cancelar"));
		cancelar.addActionListener(this);
		guardar.addActionListener(this);
		añadirframe.pack();
		añadirframe.setVisible(true);
		dispose();

	}

	public void guardar() {


		try {
			Connection miConexion=Prueba01.Conectar();


			PreparedStatement insertar=miConexion.prepareStatement("INSERT INTO `personas1`(`nombre`, `edad`) values (?,?)");
			insertar.setString(1,String.valueOf(Nombre.getText()));
			insertar.setString(2, String.valueOf(Edad.getText()));
			insertar.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Excecpión "+e);
		}
		Persona p = new Persona(Nombre.getText(), Edad.getText());
		if (Nombre.getText().equals("") || Edad.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debes rellenar todos los apartados");
		}
		else {
			if (lista.isSelectionEmpty()) {
				dlm.addElement(p);
			}
			else {
				dlm.setElementAt(p, lista.getSelectedIndex());
			}
			añadirframe.dispose();
			pack();
			setVisible(true);

		}



	}


	public void eliminar() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = Prueba01.Conectar();
			preparedStatement = connection.prepareStatement("DELETE FROM personas1 WHERE nombre = ?");
			preparedStatement.setString(1, String.valueOf(dlm.get(lista.getSelectedIndex()).getNombre()));
			System.out.println(dlm.get(lista.getSelectedIndex()).getNombre());
			preparedStatement.executeUpdate();

			System.out.println("Ha sido eliminado");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void OrdenarNombre() {
		try {
			Connection connection = null;
			connection = Prueba01.Conectar();

			PreparedStatement mostrar=connection.prepareStatement("SELECT * FROM `personas1` ORDER BY nombre");
			ResultSet rs =mostrar.executeQuery();

			while(rs.next()) {
				dm.addElement(rs.getString("nombre"));
			}
			lista.setModel(dm);


		}catch(SQLException e) {
			System.out.println("Excecpión "+e);
		}


	}
	//Ordeno de menor a mayor todas las edades que tengo en la tabla 
	public void OrdenarEdad() {
		try {
			Connection connection = null;
			connection = Prueba01.Conectar();


			PreparedStatement mostrar=connection.prepareStatement("SELECT * FROM `personas1` ORDER BY edad");
			ResultSet rs =mostrar.executeQuery();

			while(rs.next()) {
				dm.addElement(rs.getString("edad"));
			}
			lista.setModel(dm);


		}catch(SQLException e) {
			System.out.println("Excecpión "+e);
		}


	}








}
