/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewerproject.gui.controller;

import imageviewerproject.be.SlideShowPicture;
import imageviewerproject.gui.model.ImageModel;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author bhp
 */
public class FXMLDocumentController implements Initializable {

    private int imageIdx = 0;

    private Timer timer;

    @FXML
    Parent root;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnLeft;

    @FXML
    private Button btnRight;

    @FXML
    private ImageView imageView;

    private final ImageModel imageModel;
    @FXML
    private TextField txtDelay;

    private boolean running;

    public FXMLDocumentController() {
        imageModel = new ImageModel();
    }

    @FXML
    private void handleSetDelay() {
        if (!txtDelay.getText().isEmpty()) {
            int delay = Integer.parseInt(txtDelay.getText());
            imageModel.getImages().get(imageIdx).setDelay(delay);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLoad.setOnAction((ActionEvent event)
                -> {
            handleBtnLoadAction();
        });

        btnLeft.setOnAction((ActionEvent event)
                -> {
            handleBtnLeftAction();
        });
        btnRight.setOnAction((ActionEvent event)
                -> {
            handleBtnRightAction();
        });
    }

    private void handleBtnLoadAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        List<File> files = fileChooser.showOpenMultipleDialog(new Stage());
        if (files.size() > 0) {
            files.forEach((File f)
                    -> {
                Image imageToAdd = new Image(f.toURI().toString());
                String path = f.toURI().toString();
                imageModel.addImage(new SlideShowPicture(imageToAdd, path));
            });
            displayImage();
        }
    }

    private void handleBtnLeftAction() {
        if (imageModel.getImages().size() > 0) {
            imageIdx = (imageIdx - 1 + imageModel.getImages().size()) % imageModel.getImages().size();
            displayImage();
        }
    }

    private void handleBtnRightAction() {
        if (!imageModel.getImages().isEmpty()) {
            imageIdx = (imageIdx + 1) % imageModel.getImages().size();
            displayImage();
        }
    }

    private void displayImage() {
        if (imageModel.getImages() != null) {
            imageView.setImage(imageModel.getImages().get(imageIdx).getImage());
            System.out.println("FilePath = " + imageModel.getImages().get(imageIdx).getPath());
            System.out.println("Delay = " + imageModel.getImages().get(imageIdx).getDelay());
        }
    }

    @FXML
    private void handlePlay() {
        running = true;
        timer = new Timer(true);
        long delay = imageModel.getImages().get(imageIdx).getDelay();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handleBtnRightAction();
            }
        };
        timer.schedule(task, 0, delay);
        while (running) {
            if (imageModel.getImages().get(imageIdx).getDelay() != delay) {
                timer.schedule(task, 0, imageModel.getImages().get(imageIdx).getDelay());

            }
        }
    }

    @FXML
    private void handlePause() {
        timer.cancel();
        timer.purge();
        running = false;
    }

    @FXML
    private void handleStop() {
        imageView.setImage(imageModel.getImages().get(0).getImage());
        handlePause();
    }

}
