package application;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Espectador;

public class Controller {
	
	 @FXML
	    private TextField archivo;

	  @FXML
	    private Button btnExplorar;

	    @FXML
	    private Button btnCargar;

	    @FXML
	    private TextField idEspectador;

	    @FXML
	    private Button btnBuscarEspectador;

	    @FXML
	    private Label tiempoEsp;

	    @FXML
	    private Label encontroE;

	    @FXML
	    private TextField idPart;

	    @FXML
	    private Button btnBuscarPart;

	    @FXML
	    private Label tiempoPart;
	    
	    @FXML
	    private Label resultado;

	    @FXML
	    private Label encontroPart;

	    @FXML
	    private ImageView img;

	    @FXML
	    private TextField txtId;

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private TextField txtGenero;

	    @FXML
	    private Button participantes;
	    
	    @FXML
	    private Canvas pintar;
	    
	    public void Controller() {
	    	
	    }

    
    public void initialize() {
    	
    	btnExplorar.setOnAction(e->{
			seleccionarDatos();
		});
		btnCargar.setOnAction(e->{
			cargarArchivos();
		});
		btnBuscarEspectador.setOnAction(e->{
			buscarEspectador();
		});
		
		btnBuscarPart.setOnAction(e->{
			buscarParticipante();
		});
    	
    }
    
    public void buscarEspectador() {
		long principio=System.currentTimeMillis();
		try {
			ponerAvatar(Main.getEvento().getArbol().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idEspectador.getText())).getAvatar());
			txtId.setText(""+Main.getEvento().getArbol().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idEspectador.getText())).getId());
			txtNombre.setText(Main.getEvento().getArbol().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idEspectador.getText())).getName());
			txtGenero.setText(Main.getEvento().getArbol().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idEspectador.getText())).getGender());
		} catch (Exception e) {
			encontroE.setText(e.getMessage());
		}
		long fin=System.currentTimeMillis();
		tiempoEsp.setText(Long.toString(fin-principio));
		
	}
    
    public void buscarParticipante() {
		long principio=System.currentTimeMillis();
		try {
			ponerAvatar(Main.getEvento().getArbol().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idPart.getText())).getAvatar());
			txtId.setText(""+Main.getEvento().getLista().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idEspectador.getText())).getId());
			txtNombre.setText(Main.getEvento().getLista().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idPart.getText())).getName());
			txtGenero.setText(Main.getEvento().getLista().buscar(Main.getEvento().getArbol().getRaiz(), Long.parseLong(idPart.getText())).getGender());
		} catch (Exception e) {
			encontroPart.setText(e.getMessage());
		}
		long fin=System.currentTimeMillis();
		tiempoPart.setText(Long.toString(fin-principio));
		
	}
	
	public void ponerAvatar(String avatar) {
		img.setImage(new Image(avatar));
	}
	
	public void seleccionarDatos() {
		Stage stage=new Stage();
		FileChooser fC=new FileChooser();
		fC.setTitle("Seleccione los datos que desea cargar");
		fC.setInitialDirectory(new File("data"));
		File file=fC.showOpenDialog(stage);
		archivo.setText(file.getAbsolutePath());
	}
	
	public void cargarArchivos() {
		try {
			Main.getEvento().cargarDatos(new File(archivo.getText()));
			resultado.setText("Los datos se cargaron correctamente");
		} catch (Exception e1) {
			e1.printStackTrace();
			resultado.setText("Ha ocurrido un error al cargar los datos");
		}
	}


	public void pintarArbol(GraphicsContext g) {
		ArrayList<Espectador> rutas=Main.getEvento().espectadores();
		for(Espectador epa : rutas) {
			ImageView imagen=new ImageView(new Image(epa.getAvatar()));
			g.drawImage(imagen.getImage(), epa.getPosX(), epa.getPosY(), 30, 30);
			pintarLineas(g);
		}
	}
	
	public void pintarLineas(GraphicsContext g) {
		ArrayList<Espectador> rutas=Main.getEvento().espectadores();
		for (int i = 0; i < rutas.size()-1; i++) {
			g.strokeLine(rutas.get(i).getPosX()+30,rutas.get(i).getPosY()+40, rutas.get(i+1).getPosX(), rutas.get(i+1).getPosY());
		}
	}
	
 
    @FXML
    void mostrarEspectador(ActionEvent event) {
    	
    	pintarArbol(null);
    	pintarLineas(null);
    	
    }

    @FXML
    void mostrarParticipantes(ActionEvent event) {

    }

}
