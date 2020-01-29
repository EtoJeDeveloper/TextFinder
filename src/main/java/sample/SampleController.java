package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class SampleController {
    @FXML
    private Label pathLabel;

    @FXML
    private HBox hBoxSearch;

    @FXML
    private Label helloLabel;

    @FXML
    private TextField searchTextId;

    @FXML
    private TextField fileExtensionId;

    public void buttonChooseAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            pathLabel.setText(selectedDirectory.getPath());
            hBoxSearch.setVisible(true);
            helloLabel.setVisible(false);
            treeViewFolders.setVisible(true);
        } else {
            System.out.println("Dis");
        }
    }

    @FXML
    private TreeView<File> treeViewFolders;

    public void getTreeFolder(ActionEvent event) {
        TreeItem<File> treeItem = new TreeItem<>(new File(pathLabel.getText()));
        Finder finder = new Finder(new File(pathLabel.getText()), searchTextId.getText(), fileExtensionId.getText());

        TreeItem<File> treeChild = new TreeItem<>(finder.findingText());
        treeItem.getChildren().add(treeChild);

        treeViewFolders.setRoot(treeItem);
    }
}
