package ui;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.panels.BuscaInformacaoPanel;
import ui.panels.EmptyPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel {

	private JFrame frmInfocepServio;
	private Integer selectedPanelId = 0;

	private static ArrayList<JPanel> panels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		panels = new ArrayList<JPanel>(2);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
					window.frmInfocepServio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPanel() throws ParseException {
		initialize();
	}

	/**
	 * Add all the panels to the component
	 * 
	 * @throws ParseException
	 */
	private void addPanelScreens() throws ParseException {
		panels.add(new BuscaInformacaoPanel());
		panels.add(new EmptyPanel());

		for (int i = 0; i < 2; i++) {
			panels.get(i).setBounds(241, 11, 450, 284);
			panels.get(i).setVisible(false);
			frmInfocepServio.getContentPane().add(panels.get(i));
		}

		panels.get(selectedPanelId).setVisible(true);
	}

	private void setPanel(int index) {
		panels.get(selectedPanelId).setVisible(false);
		panels.get(index).setVisible(true);
		this.selectedPanelId = index;
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize() throws ParseException {
		frmInfocepServio = new JFrame();
		frmInfocepServio.setTitle("InfoCEP - Servi\u00E7o de Busca de CEPs");
		frmInfocepServio.setBounds(100, 100, 850, 355);
		frmInfocepServio.setMinimumSize(new Dimension(850, 355));
		frmInfocepServio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInfocepServio.getContentPane().setLayout(null);

		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 170, 317);
		panel.setBackground(Color.LIGHT_GRAY);
		frmInfocepServio.getContentPane().add(panel);
		panel.setLayout(null);

		final JButton btnNewButton = new JButton("Informa\u00E7\u00E3o");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(0);
			}
		});

		btnNewButton.setBounds((int) (panel.getWidth() * 0.1), 11, 105, 35);
		panel.add(btnNewButton);

		final JButton btnNewButton_1 = new JButton("Vazio");

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(1);
			}
		});

		btnNewButton_1.setBounds((int) (panel.getWidth() * 0.1), 67, 105, 35);
		panel.add(btnNewButton_1);

		addPanelScreens();

		frmInfocepServio.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.setBounds(0, 0, (int) (frmInfocepServio.getWidth() * 0.15), frmInfocepServio.getHeight() - 38);
			}
		});

		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				btnNewButton.setBounds((int) (panel.getWidth() * 0.1), 11, 105, 35);
				btnNewButton_1.setBounds((int) (panel.getWidth() * 0.1), 67, 105, 35);
			}
		});
	}
}
