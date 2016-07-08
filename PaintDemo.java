import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class PaintDemo extends JFrame {
        JLabel jlab;
        PaintPanel pp;

        PaintDemo() {
                
                // Vytvoreni noveho kontejneru typu JFrame.
                //JFrame jfrm = new JFrame("Můj vlastní 'LIFE'");
                super("Můj vlastní Life");
                // Nastaveni pocatecni velikosti okna.
                
                //setLayout(new FlowLayout(FlowLayout.LEFT));

                // Ukonceni programu ve chvili, kdy uzivatel uzavre okno.
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                
                //MyPanel.setPreferredSize(new Dimension(400,400));
                //MyPanelsetLayout( new FlowLayout() );
                // Vytvoreni panelu, do nehoz bude provadeno kresleni.
                pp = new PaintPanel();
                JButton btPause = new JButton("Pauza");
                btPause.setActionCommand("Pauza");
                btPause.addActionListener(pp);
                

                // Pridani panelu na plochu obsahu. Jelikoz je pouzit
                // vychozi spravce rozvrzeni typu BorderLayout, panel bude
                // automaticky vlozen do stredove oblasti.
                //pp.setPreferredSize(new Dimension(400,400));
                add(pp, BorderLayout.CENTER);
                add(btPause, BorderLayout.SOUTH);
                //add(new JButton("ahoj"), BorderLayout.WEST);

                //getContentPane().add(MyPanel);
                //getContentPane().add(btPause);
                // Zobrazeni okna.
                setSize(700, 700);
                setVisible(true);
        }

        @Override
        public Insets getInsets() {
          return new Insets(30,10,10,10);
        }
        public static void main(String args[]) {
                
                // Vytvoreni okna ve vlaknu pro rozesilani udalosti.
                SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                                new PaintDemo();
                        }
                });
        }
}
