package strategy;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelIngresar extends JPanel {
    private JLabel lblTexto;
    private JTextArea txtTexto;
    private JScrollPane scrollPane;
    private String texto;
    private Strategy principal;
    private String[] algorithmOptions = { "Seleccione un sort", "BubbleSort", "QuickSort", "HeapSort" };
    private JComboBox algorithm;
    
    public PanelIngresar(Strategy principal) {
        this.principal = principal;
        
        setBackground(Color.decode("#FFFFFF"));
        setLayout(null);
        setPreferredSize(new Dimension(0, 100));

        TitledBorder border = BorderFactory.createTitledBorder("Ingreso de números");
        setBorder(border);
        
        lblTexto = new JLabel ("Ingresar números:");
        lblTexto.setBounds(40, 30, 120, 30);
        
        algorithm = new JComboBox(algorithmOptions);
        algorithm.setSelectedIndex(0);
        algorithm.setBounds(35, 60, 140, 30);
        
        txtTexto = new JTextArea();
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(txtTexto);
        scrollPane.setBounds(180, 30, 300, 80);
        
        add(lblTexto);
        add(scrollPane);
        add(algorithm);
    }
    
    public String getTexto() {
        return txtTexto.getText();
    }
    
    public String getAlgorithm(){
        return algorithm.getSelectedItem().toString();
    }
    
    public void limpiar() {
        txtTexto.setText("");
        txtTexto.setEnabled(true);
        algorithm.setSelectedIndex(0);
    }
}
