package JavaFXPhoneBookProject.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by John on 10.06.2017.
 */
public class WarningWindowController {
    public Label lblWarningWindow;
    public Button btnWarningWindowCancel;
    public Button btnWarningWindowOk;

    public void actionWarningWindowOk(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void actionWarningWindowCancel(ActionEvent actionEvent) {
        actionWarningWindowOk(actionEvent);
    }

    public void setLblWarningWindow(String lblWarningWindow){
        this.lblWarningWindow.setText(lblWarningWindow);
    }
}
