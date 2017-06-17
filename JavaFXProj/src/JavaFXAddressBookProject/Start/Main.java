package JavaFXAddressBookProject.Start;

import JavaFXAddressBookProject.Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent fxmlMain;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/MainWindow.fxml"));
        fxmlMain = fxmlLoader.load();
        MainController mainController = new MainController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle("Phone book");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        primaryStage.setScene(new Scene(fxmlMain, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
