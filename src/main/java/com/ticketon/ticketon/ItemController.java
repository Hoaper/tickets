package com.ticketon.ticketon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ItemController {
    @FXML
    private Button btn_go;
    @FXML
    private Text bd_id;
    @FXML
    private ImageView image;
    @FXML
    private Text tittle;
    @FXML
    private Text rating;
    @FXML
    private Text desc;

    public void onBtnGoClick() {

    }

    public void setData(String _id, String t, String r, String d, String name) {
        bd_id.setText(_id);
        tittle.setText(t);
        rating.setText(r);
        desc.setText(d);
        image.setImage(
                new Image(getClass().getResourceAsStream("img/" + name))
        );
    }

}
