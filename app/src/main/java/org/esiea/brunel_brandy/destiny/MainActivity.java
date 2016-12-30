package org.esiea.brunel_brandy.destiny;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add (View v) {

        Intent i = new Intent(this, AjouterContact.class);
        startActivity(i);
    }

    public void actsms (View v) {
        new AlertDialog.Builder(this).setTitle("Warning").setMessage("Vous allez pouvoir envoyer un message à un compagnon de la bière ,êtes-vous sûr ?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent sms = new Intent(MainActivity.this, EnvoyerSMS.class);
                        startActivity(sms);

                    }
                })
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                    }
                }).show();
    }

    public void actmap (View v) {

        Intent map = new Intent(this, MapsActivity.class);
        startActivity(map);
    }

    public void actdialogue (View v) {

        Intent map = new Intent(this, BoiteDialogue.class);
        startActivity(map);
    }
    public void liste (View v) {

        Intent l = new Intent(this, SimpleListItem2.class);
        startActivity(l);
    }

    public void Button (View v) {

        Intent map = new Intent(this,SimpleListeItem.class);
        startActivity(map);



        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.beer1)
                        .setContentTitle("Destiny")
                        .setContentText("Toutes les bières du monde");

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }








}
