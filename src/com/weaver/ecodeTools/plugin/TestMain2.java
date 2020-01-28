package com.weaver.ecodeTools.plugin;


import javax.swing.*;


public class TestMain2 {

    public void t(TestMain testMain){

        testMain.abc = "1";

    }
    /*private static String mInitUrl = "http://127.0.0.1:8001";
    private static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    *//*public static void main(String[] args) throws URISyntaxException, IOException {
        Desktop d = Desktop.getDesktop();

        URI uri = new URI(TestMain2.mInitUrl);

        d.browse(uri);
    }*//*


    public static void main(String[] args) {
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        JFrame frame = new JFrame("JxBrowser");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       *//* VBox box = new VBox(10);
        HBox urlBox = new HBox(10);
        final javafx.scene.control.TextField urlTextField = new javafx.scene.control.TextField();
        urlTextField.setText(mInitUrl);
        javafx.scene.control.Button go = new Button("go");
        urlTextField.setPrefWidth(WIDTH - 80);
        urlBox.getChildren().addAll(urlTextField, go);

        WebView view1 = new WebView();
        Double widthDouble = new Integer(WIDTH).doubleValue();
        Double heightDouble = new Integer(HEIGHT).doubleValue();
        view1.setMinSize(widthDouble, heightDouble);
        view1.setPrefSize(widthDouble, heightDouble);

        box.getChildren().add(urlBox);
        box.getChildren().add(view1);*//*
        frame.add(view, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL(mInitUrl);
    }*/

}
