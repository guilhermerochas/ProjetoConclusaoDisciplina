package ui.panels;

import controllers.ListaLocalizacoesPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ListaLocalizacoesPanel extends JPanel {

    public ListaLocalizacoesPanel() throws Exception {
        ListaLocalizacoesPanelController controller = new ListaLocalizacoesPanelController();
        setLayout(new BorderLayout(0, 0));

        JList listItems = new JList(controller.getListModel());
        listItems.setLayoutOrientation(JList.VERTICAL);
        listItems.setFixedCellHeight(50);
        listItems.setFixedCellWidth(100);

        listItems.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList aux = (JList) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = aux.locationToIndex(e.getPoint());
                    int confirmarImpressao = JOptionPane.showConfirmDialog(null,
                            "Deseja imprimir a localização de cep: " +
                                    controller.obterLocalizacao(index).getCep());

                    if (confirmarImpressao == 0) {
                        CompletableFuture.runAsync(() -> {
                            try {
                                Optional<URI> result = controller.ImprimirLocalizacaoCep(index);
                                result.ifPresentOrElse(r -> {
                                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                                        try {
                                            Desktop.getDesktop().browse(r);
                                        } catch (IOException ioException) {
                                            JOptionPane.showMessageDialog(null, "Não foi possivel baixar a localização");
                                        }
                                    }
                                }, () -> JOptionPane.showMessageDialog(null, "Não foi possivel imprimir a Localização :("));
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                        });
                    }
                }
            }
        });

        Button obterDados = new Button("Recarregar Lista");
        obterDados.addActionListener(_e -> CompletableFuture.runAsync(() -> {
            try {
                controller.recarregarLista();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }));

        add(new JScrollPane(listItems), BorderLayout.CENTER);
        add(obterDados, BorderLayout.PAGE_END);
    }
}
