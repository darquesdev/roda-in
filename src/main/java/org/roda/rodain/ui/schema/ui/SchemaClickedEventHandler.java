package org.roda.rodain.ui.schema.ui;

import javafx.event.EventHandler;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 * @author Andre Pereira apereira@keep.pt
 * @since 21-09-2015.
 */
public class SchemaClickedEventHandler implements EventHandler<MouseEvent> {
  private TreeView<String> treeView;

  /**
   * Creates a new SchemaClickedEventHandler
   *
   * @param pane
   *          The SchemaPane that contains the tree of SchemaNodes
   */
  public SchemaClickedEventHandler(TreeView<String> treeView) {
    this.treeView = treeView;
  }

  /**
   * Updates the InspectionPane with the items that has received the clicked
   * event.
   *
   * @param mouseEvent
   *          The mouse event triggered.
   */
  @Override
  public void handle(MouseEvent mouseEvent) {
    /*
     * if (mouseEvent.getClickCount() == 2) {
     * treeView.getSelectionModel().clearSelection(); }
     */
  }
}
