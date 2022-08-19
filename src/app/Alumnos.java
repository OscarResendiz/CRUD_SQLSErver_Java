package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Alumnos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtEmail;
	private JTextField txtID;
	private JTable tblAlumnos;
	private JRadioButton rbMasculino;
	private JRadioButton rbFemenino;
	private ButtonGroup btnGr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumnos frame = new Alumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	public Alumnos() throws ClassNotFoundException {
		setTitle("Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(674, 114, 416, 350);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Matricula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 24, 59, 14);
		panel.add(lblNewLabel_1);

		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMatricula.setBounds(77, 21, 184, 20);
		panel.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 63, 59, 14);
		panel.add(lblNewLabel_2);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(77, 60, 184, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 105, 46, 14);
		panel.add(lblNewLabel_3);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEdad.setBounds(77, 102, 86, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Sexo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 148, 46, 14);
		panel.add(lblNewLabel_4);

		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setSelected(true);
		rbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbMasculino.setBounds(63, 144, 109, 23);
		panel.add(rbMasculino);

		rbFemenino = new JRadioButton("Mujer");
		rbFemenino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbFemenino.setBounds(176, 144, 109, 23);
		panel.add(rbFemenino);

		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 187, 46, 14);
		panel.add(lblNewLabel_5);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(77, 184, 184, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BGuardar_Click(e);
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(10, 264, 89, 23);
		panel.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(113, 264, 89, 23);
		panel.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(212, 264, 89, 23);
		panel.add(btnEliminar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(305, 264, 89, 23);
		panel.add(btnLimpiar);

		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setFocusCycleRoot(true);
		txtID.setBounds(308, 23, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel = new JLabel("Alumnos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(26, 28, 78, 36);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 121, 638, 332);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		tblAlumnos = new JTable();
		tblAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OnmouseClicked(e);
			}
		});
		panel_1.add(tblAlumnos);
		tblAlumnos.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "id", "Matricula", "Nombre", "Edad", "Sexo", "Email" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		tblAlumnos.getColumnModel().getColumn(0).setResizable(false);
		tblAlumnos.getColumnModel().getColumn(1).setResizable(false);
		tblAlumnos.getColumnModel().getColumn(2).setResizable(false);
		tblAlumnos.getColumnModel().getColumn(3).setResizable(false);
		tblAlumnos.getColumnModel().getColumn(4).setResizable(false);
		tblAlumnos.getColumnModel().getColumn(5).setResizable(false);
		JTableHeader header = tblAlumnos.getTableHeader();
		panel_1.add(header, BorderLayout.NORTH);
		btnGr = new ButtonGroup();
		btnGr.add(rbMasculino);
		btnGr.add(rbFemenino);
		cargarTabla();
	}

	// funciones------------------------------------------------
	private void BGuardar_Click(ActionEvent e) {
		String matricula = txtMatricula.getText();
		String nombre = txtNombre.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		String email = txtEmail.getText();
		String sexo = "M";

		if (rbMasculino.isSelected() == true) {
			sexo = "M";
		} else if (rbFemenino.isSelected() == true) {
			sexo = "F";
		}
		try {
			// obtenemos la conexion
			Connection con = conexion.getConexion();
			if (con != null) {
				// preparamos la consulta
				PreparedStatement ps = con.prepareStatement(
						"insert into alumnos (matricula,nombre,edad,sexo,email,activo) values(?,?,?,?,?,?)");
				// se asignan los parametros
				ps.setString(1, matricula);
				ps.setString(2, nombre);
				ps.setInt(3, edad);
				ps.setString(4, sexo);
				ps.setString(5, email);
				ps.setInt(6, 1);
				// se manda a ejecutar
				ps.executeUpdate();
				// mandamos mensaje de ejecucion
				// JOptionPane.showMessageDialog(null, "Registro agregado");
				limpiar();
				cargarTabla();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	private void limpiar() {
		txtMatricula.setText("");
		txtNombre.setText("");
		txtEdad.setText("");
		txtEmail.setText("");
		txtID.setText("");
		btnGr.clearSelection();
	}

	private void cargarTabla() throws ClassNotFoundException {
		// toma el diseño del grid
		DefaultTableModel modeloTabla = (DefaultTableModel) tblAlumnos.getModel();
		modeloTabla.setRowCount(0); // se limpia el grid
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;
		int[] anchos = { 10, 50, 100, 30, 25, 100 };
		for (int i = 0; i < tblAlumnos.getColumnCount(); i++) {
			tblAlumnos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		try {
			Connection con = conexion.getConexion();
			ps = con.prepareStatement("select * from alumnos");
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			columnas = rsmd.getColumnCount();
			while (rs.next()) {
				Object[] fila = new Object[columnas];
				for (int indice = 0; indice < columnas; indice++) {
					fila[indice] = rs.getObject(indice + 1);
				}
				modeloTabla.addRow(fila);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	private void OnmouseClicked(MouseEvent e) {
		try {
			int fila = tblAlumnos.getSelectedRow();
			int id = Integer.parseInt(tblAlumnos.getValueAt(fila, 0).toString());
			PreparedStatement ps;
			ResultSet rs;
			ResultSetMetaData rsmd;
			Connection con = conexion.getConexion();
			ps = con.prepareStatement("select * from alumnos where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			int columnas = rsmd.getColumnCount();
			while (rs.next()) {
				txtID.setText(String.valueOf(id));
				txtMatricula.setText(rs.getString("matricula"));
				txtNombre.setText(rs.getString("nombre"));
				txtEdad.setText(rs.getString("edad"));
				txtEmail.setText(rs.getString("email"));
				rbMasculino.setSelected(rs.getString("sexo").equals("M"));
				rbFemenino.setSelected(rs.getString("sexo").equals("F"));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	private void Modificar()
	{
		int id=Integer.parseInt(txtID.getText());
		String matricula = txtMatricula.getText();
		String nombre = txtNombre.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		String email = txtEmail.getText();
		String sexo = "M";

		if (rbMasculino.isSelected() == true) {
			sexo = "M";
		} else if (rbFemenino.isSelected() == true) {
			sexo = "F";
		}
		try {
			// obtenemos la conexion
			Connection con = conexion.getConexion();
			if (con != null) {
				// preparamos la consulta
				PreparedStatement ps = con.prepareStatement(
						"update alumnos set matricula=?,nombre=?,edad=?,sexo=?,email=? where id=?");
				// se asignan los parametros
				ps.setString(1, matricula);
				ps.setString(2, nombre);
				ps.setInt(3, edad);
				ps.setString(4, sexo);
				ps.setString(5, email);
				ps.setInt(6, id);
				// se manda a ejecutar
				ps.executeUpdate();
				// mandamos mensaje de ejecucion
				// JOptionPane.showMessageDialog(null, "Registro agregado");
				limpiar();
				cargarTabla();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
	private void Eliminar()
	{
		int id=Integer.parseInt(txtID.getText());
		try {
			// obtenemos la conexion
			Connection con = conexion.getConexion();
			if (con != null) {
				// preparamos la consulta
				PreparedStatement ps = con.prepareStatement(
						"delete  alumnos where id=?");
				ps.setInt(1, id);
				// se manda a ejecutar
				ps.executeUpdate();
				// mandamos mensaje de ejecucion
				// JOptionPane.showMessageDialog(null, "Registro agregado");
				limpiar();
				cargarTabla();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
}
