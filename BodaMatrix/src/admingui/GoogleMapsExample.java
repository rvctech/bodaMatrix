package admingui;

import java.awt.BorderLayout;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class GoogleMapsExample extends JPanel {
    private WebView webView;

    public GoogleMapsExample() {
        setLayout(new BorderLayout());

        // Set up the WebView
        JFXPanel jfxPanel = new JFXPanel();
        add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            webView = new WebView();
            jfxPanel.setScene(new Scene(webView));
            webView.getEngine().load("https://www.google.com/maps?hl=en");
            
            //Testing Bing maps 
           // webView.getEngine().load("https://dev.virtualearth.net/REST/v1/Imagery/Map/Road?mapArea=37.7749,-122.4194,14&mapSize=600,400&key=AvSBsn9P5tSl6rLMqY_1BQhdB_bK9nFSIM2-RkhLUdtYHRftFIx_U3ThU9mNKWRu");
           // webView.getEngine().load("https://www.google.com/maps/embed/v1/view?center=37.7749,-122.4194&zoom=14&key=AIzaSyB1X6zNA0EuKeAKiaUf0saETCY1nqVmd9U");
        });
    }
}
