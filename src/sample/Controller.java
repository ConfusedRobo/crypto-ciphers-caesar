package sample;

import cipher.substitution.CaesarDecoder;
import cipher.substitution.CaesarEncoder;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private Spinner<Integer> key;

    @FXML
    private void setEncode() throws IOException {
        Path path = FileSystems.getDefault().getPath(textField.getText());
        if (!Files.exists(path)) {
            textField.setText("Invalid Path!");
            return;
        }

        CaesarEncoder encoder = new CaesarEncoder();
        encoder.parseFile(path, key.getValue());
        encoder.encrypt();
        encoder.encryptFile(path);
        textField.setText("Encryption Completed");
    }

    @FXML
    private void setDecode() throws IOException {
        Path path = FileSystems.getDefault().getPath(textField.getText());
        if (!Files.exists(path)) {
            textField.setText("Invalid Path!");
            return;
        }

        CaesarDecoder decoder = new CaesarDecoder();
        decoder.parseFile(path, key.getValue());
        decoder.decrypt();
        decoder.decryptFile(path);
        textField.setText("Decryption Completed");
    }
}
