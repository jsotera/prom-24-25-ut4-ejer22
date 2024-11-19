package es.masanz.ut4.diana.app;

import es.masanz.ut4.diana.util.Configuracion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DianaApp extends Application {

    public static void main(String[] args) {
        // Este metodo existe porque extendemos Application, pero no se ve
        // Basicamente, acaba llamando al metodo start() de abajo
        // NO TOCAR
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = crearGUI();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dibujando una diana");
        stage.setResizable(false);
        stage.show();
    }

    private Pane crearGUI() {
        Pane panel = new Pane();
        Canvas canvas = new Canvas(Configuracion.ANCHO_CANVAS, Configuracion.ALTO_CANVAS);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Configuracion.NEGRO);
        gc.fillRect(0, 0, Configuracion.ANCHO_CANVAS, Configuracion.ALTO_CANVAS);
        dibujarDiana(gc);
        panel.getChildren().add(canvas);
        return panel;
    }

    private void dibujarDiana(GraphicsContext gc) {
        int contador = 0;
        int coord = 0;
        int diametro = Configuracion.ANCHO_CANVAS;
        while(diametro > 0){
            if( contador % 2 == 0 ){
                gc.setFill(Configuracion.ROJO);
            } else {
                gc.setFill(Configuracion.BLANCO);
            }
            gc.fillOval(coord, coord, diametro, diametro);
            diametro = diametro - Configuracion.INTERVALO_ENTRE_CIRCULOS;
            coord = coord + (Configuracion.INTERVALO_ENTRE_CIRCULOS / 2);
            contador++;
        }
    }
}
