package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class AppMenuBar extends MenuBar {
  Menu mainMenu = new Menu();

  public AppMenuBar(String label) {
      this.mainMenu.setText(label);
      this.getMenus().add(this.mainMenu);
  }

  /**
   * Create a MenuItem and add it to the MenuBar.
   */
  public void createMenuItem(String label, EventHandler<ActionEvent> eventHandler) {
      MenuItem menuItem = new MenuItem(label);
      menuItem.setOnAction(eventHandler);
      mainMenu.getItems().add(menuItem);
  }
}