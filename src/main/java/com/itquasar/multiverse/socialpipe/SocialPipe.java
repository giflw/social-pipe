package com.itquasar.multiverse.socialpipe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Hello world!
 */
public class SocialPipe extends Application {

    private static final String APPLICATION_TITLE = "Social P|PE";

    public static void main(String[] args) {
        Application.launch(SocialPipe.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        var screenSize = Screen.getPrimary().getBounds();

        var webView = new WebView();
        var webEngine = webView.getEngine();

        if (!webEngine.isJavaScriptEnabled()) {
            webEngine.setJavaScriptEnabled(true);
        }

        String index = "/index.html";
        URL url = this.getClass().getResource(index);
        String urlStr = url.toString();
        webEngine.load(urlStr);

        var scene = new Scene(webView, screenSize.getMaxX() * 3 / 4, screenSize.getMaxY() * 3 / 4);

        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
