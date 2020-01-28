package com.weaver.ecodeTools.plugin;


import java.io.File;

public class TestMain {

    public String abc;

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    /* private static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static final String url = "http://127.0.0.1:8001";
    private static final String urlStart = "http://";

    *//**
     * @param args
     *//*
    public static void main(String[] args) {
        JFrame frame = new JFrame("嵌入浏览器");
        final JFXPanel webBrowser = new JFXPanel();
        frame.setLayout(new BorderLayout());
        frame.add(webBrowser, BorderLayout.CENTER);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                Group root = new Group();
                Scene scene = new Scene(root, WIDTH, HEIGHT);
                webBrowser.setScene(scene);
                Double widthDouble = new Integer(WIDTH).doubleValue();
                Double heightDouble = new Integer(HEIGHT).doubleValue();

                VBox box = new VBox(10);
                HBox urlBox = new HBox(10);
                final TextField urlTextField = new TextField();
                urlTextField.setText(url);
                Button go = new Button("go");
                urlTextField.setPrefWidth(WIDTH - 80);
                urlBox.getChildren().addAll(urlTextField, go);

                WebView view = new WebView();
                view.setMinSize(widthDouble, heightDouble);
                view.setPrefSize(widthDouble, heightDouble);
                final WebEngine eng = view.getEngine();
                eng.load(url);
                root.getChildren().add(view);

                box.getChildren().add(urlBox);
                box.getChildren().add(view);
                root.getChildren().add(box);

                go.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!urlTextField.getText().startsWith(urlStart)) {
                            eng.load(urlStart + urlTextField.getText());
                        } else {
                            eng.load(urlTextField.getText());
                        }
                    }
                });
            }
        });

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation((screenWidth - WIDTH) / 2, (screenHeight - HEIGHT) / 2);
        frame.setVisible(true);
    }*/

}
