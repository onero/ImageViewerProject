/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewerproject.gui.model;

import imageviewerproject.be.SlideShowPicture;
import java.util.ArrayList;
import java.util.List;

public class ImageModel {

    private final List<SlideShowPicture> images;

    public ImageModel() {
        images = new ArrayList<>();
    }

    public void addImage(SlideShowPicture imageToAdd) {
        images.add(imageToAdd);
    }

    public List<SlideShowPicture> getImages() {
        return images;
    }

}
