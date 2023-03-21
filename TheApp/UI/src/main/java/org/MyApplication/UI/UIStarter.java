package org.MyApplication.UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.MyApplication.Update.Updater;

public class UIStarter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane scenePane = new StackPane();
        AnchorPane backgroundPane = new AnchorPane();
        backgroundPane.setMinWidth(400);
        backgroundPane.setMinHeight(300);
        Label updateLabel = new Label();
        updateLabel.setText("Updating proces");
        scenePane.getChildren().add(backgroundPane);
        scenePane.getChildren().add(updateLabel);
        Updater.update();
        Scene scene  = new Scene(scenePane);
        stage.setScene(scene);
        stage.show();
    }
    public static void appUpdatedText()
    {
        System.out.println("Update 0.1");
    }
}
