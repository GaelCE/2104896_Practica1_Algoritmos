package vista;

import controlador.Controlador;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import modelo.CartaInglesa;
import modelo.Jugador;
import javafx.scene.control.Label;

public class PantallaPrincipal{
    private AnchorPane paneBlackJack;
    private Label lbJugadorActual;
    private Controlador controlador;
    private HBox hbCartasJugador;
    private HBox hbCartasCrupier;
    private ImageButton btPedirCarta;
    private ImageButton btPlantarse;
    private static final double RESX = 1920.0;
    private static final double RESGAEL = 1080.0;

    public PantallaPrincipal(Controlador controlador){
        paneBlackJack = new AnchorPane();
        this.controlador=controlador;

        ImageView background=new ImageView(new Image(getClass().getResourceAsStream("/recursos/mesaBlackJack.png")));
        background.setFitWidth(1280);
        background.setFitHeight(720);
        background.setPreserveRatio(false);

        hbCartasCrupier=new HBox(10);
        hbCartasJugador=new HBox(10);

        btPedirCarta=new ImageButton("/recursos/botonPedirCarta.png","/recursos/botonPedirCartaBrillante.png",370,200);
        btPedirCarta.setOnAction(e->{
            controlador.pedirCarta();
            actualizarPantalla();
        });


        btPlantarse=new ImageButton("/recursos/botonPlantarse.png","/recursos/botonPlantarseBrillante.png",370,200);
        btPlantarse.setOnAction(e->{
            controlador.plantarse();
            actualizarPantalla();
        });

        //Posicionamiento de los elementos de la pantalla
        posicionarEnPane(btPedirCarta,450/RESX,800/RESGAEL);
        posicionarEnPane(btPlantarse,950/RESX,800/RESGAEL);
        posicionarEnPane(hbCartasJugador,830/RESX,570/RESGAEL);
        posicionarEnPane(hbCartasCrupier,830/RESX,50/RESGAEL);

        paneBlackJack.getChildren().addAll(background,hbCartasCrupier,hbCartasJugador,btPedirCarta,btPlantarse);
        actualizarPantalla();
    }

    private void posicionarEnPane(Node nodo, double porcentajeX, double porcentajeY) {
        nodo.translateXProperty().unbind();
        nodo.translateYProperty().unbind();
        nodo.translateXProperty().bind(paneBlackJack.widthProperty().multiply(porcentajeX));
        nodo.translateYProperty().bind(paneBlackJack.heightProperty().multiply(porcentajeY));
    }

    private void actualizarPantalla(){
        if(controlador.esRondaTerminada()){
            //mostrarResultados();
            return;
        }

        Jugador actual=controlador.getJugadorEnTurno();
        //lbTurno.setText("Turno de: "+actual.getNombre());

        hbCartasJugador.getChildren().clear();
        for(CartaInglesa carta:actual.getMano()){
            hbCartasJugador.getChildren().add(new CartaImage(carta));
        }

        hbCartasCrupier.getChildren().clear();
        for(CartaInglesa carta:controlador.getManoCrupier()){
            hbCartasCrupier.getChildren().add(new CartaImage(carta));
        }

    }

    //Getter para testeo
    public AnchorPane getPane(){
        return paneBlackJack;
    }
}
