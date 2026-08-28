package com.example._104896_practica1_algoritmos;

import controlador.Controlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Jugador;
import vista.PantallaPrincipal;

import java.util.ArrayList;

public class HelloApplication extends Application {

    //ArrayList de testeo
    private ArrayList<Jugador>jugadores;

    @Override
    public void start(Stage stage){
        jugadores=new ArrayList<>();
        jugadores.add(new Jugador("Jugador1"));
        jugadores.add(new Jugador("Jugador2"));
        Controlador controlador = new Controlador(jugadores);

        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(controlador);

        Scene scene = new Scene(pantallaPrincipal.getPane(), 1280, 720);
        stage.setTitle("BlackJack - Pantalla Principal");
        stage.setScene(scene);
        stage.show();
    }

}