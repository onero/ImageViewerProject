/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewerproject.bll;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author bhp
 */
public class ImageFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".jpg") || 
                file.getName().endsWith(".png") || 
                file.getName().endsWith(".gif") ||
                file.getName().endsWith(".tif") ||
                file.getName().endsWith(".bmp");    
    }

}