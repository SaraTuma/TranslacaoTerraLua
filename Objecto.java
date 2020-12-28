package solterralua;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * @author : Sara Tuma
 * Estudante: Universidade Católica de Angola
 * Ano: 3º ( Primeiro semestre )
 * Disciplina: Computação Grafica
 * 2020
 */
public class Objecto {
    private int posx;
    private int posy;
    private int altura;
    private int largura;
    private int dx=1;
    private int dy=1;
    private Image img;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    
    public Objecto (String s,int posx,int posy,int largura,int altura){
        try {
            img = new ImageIcon(getClass().getResource(s)).getImage();
        } catch (Exception e) {
            System.out.println("ERRRo");
        }
        
        this.posx=posx; this.posy=posy; this.largura=largura;
        this.altura=altura;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
    
}
