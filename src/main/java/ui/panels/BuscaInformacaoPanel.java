package ui.panels;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

public class BuscaInformacaoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFormattedTextField textField;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public BuscaInformacaoPanel() throws ParseException {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 26, 69, 19);
		add(lblNewLabel);
		
		MaskFormatter cepMask = new MaskFormatter("#####-###");
		
		textField = new JFormattedTextField();
		textField.setToolTipText("Use algo como: 0000-000");
		textField.setColumns(10);
		textField.setBounds(99, 26, 208, 23);
		cepMask.install(textField);
		add(textField);
		
		JLabel lblResultadoDaBusca = new JLabel("Resultado da Busca ");
		lblResultadoDaBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultadoDaBusca.setBounds(140, 68, 133, 19);
		add(lblResultadoDaBusca);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(31, 98, 375, 176);
		add(textPane);
		
		JButton btnBuscarInfoCep = new JButton("buscar");
		btnBuscarInfoCep.setBounds(317, 26, 89, 23);
		add(btnBuscarInfoCep);
		
	}

}
