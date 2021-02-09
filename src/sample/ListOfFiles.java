package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.models.AramexFile;
import sample.services.Import;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListOfFiles implements Initializable {
    @FXML
    private TableView<AramexFile> files_tab;

    @FXML
    private TableColumn<AramexFile, String> file_name;

    @FXML
    private TableColumn<AramexFile, String> file_ext;

    private ObservableList<AramexFile> aramexFiles = FXCollections.observableArrayList(
        Import.getFiles()
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        file_name.setCellValueFactory(new PropertyValueFactory("name"));
        file_ext.setCellValueFactory(new PropertyValueFactory("extension"));
        files_tab.setItems(aramexFiles);
    }

    public void exportData(MouseEvent mouseEvent) throws IOException {
        Scene scene = files_tab.getScene();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("listOfData.fxml"));

        Parent root = loader.load();

        scene.setRoot(root);
    }
}
