/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewerproject.gui.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class ImageModel {

    private final List<Image> images;

    public ImageModel() {
        images = new ArrayList<>();
    }

    public void addImage(Image imageToAdd) {
        images.add(imageToAdd);
    }

    public List<Image> getImages() {
        return images;
    }

}
