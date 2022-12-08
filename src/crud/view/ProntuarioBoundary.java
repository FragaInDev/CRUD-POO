package crud.view;

import crud.controller.ProntuarioController;
import crud.model.Prontuario;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ProntuarioBoundary extends Application{
    private TextField txtId = new TextField();
    private TextField txtPaciente = new TextField();
    private TextField txtMedico = new TextField();
    private TextField txtExame = new TextField();
    private TextField txtConsulta = new TextField();
    private TextField txtMedicamento = new TextField();
    private TextField txtData = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private Button btnEditar = new Button("Editar");
    private Button btnExcluir = new Button("Excluir");

    private ProntuarioController prControl = new ProntuarioController();

    private TableView<Prontuario> tablePront = new TableView<>();

    @Override
    public void start(Stage prontuario) throws Exception {
        //Criando paineis
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //Personalizando interface
        txtId.setPromptText("Digite o ID");
        txtPaciente.setPromptText("Digite o CPF do paciente");
        txtMedico.setPromptText("Digite o CRM do médico");
        txtExame.setPromptText("Digite o ID do exame");
        txtConsulta.setPromptText("Digite o ID da consulta");
        txtMedicamento.setPromptText("Digite o ID do medicamento");
        txtData.setPromptText("Digite a data");

        gp.setVgap(10);
        gp.setHgap(6);
        gp.setPadding(new Insets(10, 10, 10, 10));

        btnAdicionar.setCursor(Cursor.HAND);
        btnPesquisar.setCursor(Cursor.HAND);
        btnEditar.setCursor(Cursor.HAND);
        btnExcluir.setCursor(Cursor.HAND);


        //Colocando componentes nos paineis
        gp.add(new Label("ID"), 0, 0);
        gp.add(txtId, 0, 1);
        gp.add(new Label("CPF do Paciente"), 1, 0);
        gp.add(txtPaciente, 1, 1);
        gp.add(new Label("CRM do Médico"), 2, 0);
        gp.add(txtMedico, 2, 1);
        gp.add(new Label("ID do Exame"), 3, 0);
        gp.add(txtExame, 3, 1);
        gp.add(new Label("ID da Consulta"), 0, 2);
        gp.add(txtConsulta, 0, 3);
        gp.add(new Label("ID do Medicamento"), 1, 2);
        gp.add(txtMedicamento, 1, 3);
        gp.add(new Label("Data"), 2, 2);
        gp.add(txtData, 2, 3);
        gp.add(btnAdicionar, 4, 5);
        gp.add(btnPesquisar, 5, 5);
        gp.add(btnEditar, 6, 5);
        gp.add(btnExcluir, 7, 5);

        
        bp.setTop(gp);
        bp.setCenter(tablePront);
        
        //operações
        sync();
        preparaTable();

        btnAdicionar.setOnAction(e -> {
            prControl.adicionar();
            prControl.limpaCampos();
            prControl.pesquisar();
        });

        btnPesquisar.setOnAction(e -> {
            prControl.pesquisar();
            prControl.limpaCampos();
        });

        btnEditar.setOnAction(e -> {
            prControl.editar();
            prControl.limpaCampos();
            prControl.pesquisar();
        });

        btnExcluir.setOnAction(e -> {
            prControl.excluir();
            prControl.limpaCampos();
            prControl.pesquisar();
        });


        // set scene
        prontuario.setScene(new Scene(bp, 915, 600));
        prontuario.setTitle("CRUD - Prontuário");
        prontuario.show();
    }

    public void preparaTable(){
        TableColumn<Prontuario, Integer> col1 = new TableColumn<>("ID");
        TableColumn<Prontuario, String> col2 = new TableColumn<>("PACIENTE");
        TableColumn<Prontuario, String> col3 = new TableColumn<>("MEDICO");
        TableColumn<Prontuario, Integer> col4 = new TableColumn<>("EXAME");
        TableColumn<Prontuario, Integer> col5 = new TableColumn<>("CONSULTA");
        TableColumn<Prontuario, Integer> col6 = new TableColumn<>("MEDICAMENTO");
        TableColumn<Prontuario, String> col7 = new TableColumn<>("DATA");

        col1.setCellValueFactory(new PropertyValueFactory<Prontuario, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Prontuario, String>("paciente"));
        col3.setCellValueFactory(new PropertyValueFactory<Prontuario, String>("medico"));
        col4.setCellValueFactory(new PropertyValueFactory<Prontuario, Integer>("exame"));
        col5.setCellValueFactory(new PropertyValueFactory<Prontuario, Integer>("consulta"));
        col6.setCellValueFactory(new PropertyValueFactory<Prontuario, Integer>("medicamento"));
        col7.setCellValueFactory(new PropertyValueFactory<Prontuario, String>("data"));

        col6.setPrefWidth(100);

        tablePront.getColumns().clear();
        tablePront.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
        tablePront.setItems(prControl.getLista());

        tablePront.getSelectionModel().selectedItemProperty().addListener((prop, antiga, novo) -> {
            prControl.setPron(novo);
        });
    }

    public void sync(){
        StringConverter<? extends Number> converterN = new NumberStringConverter();

        Bindings.bindBidirectional(txtId.textProperty(), prControl.idProperty(), (StringConverter<Number>) converterN);
        Bindings.bindBidirectional(prControl.pacienteProperty(), txtPaciente.textProperty());
        Bindings.bindBidirectional(prControl.medicoProperty(), txtMedico.textProperty());
        Bindings.bindBidirectional(txtExame.textProperty(), prControl.exameProperty(), (StringConverter<Number>) converterN);
        Bindings.bindBidirectional(txtConsulta.textProperty(), prControl.consultaProperty(), (StringConverter<Number>) converterN);
        Bindings.bindBidirectional(txtMedicamento.textProperty(), prControl.medicamentoProperty(), (StringConverter<Number>) converterN);
        Bindings.bindBidirectional(prControl.dataProperty(), txtData.textProperty());
        
    }
    
    public static void main(String[] args) {
        Application.launch(ProntuarioBoundary.class, args);
    }
}
