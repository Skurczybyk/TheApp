package org.MyApplication.Update;

import org.update4j.Archive;
import org.update4j.Configuration;
import org.update4j.FileMetadata;
import org.update4j.UpdateOptions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Updater {

    public static void update()
    {
        System.out.println("Updating");

    }
    public static void createAppComfiguration() throws IOException {
        System.out.println("Creating Configuration for Application");
        String root = System.getProperty("user.dir");
        String moduleLocation = root+"/App";
        String targetLocation = moduleLocation + "/target";
        Configuration appConfig = Configuration.builder()
                .baseUri("https://drive.google.com/drive/folders/1U3i4krypzVSIyLulAzEdpARo2z6HI3Q_?usp=share_link")
                .basePath("${user.dir}")
                .file(FileMetadata.readFrom(targetLocation + "/App-1.0-SNAPSHOT.jar").modulepath())
                .build();

        try(Writer out = Files.newBufferedWriter(Paths.get(targetLocation + "/config.xml")))
        {appConfig.write(out);}
        System.out.println("Konfiguracja utworzona");
    }
    public static void updateApp() throws Exception {

        URL appUpdateURL = new URL("https://drive.google.com/file/d/19giIdlaa4Nehs3W_AA5PW_bqdBRvDwv3/view?usp=share_link");
        Path updateZip = Paths.get("App-Update.zip");
        Configuration config = null;
        try(Reader in = new InputStreamReader(appUpdateURL.openStream(), StandardCharsets.UTF_8))
        {
            config = Configuration.read(in);
            config.update(UpdateOptions.archive(updateZip));
            Archive.read(updateZip).install();
            System.out.println("Aktualizacja zainstalowana");
        }
        catch (IOException e)
        {
            System.out.println(e.getCause());
            System.out.println("Coś Poszło nie tak. Sprobuje pobrać update później");

        }
    }
}
