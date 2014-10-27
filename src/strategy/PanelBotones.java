package strategy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelBotones extends JPanel implements ActionListener
{
    private final static String ORDENAR = "ordenar";
    private final static String LIMPIAR = "limpiar";
    
    private JButton btnOrdenar;
    private JButton btnLimpiar;
    private Main principal;

    public PanelBotones(Main principal)
    {
        setBackground(Color.decode("#FFFFFF"));
        setLayout(new GridLayout(0, 2));
        setPreferredSize(new Dimension(0, 75));

        TitledBorder border = BorderFactory.createTitledBorder("Botones");
        setBorder(border);
        
        btnOrdenar = new JButton("Ordenar");
        btnLimpiar = new JButton("Limpiar");
        
        add(btnOrdenar);
        add(btnLimpiar);
        
        btnOrdenar.setActionCommand(ORDENAR);
        btnLimpiar.setActionCommand(LIMPIAR);
        
        btnOrdenar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        
        btnOrdenar.setToolTipText("Ingrese un conjunto de numeros");
        btnLimpiar.setToolTipText("Ordenar nuevo conjunto de numeros");
        
        this.principal = principal;
    }

    public void actionPerformed(ActionEvent evento){
        String comando = evento.getActionCommand(); 
        
        if (comando.equals(ORDENAR)) {
            principal.Ordenar();
        } else if (comando.equals(LIMPIAR)) {
            principal.Limpiar();
        }
    }
}