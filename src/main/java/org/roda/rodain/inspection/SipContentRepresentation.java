package org.roda.rodain.inspection;

import javafx.scene.control.TreeItem;
import org.roda.rodain.rules.sip.SipRepresentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Andre Pereira apereira@keep.pt
 * @since 07-03-2016.
 */
public class SipContentRepresentation extends TreeItem<Object> {
  private static final Comparator comparator = createComparator();
  private SipRepresentation representation;

  /**
   * Creates a new TreeItem, representing a directory.
   *
   * @param representation
   *          The SipRepresentation that will be associated to the item.
   */
  public SipContentRepresentation(SipRepresentation representation) {
    // super();
    this.representation = representation;
    // this.setGraphic(new
    // ImageView(FontAwesomeImageCreator.generate(FontAwesomeImageCreator.times)));

    this.setValue(representation.getName());
  }

  /**
   * Sorts the item's children.
   * <p/>
   * <p>
   * The comparator used by this method forces the directories to appear before
   * the files. Between items of the same class the sorting is done comparing
   * the items' values.
   * </p>
   */
  public void sortChildren() {
    ArrayList<TreeItem<Object>> aux = new ArrayList<>(getChildren());
    Collections.sort(aux, comparator);
    getChildren().setAll(aux);

    for (TreeItem ti : getChildren()) {
      if (ti instanceof SipContentDirectory)
        ((SipContentDirectory) ti).sortChildren();
    }
  }

  private static Comparator createComparator() {
    return new Comparator<TreeItem>() {
      @Override
      public int compare(TreeItem o1, TreeItem o2) {
        if (o1.getClass() == o2.getClass()) { // sort items of the same class by
          // value
          String s1 = (String) o1.getValue();
          String s2 = (String) o2.getValue();
          return s1.compareToIgnoreCase(s2);
        }
        // directories must appear first
        if (o1 instanceof SipContentDirectory)
          return -1;
        return 1;
      }
    };
  }
}
