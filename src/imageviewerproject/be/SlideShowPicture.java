/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewerproject.be;

import javafx.scene.image.Image;

public class SlideShowPicture {

    private Image mImage;

    private String mPath;

    private long mDelay;

    public SlideShowPicture(Image image, String path) {
        this.mImage = image;
        this.mPath = path;
        int min = 1000;
        int max = 10000;
        int rand = (int) (Math.random() * max + min);
        mDelay = rand; //Standard 2 seconds
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        this.mImage = image;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public long getDelay() {
        return mDelay;
    }

    public void setDelay(long delay) {
        this.mDelay = delay;
    }

}
