package crud.view;

import crud.controller.EspecialidadeController;
import crud.model.Especialidade;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class EspecialidadeBoundary extends Application{
    //Criando os componentes
    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    
    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private Button btnEditar = new Button("Editar");
    private Button btnExcluir = new Button("Excluir");

    private EspecialidadeController eControl = new EspecialidadeController();
    
    private TableView<Especialidade> tableEspec = new TableView<>();

    @Override
    public void start(Stage especialidade) throws Exception {
        //Criando paineis
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //Personalizando interface
        txtId.setPromptText("Digite o ID");
        txtNome.setPromptText("Digite o nome da especialidade");

        txtId.setPrefWidth(110);
        txtNome.setPrefWidth(310);

        gp.setVgap(10);
        gp.setHgap(6);
        gp.setPadding(new Insets(10, 10, 10, 10));

        btnAdicionar.setCursor(Cursor.HAND);
        btnPesquisar.setCursor(Cursor.HAND);
        btnEditar.setCursor(Cursor.HAND);
        btnExcluir.setCursor(Cursor.HAND);



        //Colocando componentes nos paineis
        gp.add(txtId, 0, 0);
        gp.add(txtNome, 1, 0);
        gp.add(btnAdicionar, 9, 3);
        gp.add(btnPesquisar, 10, 3);
        gp.add(btnEditar, 11, 3);
        gp.add(btnExcluir, 12, 3);

        bp.setTop(gp);
        bp.setCenter(tableEspec);

        //operações
        sync();
        preparaTable();

        btnAdicionar.setOnAction(e -> {
            eControl.adicionar();
            eControl.limpaCampos();
            eControl.pesquisar();
        });

        btnPesquisar.setOnAction(e -> {
            eControl.pesquisar();
            eControl.limpaCampos();
        });

        btnEditar.setOnAction(e -> {
            eControl.editar();
            eControl.limpaCampos();
            eControl.pesquisar();
        });

        btnExcluir.setOnAction(e -> {
            eControl.excluir();
            eControl.limpaCampos();
            eControl.pesquisar();
        });

        especialidade.setScene(new Scene(bp, 745, 600));
        especialidade.setTitle("CRUD - Especialidade");
        especialidade.show();

    }

    private void preparaTable(){
        TableColumn<Especialidade, Integer> col1 = new TableColumn<>("ID");
        TableColumn<Especialidade, String> col2 = new TableColumn<>("ESPECIALIDADE");

        col1.setCellValueFactory(new PropertyValueFactory<Especialidade, Integer>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Especialidade, String>("nome"));
        col2.setPrefWidth(663);

        tableEspec.getColumns().clear();
        tableEspec.getColumns().addAll(col1, col2);
        tableEspec.setItems(eControl.getLista());

        tableEspec.getSelectionModel().selectedItemProperty().addListener((prop, antiga, novo) -> {
            eControl.setEspec(novo);
        });
    }

    public void sync(){
        StringConverter<? extends Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(txtId.textProperty(), eControl.idProperty(), (StringConverter<Number>)converter);
        Bindings.bindBidirectional(eControl.nomeProperty(), txtNome.textProperty());
    }

    public static void main(String[] args) {
        Application.launch(EspecialidadeBoundary.class, args);
    }
}
