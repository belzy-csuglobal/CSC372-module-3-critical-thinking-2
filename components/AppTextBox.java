package components;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AppTextBox extends VBox {
  private String dateTime = "";
  private TextField textField = new TextField(this.dateTime);

  public AppTextBox() {
    this.textField.setMaxWidth(180d);
    this.getChildren().add(textField);
    this.setAlignment(Pos.CENTER);
  }

  public String getText() {
    return this.textField.getText();
  }

  public void setText(String text) {
    this.textField.setText(text);
  }
} 