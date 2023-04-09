/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Serivces.EventsService;
import entities.Events;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class HomePageFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private TextField tfTitreEvent;
    @FXML
    private TextField tfDateDebut;
    @FXML
    private TextField tfDateFin;
    @FXML
    private TextField tfPlaceEvent;
    //@FXML
   // private TextField tfImageEvnet;
      @FXML
    private TextField tfDescriptionEvent;
 @FXML private TableView<Events> table;
@FXML private TableColumn<Events, Integer> idEvent;
@FXML private TableColumn<Events, String> titreEvent;
@FXML private TableColumn<Events, String> dateDebut;
@FXML private TableColumn<Events, String> dateFin;
@FXML private TableColumn<Events, String> placeEvent;
@FXML private TableColumn<Events, String> descriptionEvent; 
@FXML private TableColumn<Events, String> imageEvent; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
        @FXML
    private void btnAjouter(ActionEvent event) {
        Events e1= new  Events(tfTitreEvent.getText(), tfDateDebut.getText(),tfDateFin.getText(),tfPlaceEvent.getText(),tfDescriptionEvent.getText() );
       EventsService sp = new EventsService();
        sp.Ajouter(e1);
    }
          @FXML
 private void btnAfficher(ActionEvent event) {
    EventsService sp = new EventsService();
    List<Events> events = sp.afficher();
    ObservableList<Events> observableEvents = FXCollections.observableArrayList(events);

    idEvent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
    titreEvent.setCellValueFactory(new PropertyValueFactory<>("titreEvent"));
    dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
    dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
    placeEvent.setCellValueFactory(new PropertyValueFactory<>("placeEvent"));
    descriptionEvent.setCellValueFactory(new PropertyValueFactory<>("DescriptionEvent"));
 imageEvent.setCellValueFactory(new PropertyValueFactory<>("image"));
    table.setItems(observableEvents);
}

}

