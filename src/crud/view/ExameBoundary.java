package crud.view;

import crud.controller.ExameController;
import crud.model.Exame;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ExameBoundary extends Application{

	//Criando os componentes
	private TextField txtId = new TextField();
	private TextField txtPaciente = new TextField();
	private TextField txtMedico = new TextField();
	private TextField txtClinica = new TextField();
	private TextField txtData = new TextField();
	private TextField txtHora = new TextField();
	private TextField txtDiagnostico = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnEditar = new Button("Editar");
	private Button btnExcluir = new Button("Excluir");
	
	private ExameController exControl = new ExameController();
    
    private TableView<Exame> tableExam = new TableView<>();
    
    public void start(Stage exame) throws Exception {
    	//Criando paineis
		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane();
        HBox btns = new HBox(btnAdicionar, btnEditar, btnExcluir, btnPesquisar);
		VBox vb = new VBox();

        vb.getChildren().addAll(gp, btns);

        gp.setVgap(6);
        gp.setHgap(4);

        btns.setSpacing(16);
        btns.setAlignment(Pos.CENTER_LEFT);

        vb.setSpacing(16);
        vb.setPadding(new Insets(10));

		bp.setTop(vb);
		bp.setCenter(tableExam);
		
		//Personalizando interface
		gp.add(new Label("ID"), 0, 0);
		gp.add(txtId, 0, 1);
		gp.add(new Label("Paciente"), 1, 0);
		gp.add(txtPaciente, 1, 1);
		gp.add(new Label("Medico"), 2, 0);
		gp.add(txtMedico, 2, 1);
		gp.add(new Label("Clinica"), 0, 2);
		gp.add(txtClinica, 0, 3);
		gp.add(new Label("Data"), 1, 2);
		gp.add(txtData, 1, 3);
		gp.add(new Label("Hora"), 2, 2);
		gp.add(txtHora, 2, 3);
		gp.add(new Label("Diagnóstico"), 3, 2);
		gp.add(txtDiagnostico, 3, 3);

        txtDiagnostico.setPrefWidth(480);
        
        //operações
        sync();
        preparaTable();
        
        btnAdicionar.setOnAction(e -> {
            exControl.adicionar();
            exControl.limpaCampos();
            exControl.pesquisar();
        });

        btnPesquisar.setOnAction(e -> {
            exControl.pesquisar();
            exControl.limpaCampos();
        });

        btnEditar.setOnAction(e -> {
            exControl.editar();
            exControl.limpaCampos();
            exControl.pesquisar();
        });

        btnExcluir.setOnAction(e -> {
            exControl.excluir();
            exControl.limpaCampos();
            exControl.pesquisar();
        });
        
        exame.setScene(new Scene(bp, 945, 600));
        exame.setTitle("CRUD - Exame");
        exame.show();
    }
    
    private void preparaTable(){
        TableColumn<Exame, Integer> col1 = new TableColumn<>("ID");
        TableColumn<Exame, String> col2 = new TableColumn<>("Paciente");
        TableColumn<Exame, String> col3 = new TableColumn<>("Medico");
        TableColumn<Exame, Integer> col4 = new TableColumn<>("Clinica");
        TableColumn<Exame, String> col5 = new TableColumn<>("Data");
        TableColumn<Exame, String> col6 = new TableColumn<>("Hora");
        TableColumn<Exame, String> col7 = new TableColumn<>("Diagnóstico");
        

        col1.setCellValueFactory(new PropertyValueFactory<Exame, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Exame, String>("paciente"));
        col3.setCellValueFactory(new PropertyValueFactory<Exame, String>("medico"));
        col4.setCellValueFactory(new PropertyValueFactory<Exame, Integer>("clinica"));
        col5.setCellValueFactory(new PropertyValueFactory<Exame, String>("data"));
        col6.setCellValueFactory(new PropertyValueFactory<Exame, String>("hora"));
        col7.setCellValueFactory(new PropertyValueFactory<Exame, String>("diagnostico"));

        col7.setPrefWidth(470);
        

        tableExam.getColumns().clear();
        tableExam.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
        tableExam.setItems(exControl.getLista());

        tableExam.getSelectionModel().selectedItemProperty().addListener((prop, antiga, novo) -> {
            exControl.setExam(novo);
        });
    }

    public void sync(){
    	
    	StringConverter<? extends Number> converter = new NumberStringConverter();
    	
    	Bindings.bindBidirectional(txtId.textProperty(), exControl.idProperty(), (StringConverter<Number>) converter);
        Bindings.bindBidirectional(exControl.pacienteProperty(), txtPaciente.textProperty());
        Bindings.bindBidirectional(exControl.medicoProperty(), txtMedico.textProperty());
        Bindings.bindBidirectional(txtClinica.textProperty(), exControl.clinicaProperty(), (StringConverter<Number>) converter);
        Bindings.bindBidirectional(exControl.dataProperty(), txtData.textProperty());
        Bindings.bindBidirectional(exControl.horaProperty(), txtHora.textProperty());
        Bindings.bindBidirectional(exControl.diagnosticoProperty(), txtDiagnostico.textProperty());
    }

    public static void main(String[] args) {
        Application.launch(ExameBoundary.class, args);
    }
}
