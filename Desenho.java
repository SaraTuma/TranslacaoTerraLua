package solterralua;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author : Sara Tuma
 * Estudante: Universidade Católica de Angola
 * Ano: 3º ( Primeiro semestre )
 * Disciplina: Computação Grafica
 * 2020
 */
public class Desenho extends JPanel implements Runnable{
    Objecto terra = new Objecto("Terra.png",150,250,60,60);
    Objecto lua = new Objecto("lua.png",75,200,45,45);
    Objecto sol = new Objecto("sol.png",300,300,120,120);
    Objecto espaco ;
    Thread t = new Thread(this);
    
    private int terraAngulo=0;
    private int luaAngulo=0;
    
    public Desenho(){
        
        JFrame f = new JFrame();
        f.setSize(850,700);
        f.setTitle("Movimento de translação");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        this.setSize(850,700);
        espaco = new Objecto("imagemFundo.jpg",0,0,this.getWidth(),this.getHeight());
        f.add(this);
        t.start();
        f.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
             RenderingHints.KEY_ANTIALIASING,
             RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        //Colocando a imagem de fundo
        g2.drawImage(espaco.getImg(), espaco.getPosx(), espaco.getPosy(), espaco.getLargura(), espaco.getAltura(), this);
        //Desenhando o sol sem animação ou rotate
        g2.drawImage(sol.getImg(), sol.getPosx(), sol.getPosy(), sol.getLargura(), sol.getAltura(), this);
        //Esta rotação afecta a terra e a lua
        g2.rotate(Math.toRadians(terraAngulo),sol.getPosx()+(sol.getLargura()/2),sol.getPosy()+(sol.getAltura()/2));
        //Desenhando a terra
        g2.drawImage(terra.getImg(), terra.getPosx(), terra.getPosy(), terra.getLargura(), terra.getAltura(), this);
        //Animação para fazer a lua translatar em volta da terra
        g2.rotate(Math.toRadians(luaAngulo),terra.getPosx()+(terra.getLargura()/2),terra.getPosy()+(terra.getAltura()/2));
        //Desenhando a lua
        g2.drawImage(lua.getImg(), lua.getPosx(), lua.getPosy(), lua.getLargura(), lua.getAltura(), this);
    }
    
    private void dormir(){
        try {
            this.t.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(Desenho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actualizar() { // Alterando os valores dos Ângulos a cada interação
        this.terraAngulo = (int) (this.terraAngulo >= 360 ? 0 : 1 + this.terraAngulo);
        this.luaAngulo = (int) (this.luaAngulo >= 360 ? 0 : 1 + this.luaAngulo);
    }
    
    @Override
    public void run(){
        while(true){
            actualizar();
            repaint();
            dormir();
        }
    } 
}
