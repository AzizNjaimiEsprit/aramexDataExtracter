package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.models.Item;
import sample.services.Import;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListOfData implements Initializable {
    @FXML
    private TableView<Item> data_tab;

    @FXML
    private TableColumn<Item, String> date_name;

    @FXML
    private TableColumn<Item, String> data_email;



    public ListOfData() throws Exception {
    }


    private ObservableList<Item> itemObservableList = FXCollections.observableArrayList(
        Import.exportFile()
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        date_name.setCellValueFactory(new PropertyValueFactory("name"));
        data_email.setCellValueFactory(new PropertyValueFactory("email"));
        data_tab.setItems(itemObservableList);
    }


}
