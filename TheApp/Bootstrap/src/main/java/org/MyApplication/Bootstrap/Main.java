package org.MyApplication.Bootstrap;

import org.MyApplication.Update.Updater;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world from Bootstrap!");
        //Updater.createAppComfiguration();

        Update.update();

    }

}