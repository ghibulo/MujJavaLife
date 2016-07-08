// Ukazka kresleni car primo na panel.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

// Tato trida je rozsirenim tridy JPanel. Trida
// prekryva metodu paintComponent(), a to tak, ze do panelu
// jsou vykreslovany nahodne vygenerovane cary.
class PaintPanel extends JPanel implements ActionListener{
        
        // Do teto promenne budou ulozeny sirky jednotlivych hranic.
        Insets ins;
        
        // Tato promenna bude vyuzita ke generovani nahodnych cisel.
        Random rand;
        private Timer timer;
        private PoleBunek mojePole;
        private boolean odTimeru;
        
        
        
        

        // Konstruktor panelu.
        PaintPanel() {
                
                // Nastaveni hranice okolo panelu.
                //setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                rand = new Random();
                mojePole = new PoleBunek();
                
                timer = new Timer(4000, this);
                timer.start();
                odTimeru=false;
                
        }

        // Prekryti metody paintComponent().
        protected void paintComponent(Graphics g) {

                // Vzdy je nutne nejprve zavolat metodu nadtridy.
                super.paintComponent(g);
                                // Nacteni vysky a sirky komponenty.
                int height = getHeight();
                int width = getWidth();

                // Nacteni sirek hranic.
                ins = getInsets();
                int krok = Math.min((width-ins.left)/20,(height-ins.bottom)/20);
                int strana = 20*krok;
                
                mojePole.nastavVelikost(krok);
                mojePole.kresli(g,odTimeru);
                odTimeru = false;
                //if (!(timer.isRunning())) g.drawString("Pauza",10,10);
             }
                
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
           String zprava= e.getActionCommand();
           if (zprava==null) {
               odTimeru=true;
               repaint();
           } else {
               JButton kdo=(JButton)(e.getSource());
               if (zprava.equals("Pauza")) {
                   if (timer.isRunning()) {
                       timer.stop(); 
                       kdo.setText("Start");
                    }
                    else {
                        timer.start();
                        kdo.setText("Pauza");
                    }
               }
           
           }
        }
}