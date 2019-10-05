package com.patterns.adapter;

public class Main {
    public static void main(String[] args) {

        ImageViewerImpl iw = new ImageViewerImpl();

        iw.watchImage("Picture", ".bmp");
        iw.watchImage("Animation", ".gif");
        iw.watchImage("Picture2", ".jpeg");
        iw.watchImage("Picture3", ".png");
        iw.watchImage("Picture3", ".mpeg4");
    }
}
