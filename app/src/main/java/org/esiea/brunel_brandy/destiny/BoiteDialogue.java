package org.esiea.brunel_brandy.destiny;
import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


/**
 * Created by Benjamin on 14/12/2016.
 */

public class BoiteDialogue extends Activity {
    /** Affichage de la liste des sexes **/
    private ListView mListSexe = null;
    /** Affichage de la liste des langages connus **/
    private ListView mListPro = null;
    /** Bouton pour envoyer le sondage **/
    private Button mSend = null;

    /** Contient les deux sexes **/
    private String[] mSexes = {"Masculin", "Feminin"};
    /** Contient différents langages de programmation **/
    private String[] mLangages = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);


        //On récupère les trois vues définies dans notre layout
        mListSexe = (ListView) findViewById(R.id.listSexe);
        mListPro = (ListView) findViewById(R.id.listProg);
        mSend = (Button) findViewById(R.id.send);

        //Une autre manière de créer un tableau de chaînes de caractères
        mLangages = new String[]{"♥", "♥ ♥", "♥ ♥ ♥", "♥ ♥ ♥ ♥"};


        //On ajoute un adaptateur qui affiche des boutons radio (c'est l'affichage à considérer quand on ne peut
        //sélectionner qu'un élément d'une liste)
        mListSexe.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mSexes));
        //On déclare qu'on sélectionne de base le premier élément (Masculin)
        mListSexe.setItemChecked(0, true);

        //On ajoute un adaptateur qui affiche des cases à cocher (c'est l'affichage à considérer quand on peut sélectionner
        //autant d'éléments qu'on veut dans une liste)
        mListPro.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mLangages));
        //On déclare qu'on sélectionne de base le second élément (Féminin)
        mListPro.setItemChecked(1, true);

        //Que se passe-t-il dès qu'on clique sur le bouton ?
        mSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(BoiteDialogue.this, "Merci ! Les données ont été envoyées à Alex et Benjamin!", Toast.LENGTH_LONG).show();

                //On déclare qu'on ne peut plus sélectionner d'élément
                mListSexe.setChoiceMode(ListView.CHOICE_MODE_NONE);
                //On affiche un layout qui ne permet pas de sélection
                mListSexe.setAdapter(new ArrayAdapter<String>(BoiteDialogue.this, android.R.layout.simple_list_item_1,
                        mSexes));

                //On déclare qu'on ne peut plus sélectionner d'élément
                mListPro.setChoiceMode(ListView.CHOICE_MODE_NONE);
                //On affiche un layout qui ne permet pas de sélection
                mListPro.setAdapter(new ArrayAdapter<String>(BoiteDialogue.this, android.R.layout.simple_list_item_1, mLangages));

                //On désactive le bouton
                mSend.setEnabled(false);
            }
        });
    }
}


