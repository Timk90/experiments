package com.patterns.adapter;

public class AnimationImageAdapter implements ImageViewer {

    private AnimationViewer animationViewer;

    @Override
    public void watchImage(String title, String format) {
        if (format.equalsIgnoreCase(".gif")) {
            animationViewer = new AnimationViewerImpl();
            animationViewer.watchAnimation(title);
        }
    }
}
