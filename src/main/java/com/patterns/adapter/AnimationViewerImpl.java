package com.patterns.adapter;

public class AnimationViewerImpl implements AnimationViewer {
    @Override
    public void watchAnimation(String title) {
        System.out.println("Watching " + title + ".gif");
    }
}
