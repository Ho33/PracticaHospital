package vista.paciente;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;

public class AltaPaciente extends JPanel {

	private String[] label = { "Nombre :", "Apellidos :", "Direccion :", "Nacimiento :", "Telefono :" };
	private JTextField[] fields = new JTextField[this.label.length];
	private JPanel panelLabel = new JPanel();
	private JPanel panelText = new JPanel();
	private JButton btnAceptar;
	private JLabel mensajeSistema;

	public AltaPaciente(Color color, int letraPequena, int letraGrande, String tipoLetra) {
		setVisible(true);
		setBackground(color);

		JLabel lblNewLabel = new JLabel("Alta Paciente");
		lblNewLabel.setFont(new Font(tipoLetra, Font.BOLD, letraGrande));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		mensajeSistema = new JLabel("Mensaje del sistema");
		mensajeSistema.setHorizontalAlignment(SwingConstants.LEFT);
		mensajeSistema.setFont(new Font("Consolas", Font.PLAIN, 15));

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font(tipoLetra, Font.BOLD, letraPequena));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(30)
				.addComponent(panelLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelText, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addComponent(mensajeSistema, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAceptar,
												GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
				.addGap(30)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(20)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
						.addComponent(panelText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(mensajeSistema, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
				.addContainerGap()));
		panelLabel.setBackground(Color.WHITE);
		panelText.setBackground(Color.WHITE);
		panelText.setLayout(new GridLayout(1, 0, 0, 0));
		panelLabel.setLayout(new GridLayout(1, 0, 0, 0));
		setLayout(groupLayout);
		creandoVista(letraPequena, tipoLetra);
		setVisible(true);
	}

	public void vaciarCampos() {
		for (int i = 0; i < fields.length; i++) {
			this.fields[i].setText(null);
		}
	}

	public ArrayList<String> getInfoPaciente() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < fields.length; i++) {
			list.add(this.fields[i].getText());
		}
		return list;
	}

	private void creandoVista(int letraPequena, String tipoLetra) {
		Color color = new Color(133, 200, 255);
		this.panelLabel.setBackground(color);
		this.panelText.setBackground(color);
		setBackground(color);
		this.fields = new JTextField[this.label.length];
		panelText.setLayout(new GridLayout(this.label.length, 1, 30, 80));
		panelLabel.setLayout(new GridLayout(this.label.length, 1, 10, 80));
		for (int i = 0; i < fields.length; i++) {
			this.fields[i] = crearJText(letraPequena, tipoLetra);
			this.panelLabel.add(crearLabel(this.label[i], letraPequena, tipoLetra));
			this.panelText.add(this.fields[i]);
		}
		revalidate();
	}

	private JTextField crearJText(int letraPequena, String tipoLetra) {
		JTextField field = new JTextField();
		field.setText("");
		field.setFont(new Font(tipoLetra, Font.BOLD, letraPequena));
		field.setHorizontalAlignment(SwingConstants.LEFT);
		field.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		return field;
	}

	private JLabel crearLabel(String cadena, int letraPequena, String tipoLetra) {
		JLabel jLabel = new JLabel();
		jLabel.setText(cadena);
		jLabel.setFont(new Font(tipoLetra, Font.BOLD, letraPequena));
		jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		return jLabel;
	}

	public JTextField[] getFields() {
		return fields;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JLabel getMensajeSistema() {
		return mensajeSistema;
	}

}
