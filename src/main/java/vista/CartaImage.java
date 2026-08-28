package vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.CartaInglesa;

import java.io.File;

public class CartaImage extends Label {

    private double width = 100;
    private double height = 120;
    private CartaInglesa carta;
    private String ruta;
    public CartaImage(CartaInglesa carta) {
        this.carta = carta;
        crearImagenCarta();
    }

    public CartaImage(String backCard){
        crearImagenCartaBack(backCard);
    }

    private void crearImagenCartaBack(String ruta){
        this.ruta = ruta;
        File archivo = new File(ruta);
        Image cartaImagen = new Image(archivo.toURI().toString());
        ImageView view = new ImageView(cartaImagen);
        view.setFitWidth(width * 1.1);
        view.setFitHeight(height * 1.1);
        setGraphic(view);
    }

    private void crearImagenCarta() {
        String ruta = obtenerRuta();
        File archivo = new File(ruta);
        Image cartaImagen = new Image(archivo.toURI().toString());
        ImageView view = new ImageView(cartaImagen);
        view.setFitWidth(width);
        view.setFitHeight(height);
        setGraphic(view);
    }

    public CartaInglesa getCarta(){
        return carta;
    }

    public String toString(){
        return carta.toString();
    }

    public void setWidthAndHeight(double w, double h){
        width = w;
        height = h;
        if(carta == null) crearImagenCartaBack(ruta);
        else crearImagenCarta();
    }

    private String obtenerRuta(){
        String ruta = "src/main/java/com/example/_104896_practica1_algoritmos/cartas/";
        ruta += obtenerValor() + "_of_" + obtenerPalo() + ".png";
        return ruta;
    }

    private String obtenerValor(){
        String valor = "";
        switch(carta.getValor()){
            case 11:
                valor += "jack";
                break;
            case 12:
                valor += "queen";
                break;
            case 13:
                valor += "king";
                break;
            case 14:
                valor += "ace";
                break;
            default:
                valor += carta.getValor();
                break;
        }
        return valor;
    }

    private String obtenerPalo(){
        String palo = "";
        switch(carta.getPalo()){
            case PICA:
                palo += "spades";
                break;
            case TREBOL:
                palo += "clubs";
                break;
            case CORAZON:
                palo += "hearts";
                break;
            case DIAMANTE:
                palo += "diamonds";
                break;
        }
        return palo;
    }
}
