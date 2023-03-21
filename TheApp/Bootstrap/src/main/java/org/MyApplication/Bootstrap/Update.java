package org.MyApplication.Bootstrap;

import java.io.IOException;

public class Update {
    public static void createUpdateConfiguration()
    {
        try {
            org.MyApplication.Update.Updater.createAppComfiguration();
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }
    public static void update()
    {
        try {
            org.MyApplication.Update.Updater.updateApp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
