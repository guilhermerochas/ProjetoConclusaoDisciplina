package ui.panels;

import controllers.AbrirMapsPanelController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import models.LocalizacaoResult;
import utils.SwingUtils;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.concurrent.CompletableFuture;

public class AbrirMapsPanel extends JFrame {
	AbrirMapsPanelController controller;

	public AbrirMapsPanel(LocalizacaoResult result) throws Exception {
		controller = new AbrirMapsPanelController(result);

		setLayout(new BorderLayout(0, 0));
		JFXPanel jfxPanel = new JFXPanel();
		jfxPanel.setLayout(new BorderLayout(0,0));
		this.add(jfxPanel);

		configMenuContext();
		Platform.runLater(() -> controller.AbrirMaps(result, jfxPanel));
	}

	private void configMenuContext() {
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu optionsMenu = new JMenu("Opções");
		JMenuItem salvarMenuItem = new JMenuItem("Salvar");

		salvarMenuItem.addActionListener(_a -> {
			CompletableFuture.runAsync(() -> {
				try {
					controller.salvarLocalizacao();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			});
		});

		optionsMenu.add(salvarMenuItem);
		menuBar.add(optionsMenu);
	}
}
