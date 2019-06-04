package listener.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import control.ParaUI;
import modelo.Paciente;

public class ActionItemModificarPaciente implements ActionListener {

	ParaUI paraUI;

	public ActionItemModificarPaciente(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getModificarPaciente().vaciarCampos();
		this.paraUI.rellenarComboBoxPaciente(this.paraUI.getModificarPaciente().getComboBoxID(),
				this.paraUI.getModificarPaciente().getComboBoxNombre());
		this.paraUI.asociarPanel("modificarPaciente");
	}
}
