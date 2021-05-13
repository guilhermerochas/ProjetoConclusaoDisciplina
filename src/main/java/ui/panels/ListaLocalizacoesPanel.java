package ui.panels;

import repository.FirebaseRepositoryMock;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ListaLocalizacoesPanel extends JPanel {
    public ListaLocalizacoesPanel() throws Exception {
        setLayout(new BorderLayout(0, 0));

        List<String> localizacoes = new FirebaseRepositoryMock().obterLocalizacoes()
                                        .stream().map(e -> "  " + e.toString())
                                        .collect(Collectors.toList());

        JList listItems = new JList(localizacoes.toArray());
        listItems.setLayoutOrientation(JList.VERTICAL);
        listItems.setFixedCellHeight(50);
        listItems.setFixedCellWidth(100);
        add(listItems);
    }
}
