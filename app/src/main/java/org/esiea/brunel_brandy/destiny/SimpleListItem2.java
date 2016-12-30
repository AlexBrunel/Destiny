package org.esiea.brunel_brandy.destiny;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Benjamin on 28/12/2016.
 */

public class SimpleListItem2 extends AppCompatActivity  {
    List<String> items ;
    RecyclerSimpleViewAdapter2 adapter;
    RecyclerView recyclerView;
    EditText txt;
    EditText txt1;
    EditText num;
    EditText adresse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_item2);
        recyclerView = (RecyclerView) findViewById(R.id.myListSimple);

        items = new ArrayList<String>();
        items.add("Ma liste de BAR");

        adapter = new RecyclerSimpleViewAdapter2(items , android.R.layout.simple_list_item_1);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Enregistrer(View v) {
        txt=(EditText) findViewById(R.id.editText);
        String text =txt.getText().toString();
        txt1=(EditText) findViewById(R.id.editText2);
        String text1 =txt1.getText().toString();
        num=(EditText) findViewById(R.id.editText5);
        String text2 =num.getText().toString();
        adresse=(EditText) findViewById(R.id.editText6);
        String text3 =adresse.getText().toString();
        items.add(text + "\n" +text1+"\n"+text2+"\n"+text3);
        adapter=new RecyclerSimpleViewAdapter2(items,android.R.layout.simple_list_item_1);
        recyclerView.setAdapter(adapter);
        Toast.makeText(this,"Bar ajouté !", Toast.LENGTH_LONG).show();
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.beer1)
                        .setContentTitle("Destiny")
                        .setContentText("Vous avez ajouté un bar ");

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }

}
