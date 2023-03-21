package org.MyApplication.Application;

import org.MyApplication.Update.Updater;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main() {
        System.out.println("Hello world from App!");
        System.out.println(System.getProperty("user.dir"));
        Version version = new Version(1.0);
    }
}