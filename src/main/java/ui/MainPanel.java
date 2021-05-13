package ui;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.MainPanelController;
import ui.panels.BuscaInformacaoPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collections;

import javax.swing.JButton;

public class MainPanel {
    private JFrame frmInfocepServio;
    MainPanelController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new MainPanel().frmInfocepServio.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainPanel() throws ParseException {
        controller = new MainPanelController();
        initialize();
    }

    private void addPanelScreens() throws ParseException {
        controller.setPanels(Collections.singletonList(new BuscaInformacaoPanel()));

        for (JPanel panel : controller.getPanels()) {
            panel.setBounds((int) (frmInfocepServio.getWidth() * .37), (int) (frmInfocepServio.getHeight() * .3) - 90, 450, 284);
            panel.setVisible(false);
            frmInfocepServio.getContentPane().add(panel);
        }
        controller.getPanels().get(controller.getSelectedId()).setVisible(true);
    }

    private void openMapsWindow() {
        controller.openMapsPanel();
    }

    private void initialize() throws ParseException {
        frmInfocepServio = new JFrame();
        frmInfocepServio.setTitle("InfoCEP - Serviço de Busca de CEPs");
        frmInfocepServio.setBounds(100, 100, 850, 355);
        frmInfocepServio.setMinimumSize(new Dimension(850, 355));
        frmInfocepServio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmInfocepServio.getContentPane().setLayout(null);

        final JPanel panel = new JPanel();
        panel.setBounds(0, 0, 170, frmInfocepServio.getHeight() - 18);
        panel.setBackground(Color.LIGHT_GRAY);
        frmInfocepServio.getContentPane().add(panel);
        panel.setLayout(null);

        MainPanelController.informacoesButton = new JButton("Informações");
        MainPanelController.informacoesButton.addActionListener(_e -> controller.togglePanelUsability(0));
        MainPanelController.informacoesButton.setBounds(18, 11, 130, 35);
        panel.add(MainPanelController.informacoesButton);

        MainPanelController.abrirMapsButton = new JButton("Abrir Maps");
        MainPanelController.abrirMapsButton.addActionListener(_e -> openMapsWindow());
        MainPanelController.abrirMapsButton.setBounds(18, 57, 130, 35);
        MainPanelController.abrirMapsButton.setEnabled(false);
        panel.add(MainPanelController.abrirMapsButton);

        addPanelScreens();

        frmInfocepServio.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.setBounds(0, 0, 170, frmInfocepServio.getHeight() - 18);
                controller.getPanels().forEach(p -> p.setBounds((int) (frmInfocepServio.getWidth() * .37), (int) (frmInfocepServio.getHeight() * .3) - 90, 450, 284));
            }
        });
    }
}
