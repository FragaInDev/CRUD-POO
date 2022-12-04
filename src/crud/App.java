package crud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        //Adicionando tabs no tab pane
        Tab tPaciente = new Tab("Paciente");
        Tab tMedico = new Tab("Médico");
        Tab tClinica = new Tab("Clínica");
        Tab tEspecialidade = new Tab("Especialidade");
        Tab tConsulta = new Tab("Consulta");
        Tab tExame = new Tab("Exame");
        Tab tProntuario = new Tab("Prontuario");
        Tab tMedicamento = new Tab("Medicamento");
        

        TabPane tp = new TabPane();
        tp.getTabs().addAll(tPaciente, tMedico, tClinica, tEspecialidade, tConsulta, tExame, tProntuario, tMedicamento);
        
        stage.setScene(new Scene(tp));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(App.class, args);
    }
}
