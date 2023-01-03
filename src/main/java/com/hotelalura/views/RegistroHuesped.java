package com.hotelalura.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import com.hotelalura.controller.HuespedController;
import com.hotelalura.controller.ReservaController;
import com.hotelalura.models.Funcionario;
import com.hotelalura.models.Huesped;
import com.hotelalura.models.Reserva;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import java.awt.SystemColor;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import java.sql.Date;
//import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
//import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;


@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {
	
	private ReservaController controllerReserva = null;
	private HuespedController huespedController = null;
	
//	private Integer reservaID;
	private Reserva reservaOBJ;
	

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<Format> txtNacionalidad;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario funcionario = new Funcionario("admin", "admin");
					Reserva unaReserva = new Reserva("2022-10-10", "2022-10-11", 10.1, "Dinero"); 
					RegistroHuesped frame = new RegistroHuesped(unaReserva, funcionario);
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
//	public RegistroHuesped() {
//	public RegistroHuesped(Integer idReserva) {
	public RegistroHuesped(Reserva reserva, Funcionario funcionario) {
		
//		this.reservaID = idReserva;
		
		this.reservaOBJ = reserva;
		this.huespedController = new HuespedController();
		this.controllerReserva = new ReservaController();
	
		JPanel panelCopiarIDReserva, volverMenuPrincipal;
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/com/hotelalura/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//
//  --------->   AL RETORNAR CIERRA Y DESTRUYE EL POOL CREADO.
//				
				
				ReservasView reservas = new ReservasView(funcionario);
				reservas.setVisible(true);
				
				huespedController.closeAndDestroy();
				controllerReserva.closeAndDestroy();
				
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(new Color(12, 138, 199));
			     labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);
		
		txtFechaN = new JDateChooser();
		txtFechaN.setBounds(560, 278, 285, 36);
		txtFechaN.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/com/hotelalura/imagenes/icon-reservas.png")));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaN);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		contentPane.add(txtNacionalidad);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(562, 119, 253, 14);
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(560, 189, 255, 14);
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellido);
		
		JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		lblFechaN.setBounds(560, 256, 255, 14);
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblFechaN);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(562, 406, 253, 14);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);
		
		JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
		lblTitulo.setBounds(606, 55, 234, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblTitulo);
		
		JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
		lblNumeroReserva.setBounds(560, 474, 253, 14);
		lblNumeroReserva.setForeground(SystemColor.textInactiveText);
		lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNumeroReserva);
		
		txtNreserva = new JTextField();
		txtNreserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtNreserva.setFont(new Font("Dialog", Font.BOLD, 16));
		txtNreserva.setBounds(560, 495, 150, 33);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtNreserva.setEditable(false);
		contentPane.add(txtNreserva);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);
		
		
		volverMenuPrincipal = new JPanel();
		volverMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				huespedController.closeAndDestroy();
				controllerReserva.closeAndDestroy();
				
	            MenuUsuario menu = new MenuUsuario(funcionario);
	            menu.setVisible(true);				
				dispose();
			}
		});
		volverMenuPrincipal.setVisible(true);		
		volverMenuPrincipal.setBounds(560, 560, 142, 35);
		volverMenuPrincipal.setBackground(new Color(12, 138, 199));
		contentPane.add(volverMenuPrincipal);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setForeground(Color.WHITE);
		lblMenuPrincipal.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblMenuPrincipal.setBounds(0, 0, 122, 35);
		volverMenuPrincipal.add(lblMenuPrincipal);
		
		
		
		
		panelCopiarIDReserva = new JPanel();
		panelCopiarIDReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//
//   Copiar en Clipboard el ID de reserva
//				
				StringSelection stringSelectionObj = new StringSelection(txtNreserva.toString());
				Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboardObj.setContents(stringSelectionObj, null);
				
				JOptionPane.showMessageDialog(null, "Identificador copiado.");
			}
		});
		panelCopiarIDReserva.setVisible(false);
		panelCopiarIDReserva.setBounds(746, 495, 99, 33);
		panelCopiarIDReserva.setBackground(new Color(12, 138, 199));
		contentPane.add(panelCopiarIDReserva);
		
		JLabel lblCopiar = new JLabel("Copiar");
		lblCopiar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblCopiar.setHorizontalAlignment(SwingConstants.CENTER);
		panelCopiarIDReserva.add(lblCopiar);
		lblCopiar.setForeground(Color.WHITE);

		
		JPanel btnguardar = new JPanel();
		btnguardar.setBounds(723, 560, 122, 35);

//
//		ACA GUARDA REGISTRO
//
		btnguardar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
//
//	------->     GUARDA EL REGISTRO DE 'Reserva' y 'Huesped'
//								
//				System.out.println("GUARDAR");

				if (
					txtNombre.getText() != "" &&
					txtApellido.getText() != "" &&
					txtFechaN.getDate() != null &&
					txtNacionalidad.getSelectedItem() != "" &&
					txtTelefono.getText() != "" &&
					txtNreserva.getText() != ""
					) {
					
						String nombre = txtNombre.getText();
						String apellido = txtApellido.getText();
						
						SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						String dateNacimiento = formato.format(txtFechaN.getDate());
						
						String nacionalidad = txtNacionalidad.getSelectedItem().toString();
						String telefono = txtTelefono.getText();
						
						
						
						try {
							
							Integer idReserva = controllerReserva.guardar(reserva);
							
							Huesped huesped = new Huesped(
									nombre, 
									apellido, 
									dateNacimiento.toString(), 
									nacionalidad, 
									telefono, 
									idReserva
								);
							
							boolean saved = huespedController.guardar(huesped);
							
							if (saved) {
								
								panelCopiarIDReserva.setVisible(true);
								
								txtNreserva.setText(idReserva.toString());
	
								JOptionPane.showMessageDialog(null, "Reserva registrada exitosamente.");
								
								
//					            MenuUsuario menu = new MenuUsuario();
//					            menu.setVisible(true);
//								
//								dispose();
							}
							
						} catch (Exception err) {
							err.printStackTrace();
							throw new RuntimeException(err);
						}
						
						
				} else {
					JOptionPane.showMessageDialog(null, "Complete los campos del formulario.");
				}
				
			}
		});
//
//		
//		
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnguardar);
		btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnguardar.add(labelGuardar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/com/hotelalura/imagenes/registro.png")));
		
		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/com/hotelalura/imagenes/Ha-100px.png")));
		
		JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		contentPane.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.white);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel lblVolverMenu = new JLabel("Menu Principal");
		lblVolverMenu.setBounds(560, 573, 130, 22);
		contentPane.add(lblVolverMenu);
		lblVolverMenu.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblVolverMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolverMenu.setForeground(Color.WHITE);

		
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
}
