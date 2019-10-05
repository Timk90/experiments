package com.patterns.adapter;

public class ImageViewerImpl implements ImageViewer {
    @Override
    public void watchImage(String title, String format) {
        switch (format) {
            case ".bmp":
                System.out.println("Image title: " + title + "" + format);
                break;
            case ".jpeg":
                System.out.println("Image title: " + title + "" + format);
                break;
            case ".png":
                System.out.println("Image title: " + title + "" + format);
                break;
            case ".gif":
                new AnimationImageAdapter().watchImage(title, format);
                break;
            default:
                System.out.println(format + " is not supported format");
                break;
        }
    }
}
