package ui.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class EmptyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EmptyPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("This panel is empty...");
		lblNewLabel.setBounds(175, 135, 165, 14);
		add(lblNewLabel);

	}

}
