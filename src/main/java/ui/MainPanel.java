package ui;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

import controllers.MainPanelController;
import ui.panels.BuscaInformacaoPanel;
import ui.panels.ListaLocalizacoesPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;

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

    public MainPanel() throws Exception {
        controller = new MainPanelController();
        initialize();
    }

    private void addPanelScreens() throws Exception {
        controller.setPanels(Arrays.asList(new BuscaInformacaoPanel(), new ListaLocalizacoesPanel()));

        for (int i = 0; i < controller.getPanels().size(); i++) {
            controller.getPanels().get(i).setBounds(i == 0 ? 300 : 170, 2, frmInfocepServio.getWidth() - 170, 315);
            controller.getPanels().get(i).setVisible(false);
            frmInfocepServio.getContentPane().add(controller.getPanels().get(i));
        }
        controller.getPanels().get(controller.getSelectedId()).setVisible(true);
    }

    private void openMapsWindow() throws Exception {
        controller.openMapsPanel();
    }

    private void initialize() throws Exception {
        frmInfocepServio = new JFrame();
        frmInfocepServio.setTitle("InfoCEP - Serviço de Busca de CEPs");
        frmInfocepServio.setBounds(100, 100, 850, 355);
        frmInfocepServio.setResizable(false);
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
        MainPanelController.informacoesButton.setBounds(18, 10, 130, 35);
        panel.add(MainPanelController.informacoesButton);

        MainPanelController.abrirMapsButton = new JButton("Abrir Maps");
        MainPanelController.abrirMapsButton.addActionListener(_e -> {
            try {
                openMapsWindow();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possivel abrir a tela de Maps");
            }
        });
        MainPanelController.abrirMapsButton.setBounds(18, 55, 130, 35);
        MainPanelController.abrirMapsButton.setEnabled(false);
        panel.add(MainPanelController.abrirMapsButton);

        MainPanelController.localizacoesItensButton = new JButton("CEPs Salvos");
        MainPanelController.localizacoesItensButton.addActionListener(_e -> controller.togglePanelUsability(1));
        MainPanelController.localizacoesItensButton.setBounds(18, 100, 130, 35);
        panel.add(MainPanelController.localizacoesItensButton);

        addPanelScreens();
    }
}
