import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import components.*;

public class Main extends Application {
  private AppMenuBar menuBar = new AppMenuBar("Menu");
  private AppTextBox textBox = new AppTextBox();
  private VBox contentBox = new VBox(this.menuBar, this.textBox);
  private Stage stage;

  public Main() {
    VBox.setVgrow(this.textBox, Priority.ALWAYS);

    this.menuBar.createMenuItem("Get Date & Time",
      (ActionEvent event) -> this.textBox.setText(this.getDateTime()));

    this.menuBar.createMenuItem("Export to Log",
      (ActionEvent event) -> this.exportToLog());
    
    this.menuBar.createMenuItem("Change Hue",
      (ActionEvent event) -> this.contentBox.setBackground(this.getRandomHue()));

    this.menuBar.createMenuItem("Exit",
      (ActionEvent event) -> this.stage.close());
  }

  /**
   * Get the current date and time and return it as a string.
   */
  private String getDateTime() {
    DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return formatter.format(LocalDateTime.now());
  }

  /**
   * Export the contents of the text box to log.txt.
   */
  private void exportToLog() {
    File logFile = new File("log.txt");

    try {
      BufferedWriter writer =
        new BufferedWriter(new FileWriter(logFile, true));
      writer.write(this.textBox.getText() + "\n");
      writer.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Return a random orange hue as a background for a pane.
   */
  private Background getRandomHue() {
    int green = new Random().nextInt(90) + 100;
    int blue= new Random().nextInt(100);

    return new Background(
      new BackgroundFill(Color.rgb(255, green, blue), null, null));
  }

  @Override
  public void start(Stage stage) {
    this.stage = stage;
    this.stage.setTitle("Creating a User Interface II");
    this.stage.setScene(new Scene(this.contentBox, 200, 100));
    this.stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}