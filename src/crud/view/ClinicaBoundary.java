package crud.view;

import crud.controller.ClinicaControl;
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
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import crud.model.Clinica;

public class ClinicaBoundary extends Application {
    private TextField txtIdClinica = new TextField("");
    private TextField txtNomeClinica = new TextField("");
    private TextField txtTelefoneClinica = new TextField("");
    private TextField txtEmailClinica = new TextField("");
    private TextField txtRuaClinica = new TextField("");
    private TextField txtBairroClinica = new TextField("");
    private TextField txtCepClinica = new TextField("");
    private TextField txtNumEndClinica = new TextField("");

    private Button btnAdicionarClinica = new Button("Adicionar");
    private Button btnBuscarClinica = new Button("Buscar");
    private Button btnAlterarClinica = new Button("Alterar");
    private Button btnExcluirClinica = new Button("Excluir");

    private ClinicaControl controlClinica = new ClinicaControl();

    private TableView<Clinica> table = new TableView<>();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Scene scene = new Scene(bp, 800, 600);
        bp.setTop(gp);
        bp.setCenter(table);

        prepararTable();

        gp.add(new Label("ID da Clinica"), 0, 0);
        gp.add(txtIdClinica, 1, 0);

        gp.add(new Label("Nome da Clinica"), 0, 1);
        gp.add(txtNomeClinica, 1, 1);

        gp.add(new Label("Telefone"), 0, 2);
        gp.add(txtTelefoneClinica, 1, 2);

        gp.add(new Label("Email"), 0, 3);
        gp.add(txtEmailClinica, 1, 3);

        gp.add(new Label("Rua"), 0, 4);
        gp.add(txtRuaClinica, 1, 4);

        gp.add(new Label("Numero"), 0, 5);
        gp.add(txtNumEndClinica, 1, 5);

        gp.add(new Label("Bairro"), 0, 6);
        gp.add(txtBairroClinica, 1, 6);

        gp.add(new Label("Cep"), 0, 7);
        gp.add(txtCepClinica, 1, 7);

        gp.add(btnAdicionarClinica, 1, 8);
        gp.add(btnBuscarClinica, 2, 8);
        gp.add(btnAlterarClinica, 3, 8);
        gp.add(btnExcluirClinica, 4, 8);

        btnAdicionarClinica.setOnAction(e -> {
            controlClinica.adicionar();
            controlClinica.limpar();
            controlClinica.pesquisar();
        });

        btnBuscarClinica.setOnAction(e -> controlClinica.pesquisar());

        btnExcluirClinica.setOnAction(e -> {
            controlClinica.excluir();
            controlClinica.limpar();
            controlClinica.pesquisar();
        });

        btnAlterarClinica.setOnAction(e -> {
            controlClinica.alterar();
            controlClinica.limpar();
            controlClinica.pesquisar();
        });

        vincular();

        stage.setTitle("Clinica Médica - CRUD");
        stage.setScene(scene);
        stage.show();
    }

    private void prepararTable() {

        TableColumn<Clinica, Integer> col1 = new TableColumn<>("ID");
        col1.setCellValueFactory(new PropertyValueFactory<Clinica, Integer>("id"));

        TableColumn<Clinica, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<Clinica, String>("nome"));

        TableColumn<Clinica, String> col3 = new TableColumn<>("Telefone");
        col3.setCellValueFactory(new PropertyValueFactory<Clinica, String>("telefone"));

        TableColumn<Clinica, String> col4 = new TableColumn<>("Email");
        col4.setCellValueFactory(new PropertyValueFactory<Clinica, String>("email"));
        
        TableColumn<Clinica, String> col5 = new TableColumn<>("Rua");
        col5.setCellValueFactory(new PropertyValueFactory<Clinica, String>("rua"));

        TableColumn<Clinica, Integer> col6 = new TableColumn<>("CEP");
        col6.setCellValueFactory(new PropertyValueFactory<Clinica, Integer>("numEnd"));

        TableColumn<Clinica, String> col7 = new TableColumn<>("Numero");
        col7.setCellValueFactory(new PropertyValueFactory<Clinica, String>("bairro"));

        TableColumn<Clinica, String> col8 = new TableColumn<>("Bairro");
        col8.setCellValueFactory(new PropertyValueFactory<Clinica, String>("cep"));

        

        table.getColumns().clear();
        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8);

        table.setItems(controlClinica.getLista());

    }

    public void vincular() {

        StringConverter<? extends Number> converterNumber = new IntegerStringConverter();

        Bindings.bindBidirectional(txtIdClinica.textProperty(), controlClinica.getIdProperty(),
                (StringConverter) converterNumber);

        Bindings.bindBidirectional(txtNomeClinica.textProperty(), controlClinica.getNomeProperty());

        Bindings.bindBidirectional(txtTelefoneClinica.textProperty(), controlClinica.getTelefoneProperty());

        Bindings.bindBidirectional(txtEmailClinica.textProperty(), controlClinica.getEmailProperty());

        Bindings.bindBidirectional(txtRuaClinica.textProperty(), controlClinica.getRuaProperty());

        Bindings.bindBidirectional(txtBairroClinica.textProperty(), controlClinica.getBairroProperty());

        Bindings.bindBidirectional(txtCepClinica.textProperty(), controlClinica.getCepProperty());

        Bindings.bindBidirectional(txtNumEndClinica.textProperty(), controlClinica.getNumEndProperty(),
                (StringConverter) converterNumber);

    }

    public static void main(String[] args) throws Exception {
        Application.launch(ClinicaBoundary.class, args);
    }
}