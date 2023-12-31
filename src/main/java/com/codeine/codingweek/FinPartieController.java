package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class FinPartieController implements Initializable {

    @FXML
    private Label percentage;

    @FXML
    private Label resultat;

    private FlashCardGame fcg;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public FinPartieController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int nbQuestions = fcg.getPileCurrentPile().getCards().size();
        int nbErreurs = fcg.getCurrentIndexApprentissageList() - nbQuestions;
        float div = (float) this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).getCards().size()/this.fcg.getCurrentIndexApprentissageList();
        float score = ((float) 100.0*(div));

        resultat.setText(nbErreurs + " erreurs parmis les " + nbQuestions + " questions");
        percentage.setText(df.format(score) + "%");
    }

    @FXML
    public void goStatistiques() throws IOException {
        ViewSwitcher.switchTo(View.STATISTIQUES_PAGE_PILE);
    }

    @FXML
    public void goAccueil() throws IOException {
        ViewSwitcher.switchTo(View.ACCUEIL);
    }

    @FXML
    public void rejouer(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.switchTo(View.APPRENTISSAGE_FORM_SELECT_PARAMETERS);
    }
}
