Sistem për menagjimin e një shkolle.

**Dependecies:**
JavaFX - SDK Runtime library

**IntelliJ Idea JavaFX integration:**

1. Import JavaFX SDK --> https://gluonhq.com/products/javafx/
    1.1 Just import the lib folder in the SDK
   
2. Set up the VM (depends on the Operating System that you use)
    2.1 `Run -> Edit Configurations -> Modify Options -> Add VM Options`
    2.2 At the VM options write:
        2.3 Linux/MAC ->` --module-path /path/to/javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml`
        2.4 Windows -> `--module-path "\path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml`


For more detailed information on installing JavaFX in IntelliJ and other IDE-s visit:   https://openjfx.io/openjfx-docs/


