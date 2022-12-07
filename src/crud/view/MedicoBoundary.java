package crud.view;

import crud.controller.MedicoController;
import crud.model.Medico;
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
import javafx.util.converter.NumberStringConverter;

public class MedicoBoundary extends Application{

	//Criando os componentes
	private TextField txtCrm = new TextField();
	private TextField txtEspecialidade = new TextField();
	private TextField txtNome = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnEditar = new Button("Editar");
	private Button btnExcluir = new Button("Excluir");
	
	private MedicoController mControl = new MedicoController();
    
    private TableView<Medico> tableMed = new TableView<>();
    
    public void start(Stage medico) throws Exception {
    	//Criando paineis
		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane();
		
		bp.setTop(gp);
		bp.setCenter(tableMed);
		
		//Personalizando interface
		gp.add(new Label("CRM"), 0, 0);
		gp.add(txtCrm, 1, 0);
		gp.add(new Label("Especialidade"), 0, 1);
		gp.add(txtEspecialidade, 1, 1);
		gp.add(new Label("Nome"), 0, 2);
		gp.add(txtNome, 1, 2);
		
		gp.add(btnAdicionar, 9, 3);
        gp.add(btnPesquisar, 10, 3);
        gp.add(btnEditar, 11, 3);
        gp.add(btnExcluir, 12, 3);
        
        //operações
        sync();
        preparaTable();
        
        btnAdicionar.setOnAction(e -> {
            mControl.adicionar();
            mControl.limpaCampos();
            mControl.pesquisar();
        });

        btnPesquisar.setOnAction(e -> {
            mControl.pesquisar();
            mControl.limpaCampos();
        });

        btnEditar.setOnAction(e -> {
            mControl.editar();
            mControl.limpaCampos();
            mControl.pesquisar();
        });

        btnExcluir.setOnAction(e -> {
            mControl.excluir();
            mControl.limpaCampos();
            mControl.pesquisar();
        });
        
        medico.setScene(new Scene(bp, 745, 600));
        medico.setTitle("CRUD - Medico");
        medico.show();
    }
    
    private void preparaTable(){
        TableColumn<Medico, String> col1 = new TableColumn<>("Crm");
        TableColumn<Medico, String> col2 = new TableColumn<>("Nome");
        TableColumn<Medico, Integer> col3 = new TableColumn<>("Especialidade");

        col1.setCellValueFactory(new PropertyValueFactory<Medico, String>("crm"));
        col2.setCellValueFactory(new PropertyValueFactory<Medico, String>("nome"));
        col3.setCellValueFactory(new PropertyValueFactory<Medico, Integer>("especialidade"));
        col2.setPrefWidth(510);
        

        tableMed.getColumns().clear();
        tableMed.getColumns().addAll(col1, col2, col3);
        tableMed.setItems(mControl.getLista());

        tableMed.getSelectionModel().selectedItemProperty().addListener((prop, antiga, novo) -> {
            mControl.setMed(novo);
        });
    }

    public void sync(){
        StringConverter<? extends Number> converter = new NumberStringConverter();
    	Bindings.bindBidirectional(mControl.crmProperty(), txtCrm.textProperty());
        Bindings.bindBidirectional(txtEspecialidade.textProperty(), mControl.especialidadeProperty(), (StringConverter<Number>) converter);
        Bindings.bindBidirectional(mControl.nomeProperty(), txtNome.textProperty());
    }

    public static void main(String[] args) {
        Application.launch(MedicoBoundary.class, args);
    }
}