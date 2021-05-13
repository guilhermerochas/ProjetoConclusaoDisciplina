package ui.panels;

import com.google.gson.Gson;
import controllers.BuscaInformacaoPanelController;
import controllers.MainPanelController;
import models.LocalizacaoResult;
import services.LocalizaServiceMock;

import javax.swing.*;
import java.awt.Font;
import java.text.ParseException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.swing.text.MaskFormatter;

public class BuscaInformacaoPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JFormattedTextField textField;
	private JTextPane textPane;
	private JButton btnBuscarInfoCep;

	public BuscaInformacaoPanelController controller;


	public BuscaInformacaoPanel() throws ParseException {
		controller = new BuscaInformacaoPanelController(new LocalizaServiceMock());

		this.setLayout(null);
		this.createLayout();

		textField.setFocusable(true);
		textField.requestFocusInWindow();

		this.setButtonListener();
	}

	private void createLayout() throws ParseException {
		MaskFormatter cepMask = new MaskFormatter("#####-###");

		// Layout Fields
		JLabel lblNewLabel = new JLabel("Buscar: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 26, 69, 19);
		add(lblNewLabel);

		textField = new JFormattedTextField();
		textField.setToolTipText("Use algo como: 0000-000");
		textField.setColumns(10);
		textField.setBounds(99, 26, 208, 23);
		cepMask.install(textField);
		add(textField);

		JLabel lblResultadoDaBusca = new JLabel("Resultado da Busca ");
		lblResultadoDaBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultadoDaBusca.setBounds(140, 68, 155, 19);
		add(lblResultadoDaBusca);

		textPane = new JTextPane();
		textPane.setBounds(31, 98, 375, 176);
		add(textPane);

		btnBuscarInfoCep = new JButton("buscar");
		btnBuscarInfoCep.setBounds(317, 26, 89, 23);
		add(btnBuscarInfoCep);
	}

	private void setButtonListener() {
		btnBuscarInfoCep.addActionListener(_e -> {
			CompletableFuture.runAsync(() -> {
				Optional<String> result = controller.localizarInformacaoCEP(textField.getText());
				result.ifPresentOrElse(textValue -> {
					BuscaInformacaoPanelController.setLocalizacaoResult(new Gson().fromJson(textValue, LocalizacaoResult.class));
					textPane.setText(BuscaInformacaoPanelController.getLocalizacaoResult().toString());
					MainPanelController.abrirMapsButton.setEnabled(true);
				}, () -> {
					JOptionPane.showMessageDialog(null, "Não foi possível retornar o resultado");
					MainPanelController.abrirMapsButton.setEnabled(false);
				});
			});
		});
	}
}
