package ui.panels;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import java.awt.BorderLayout;

public class AbrirMapsPanel extends JFrame {

	/**
	 * Create the panel.
	 */
	public AbrirMapsPanel() {
		setLayout(new BorderLayout(0, 0));
		JFXPanel jfxPanel = new JFXPanel();
		jfxPanel.setLayout(new BorderLayout(0,0));
		this.add(jfxPanel);
		
		Platform.runLater(() -> {
			WebView webView = new WebView();
			jfxPanel.setScene(new Scene(webView));
			webView.getEngine().load("http://www.stackoverflow.com/");
		});
	}
}
