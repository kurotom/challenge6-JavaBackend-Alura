package com.hotelalura.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.google.protobuf.Option;
import com.hotelalura.controller.BusquedaController;
import com.hotelalura.dao.BusquedaDAO;
import com.hotelalura.models.Funcionario;
import com.hotelalura.models.Huesped;
import com.hotelalura.models.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.UndeclaredThrowableException;



@SuppressWarnings("serial")
public class Busqueda extends JFrame {
	
	
	BusquedaController busquedaController = null;
	
	private boolean mostrarMensaje = false;
	

	private JPanel contentPane;
	private JTextField txtBuscar, txtLimpiarBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloR;
	private DefaultTableModel modeloH;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario funcionario = new Funcionario("admin", "admin");
					Busqueda frame = new Busqueda(funcionario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda(Funcionario funcionario) {
		
		this.busquedaController = new BusquedaController();
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/com/hotelalura/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		
		JLabel txtLimpiarBuscar = new JLabel();
		txtLimpiarBuscar.setForeground(new Color(255, 255, 255));
		txtLimpiarBuscar.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtLimpiarBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtLimpiarBuscar.setText("Limpiar");
		txtLimpiarBuscar.setBounds(12, 0, 100, 30);
		txtLimpiarBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		txtLimpiarBuscar.setColumns(10);
		
		JPanel btnLimpiar = new JPanel();
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("LIMPIAR");
				txtBuscar.setText("");
				
				List<Reserva> listaReservas = busquedaController.datosReservas();
//				cargarTablaReserva(modeloR, listaReservas);
//				
				List<Huesped> listaHuespedes = busquedaController.datosHuespedes();
//				cargarTablaHuesped(modeloH, listaHuespedes);
				
				reloadTablas(listaReservas, listaHuespedes);;
				
			}
		});
		btnLimpiar.setLayout(null);
		btnLimpiar.setBackground(new Color(12, 138, 199));
		btnLimpiar.setBounds(748, 167, 122, 30);
		btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnLimpiar);
		btnLimpiar.add(txtLimpiarBuscar);
		
		

		
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 324, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/com/hotelalura/imagenes/reservado.png")), tbReservas, null);
		modeloR = (DefaultTableModel) tbReservas.getModel();
		modeloR.addColumn("Numero de Reserva");
		modeloR.addColumn("Fecha Check In");
		modeloR.addColumn("Fecha Check Out");
		modeloR.addColumn("Valor");
		modeloR.addColumn("Forma de Pago");
		
		List<Reserva> listaReservas = this.busquedaController.datosReservas();
		cargarTablaReserva(listaReservas);
//		cargarTablaReserva();
		
		
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/com/hotelalura/imagenes/pessoas.png")), tbHuespedes, null);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Numero de Huesped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Telefono");
		modeloH.addColumn("Numero de Reserva");
		
		
		List<Huesped> listaHuespedes = this.busquedaController.datosHuespedes();
		cargarTablaHuesped(listaHuespedes);
//		cargarTablaHuesped();
		
		
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/com/hotelalura/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//
//   ------>   CIERRA CONEXION y POOL
//				
				busquedaController.closeAndDestroy();
				
				MenuUsuario usuario = new MenuUsuario(funcionario);
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

//
//   ------>   CIERRA CONEXION y POOL
//
				busquedaController.closeAndDestroy();
				
				MenuUsuario usuario = new MenuUsuario(funcionario);
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				
//	-------->   BARRA BÚSQUEDA
//				
				var algo = busquedaController.busquedaMatch(txtBuscar.getText());
				
				cargarTablaHuesped((List<Huesped>) algo.get("Huespedes"));

				cargarTablaReserva((List<Reserva>) algo.get("Reservas"));
				
				txtBuscar.setText("");

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		
		JPanel btnEditar = new JPanel();
//		
//	--------->   EVENTO BOTON EDITAR 
//
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("EDITAR");
				
				if (tbHuespedes.getSelectedColumnCount() > 0 && tbHuespedes.getSelectedRowCount() > 0) {
					
					System.out.println("TABLA HUESPEDES");
					
					Optional.ofNullable(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn())).ifPresentOrElse(fila -> {
						
						try {
							Integer idHuesped = (Integer) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0);
							String nombreHuesped = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1);
							String apellidoHuesped = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2);
							String fechanacimientoHuesped = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 3);
							String nacionalidadHuesped = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4);
							String telefonoHuesped = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5);
							Integer idReservaHuesped = (Integer) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6);
							
							Huesped huespedEditado = new Huesped(
									idHuesped,
									nombreHuesped,
									apellidoHuesped,
									fechanacimientoHuesped,
									nacionalidadHuesped,
									telefonoHuesped,
									idReservaHuesped
									);
							
							boolean respuesta = busquedaController.modifcar(huespedEditado);
							
							if (respuesta) {
								
								
								
								JOptionPane.showMessageDialog(null, "Huesped modificado con éxito");
							}
							
						} catch (Exception e2) {
							
							JOptionPane.showMessageDialog(null, "Seleccione un elemento para modificar, respete el formato del campo.");
							
							e2.printStackTrace();
							throw new RuntimeException(e2);
						}
						
					}, null);

				} else if (tbReservas.getSelectedColumnCount() > 0 && tbReservas.getSelectedRowCount() > 0) {
					System.out.println("TABLA RESERVAS");
						
					Optional.ofNullable(tbReservas.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn())).ifPresentOrElse(fila -> {
						
						try {
							
							Integer idReserva = (Integer) modeloR.getValueAt(tbReservas.getSelectedRow(), 0);
							
							String fechaentrada = (String) modeloR.getValueAt(tbReservas.getSelectedRow(), 1);
							
							String fechasalida = (String) modeloR.getValueAt(tbReservas.getSelectedRow(), 2);
							
							String valorPrecio =  modeloR.getValueAt(tbReservas.getSelectedRow(), 3).toString();
							
							String formapago = (String) modeloR.getValueAt(tbReservas.getSelectedRow(), 4);
							
							Reserva reservaEditada = new Reserva(idReserva, fechaentrada, fechasalida, Double.valueOf(valorPrecio), formapago);
							
							boolean respuesta = busquedaController.modifcar(reservaEditada);
							
							if (respuesta) {
								JOptionPane.showMessageDialog(null, "Reserva modificada con éxito");
							}

						} catch (Exception error) {
							
							JOptionPane.showMessageDialog(null, "Seleccione un elemento para modificar, respete el formato del campo.");
							
							error.printStackTrace();
							throw new RuntimeException(error);
						}

					}, null);
				} else {
					JOptionPane.showMessageDialog(null,  "Debe seleccionar algún item de las tablas Reservas o Huespedes.");
				}

			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
//		
//	----->  EVENTO CLICK BOTON - MOUSE
//		
		btnEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (tbHuespedes.getSelectedColumnCount() > 0 && tbHuespedes.getSelectedRowCount() > 0) {
					
					System.out.println("TABLA HUESPEDES");

					Optional.ofNullable(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn())).ifPresentOrElse(fila -> {
						
						try {
							Integer idHuesped = (Integer) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6);
							
							boolean respuesta = busquedaController.eliminar(idHuesped);
							
							modeloH.removeRow(tbHuespedes.getSelectedRow());
							
							mostrarMensaje = respuesta;
							
							if (respuesta) {
								reloadTablas();
							}
							
						} catch (Exception e2) {
							
							JOptionPane.showMessageDialog(null, "Seleccione un elemento para eliminar.");
							
							e2.printStackTrace();
							throw new RuntimeException(e2);
						}
						
					}, null);

				} else if (tbReservas.getSelectedColumnCount() > 0 && tbReservas.getSelectedRowCount() > 0) {
					System.out.println("TABLA RESERVAS");
						
					Optional.ofNullable(tbReservas.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn())).ifPresentOrElse(fila -> {
						
						try {
							
							Integer idReserva = (Integer) modeloR.getValueAt(tbReservas.getSelectedRow(), 0);
							
							boolean respuesta = busquedaController.eliminar(idReserva);
							
							modeloR.removeRow(tbReservas.getSelectedRow());

							mostrarMensaje = respuesta;
							
							if (respuesta) {
								reloadTablas();
							}

						} catch (Exception error) {
							
							JOptionPane.showMessageDialog(null, "Seleccione un elemento eliminar.");
							
							error.printStackTrace();
							throw new RuntimeException(error);
						}

					}, null);
				} else {
					JOptionPane.showMessageDialog(null,  "Debe seleccionar algún item de las tablas Reservas o Huespedes.");
				}
				
				
				if (mostrarMensaje) {
					
					JOptionPane.showMessageDialog(null,  "Registro eliminados con éxito.");
					mostrarMensaje = false;
				}
				
			}
		});

		
		
		
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
	    xMouse = evt.getX();
	    yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	    int x = evt.getXOnScreen();
	    int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

	
//	
//	Métodos incorporados
	private void cargarTablaHuesped(List<Huesped> lista) {
		
		tbHuespedes.setVisible(false);
		limpiarRowTabla(modeloH);

		lista.forEach(item -> {
			modeloH.addRow(new Object[] {
					item.getId(),
					item.getNombre(),
					item.getApellido(),
					item.getFechanacimiento(),
					item.getNacionalidad(),
					item.getTelefono(),
					item.getIdreserva()
				} );
		});
		tbHuespedes.setVisible(true);
	}
	
	
	private void cargarTablaReserva(List<Reserva> lista) {
		
		tbReservas.setVisible(false);
		limpiarRowTabla(modeloR);
		
		lista.forEach(item -> {
			modeloR.addRow(new Object[] {
					item.getId(),
					item.getFechaentrada(),
					item.getFechasalida(),
					item.getValor(),
					item.getFormapago()
				} );
		});
		tbReservas.setVisible(true);
	}
	
	
	public void limpiarRowTabla(DefaultTableModel modelo) {
		modelo.getDataVector().clear();
	}
	
	public void reloadTablas(List<Reserva> listaReserva, List<Huesped> listaHuesped) {
		cargarTablaReserva(listaReserva);
		cargarTablaHuesped(listaHuesped);
	}
	
	public void reloadTablas() {
		List<Huesped> listaHuespedes = this.busquedaController.datosHuespedes();
		List<Reserva> listaReservas = this.busquedaController.datosReservas();
		cargarTablaReserva(listaReservas);
		cargarTablaHuesped(listaHuespedes);
	}
	
}
