package strategy;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelOutput extends JPanel {
    
    private JTextArea resultado = new JTextArea();
    private String res;
    private JScrollPane scrollPanell = new JScrollPane();
    private Main principal;
    
    public PanelOutput(Main principal){
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        TitledBorder border = BorderFactory.createTitledBorder("Output");
        setBorder(border);
        
        res = "";
        resultado.setEditable(false);
        scrollPanell.setViewportView(resultado);
        add(scrollPanell, BorderLayout.CENTER);
        repaint();
        this.principal = principal;
    }

    public void limpiar() {
        resultado.setText("");
    }
    
    public void print (String node) {
        resultado.setText(node);
        repaint(); 
    }
}