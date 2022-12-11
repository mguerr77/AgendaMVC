package vistaEscritorio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import modelo.Contacto;
import modelo.Provincia;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
public class GrabarContacto {

	private JFrame frame;
	private JTextField vNombre;
	private JTextField vLocalidad;
	private JTextField vTelefono;
	private JComboBox vCodProv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrabarContacto window = new GrabarContacto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GrabarContacto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Contacto nuevoContacto = new Contacto();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// --- nombre
		vNombre = new JTextField();
		
		vNombre.setBounds(105, 27, 96, 20);
		frame.getContentPane().add(vNombre);
		vNombre.setColumns(10);
		vNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (vNombre.getText().length() > 0)
				{
				nuevoContacto.setNombre(vNombre.getText());
				}
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(33, 30, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		// ---- edad
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(33, 61, 49, 14);
		frame.getContentPane().add(lblEdad);
		JSpinner vEdad = new JSpinner();
		vEdad.setBounds(105, 58, 30, 20);
		frame.getContentPane().add(vEdad);
		vEdad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				nuevoContacto.setEdad( (Integer) vEdad.getValue()) ;
			}
		});
		
		
		vLocalidad = new JTextField();
		vLocalidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (vLocalidad.getText().length() > 0)
				{
					nuevoContacto.setLocalidad(vLocalidad.getText());
				}
			}
		});
		vLocalidad.setColumns(10);
		vLocalidad.setBounds(105, 89, 96, 20);
		frame.getContentPane().add(vLocalidad);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(33, 92, 49, 14);
		frame.getContentPane().add(lblLocalidad);
		
		
		
		vTelefono = new JTextField();
		vTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (vTelefono.getText().length() > 0)
				{
					nuevoContacto.setTelefono(vTelefono.getText());
				}
			}
		});
		vTelefono.setColumns(10);
		vTelefono.setBounds(105, 120, 96, 20);
		frame.getContentPane().add(vTelefono);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(33, 123, 49, 14);
		frame.getContentPane().add(lblTelfono);
		
		vCodProv = new JComboBox();
		vCodProv.setBounds(105, 151, 96, 20);
		frame.getContentPane().add(vCodProv);
		vCodProv.addItem();		
		
		JLabel lblTipoTelfono = new JLabel("Código Provincia");
		lblTipoTelfono.setBounds(34, 154, 70, 14);
		frame.getContentPane().add(lblTipoTelfono);
		
		JRadioButton vMovil = new JRadioButton("Móvil");
		vMovil.setBounds(216, 119, 63, 23);
		frame.getContentPane().add(vMovil);
		
		JRadioButton vFijo = new JRadioButton("Fijo");
		vFijo.setBounds(281, 119, 63, 23);
		frame.getContentPane().add(vFijo);
		
		JButton Grabar = new JButton("Grabar");
		Grabar.setBounds(112, 201, 89, 23);
		frame.getContentPane().add(Grabar);
		
		
	}
}
