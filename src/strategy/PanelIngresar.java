package strategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.*;

public class PanelIngresar extends JPanel {
    private JLabel lblTexto;
    private JTextArea txtTexto;
    private JScrollPane scrollPane;
    private Main principal;
    private String[] algorithmOptions = { "Seleccione un sort", "BubbleSort", "QuickSort", "HeapSort" };
    private JComboBox algorithm;
    
    public PanelIngresar(Main principal) {
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
        txtTexto.setToolTipText("Ingrese un conjunto de números separados por espacios, comas, puntos o nuevas lineas");
        txtTexto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if(((caracter < '0') || (caracter > '9')) && (caracter != '\b') 
                        && (caracter != ' ') && (caracter != '\n')
                        && (caracter != '.') && (caracter != ',')) e.consume(); 
            }
        });
        
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
