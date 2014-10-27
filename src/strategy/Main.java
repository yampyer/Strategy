package strategy;

import javax.swing.*; 
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JFrame {
    
    private PanelOutput panelOutput;
    private PanelIngresar panelIngresar;
    private PanelBotones panelBotones;
    private Context context;
    private int n;
    private int [] arr;
      
    public Main() { 
        setTitle("Strategy");
        setSize(555, 445);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#FFFFFF"));
         
         panelIngresar = new PanelIngresar(this);
         panelIngresar.setBounds(5, 0, 540, 130);
         
         panelBotones = new PanelBotones(this);
         panelBotones.setBounds(5, 135, 540, 70);
         
         panelOutput = new PanelOutput(this);
         panelOutput.setBounds(5, 210, 540, 200);
         
         add(panelOutput);
         add(panelIngresar);
         add(panelBotones);
         
         panelOutput.setVisible(true);
         panelIngresar.setVisible(true);
         panelBotones.setVisible(true);
    }
  
    public void Limpiar(){
        panelOutput.limpiar();
        panelIngresar.limpiar();
    }
    
    public String[] SplitText(String cadena) {
        return cadena.split("\\W+");
    }
    
    public boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    }  
    
    public void Input(String Text) {
        ArrayList <String> entry = new ArrayList <> (Arrays.asList(SplitText(Text)));
        n = entry.size();
        arr = new int [n];
        for(int i=0; i<entry.size(); ++i) arr[i] = Integer.parseInt(entry.get(i));
    }
    
    public void Ordenar(){
        panelOutput.limpiar();
        if(panelIngresar.getTexto().equals("") 
                || panelIngresar.getAlgorithm().equals("Seleccione un sort")) {
            JOptionPane.showMessageDialog(null, "Por favor digite un conjunto"
                + " de números o seleccione un tipo de sort", "Strategy",
                JOptionPane.WARNING_MESSAGE);
        }
        else {
            if(isNumeric(panelIngresar.getTexto().substring(0, 1))) {
                String concretStrategy = panelIngresar.getAlgorithm();
                Input(panelIngresar.getTexto());
                if(concretStrategy.equals("BubbleSort")) context = new Context(new BubbleSort());
                else if (concretStrategy.equals("QuickSort")) context = new Context(new QuickSort());
                else if (concretStrategy.equals("HeapSort")) context = new Context(new HeapSort());
                panelIngresar.limpiar();
                panelOutput.print(context.executeStrategy(n,arr));
            } else JOptionPane.showMessageDialog(null, "Por favor inicie con"
                + " un número", "Strategy",
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main (String args[]) { 
        Main ventana = new Main();
        ventana.setVisible(true);
    } 
} 