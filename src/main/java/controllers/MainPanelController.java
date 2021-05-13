package controllers;

import ui.panels.AbrirMapsPanel;
import ui.panels.BuscaInformacaoPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPanelController {
    private List<JPanel> panels;
    private Integer selectedId = 0;

    public static JButton abrirMapsButton;
    public static JButton informacoesButton;

    public MainPanelController() {
        panels = Arrays.asList();
    }

    public List<JPanel> getPanels() {
        return panels;
    }

    public void setPanels(List<JPanel> panels) {
        this.panels = panels;
    }

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public void togglePanelUsability(Integer panelPosition) {
        if(panelPosition > panels.size())
            return;

        panels.get(selectedId).setVisible(false);
        panels.get(panelPosition).setVisible(true);
        this.selectedId = panelPosition;
    }

    public void openMapsPanel() {
        JFrame maps = new AbrirMapsPanel(BuscaInformacaoPanelController.getLocalizacaoResult());
        maps.setSize(700, 400);
        maps.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        maps.setVisible(true);
    }
}
