package crud.view;

import crud.controller.PacienteControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
import crud.model.Paciente;

public class PacienteBoundary extends Application {
    private TextField txtCpfPaciente = new TextField("");
    private TextField txtNomePaciente = new TextField("");
    private TextField txtTelefonePaciente = new TextField("");
    private TextField txtDataNascPaciente = new TextField("");

    private Button btnAdicionarPaciente = new Button("Adicionar");
    private Button btnBuscarPaciente = new Button("Buscar");
    private Button btnExcluirPaciente = new Button("Excluir");
    private Button btnAlterarPaciente = new Button("Alterar");

    private TableView<Paciente> table = new TableView<>();

    private PacienteControl control = new PacienteControl();


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Scene scene = new Scene(bp, 400, 300);
        bp.setTop(gp);
        bp.setCenter(table);

        prepararTable();

        gp.add(new Label("CPF do Paciente"), 0, 0);
        gp.add(txtCpfPaciente, 1, 0);

        gp.add(new Label("Nome Completo"), 0, 1);
        gp.add(txtNomePaciente, 1, 1);

        gp.add(new Label("Telefone"), 0, 2);
        gp.add(txtTelefonePaciente, 1, 2);

        gp.add(new Label("Data de Nascimento"), 0, 3);
        gp.add(txtDataNascPaciente, 1, 3);
     
        gp.add(btnAdicionarPaciente, 0, 4);
        gp.add(btnBuscarPaciente, 1, 4);
        gp.add(btnAlterarPaciente, 2, 4);
        gp.add(btnExcluirPaciente, 3, 4);

        btnAdicionarPaciente.setOnAction(e -> {
            control.adicionar();
            control.limpar();
            control.pesquisar();
        });

        btnBuscarPaciente.setOnAction(e -> control.pesquisar());

        btnExcluirPaciente.setOnAction(e -> {
            control.excluir();
            control.limpar();
            control.pesquisar();
        });

        btnAlterarPaciente.setOnAction(e -> {
            control.alterar();
            control.limpar();
            control.pesquisar();
        });

        vincular();

        stage.setTitle("Clinica Médica - CRUD");
        stage.setScene(scene);
        stage.show();
    }

    private void vincular() {

        Bindings.bindBidirectional(txtCpfPaciente.textProperty(), control.getCpfProperty());

        Bindings.bindBidirectional(txtNomePaciente.textProperty(), control.getNomeProperty());

        Bindings.bindBidirectional(txtTelefonePaciente.textProperty(), control.getTelefoneProperty());

        Bindings.bindBidirectional(txtDataNascPaciente.textProperty(), control.getDataNascProperty());

    }

    private void prepararTable() {

        TableColumn<Paciente, String> col1 = new TableColumn<>("Cpf");
        col1.setCellValueFactory(new PropertyValueFactory<Paciente, String>("cpf"));

        TableColumn<Paciente, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nome"));

        TableColumn<Paciente, String> col3 = new TableColumn<>("Telefone");
        col3.setCellValueFactory(new PropertyValueFactory<Paciente, String>("telefone"));
        
        TableColumn<Paciente, String> col4 = new TableColumn<>("DataNasc");
        col4.setCellValueFactory(new PropertyValueFactory<Paciente, String>("dataNascimento"));

        table.getColumns().clear();
        table.getColumns().addAll(col1, col2, col3, col4);

        table.setItems(control.getLista());


    }

    public static void main(String[] args) {
        launch(PacienteBoundary.class,args);
    }
    
}
