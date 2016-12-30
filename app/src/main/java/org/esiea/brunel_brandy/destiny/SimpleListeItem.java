package org.esiea.brunel_brandy.destiny;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benjamin on 15/12/2016.
 */

public class SimpleListeItem extends AppCompatActivity {

    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_item1);
        recyclerView = (RecyclerView) findViewById(R.id.myListSimple);

        GetPDF.startActionGetPDF(this);

        IntentFilter intentFilter = new IntentFilter(PDF_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new PDFUpdate(), intentFilter);



    }



        public static final String PDF_UPDATE = "org.esiea.brunel_brandy.destiny";

        public class PDFUpdate extends BroadcastReceiver {

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("TAG", "TESTSECUR Update");

                List<String> items = (ArrayList<String>)intent.getSerializableExtra("ma_liste_de_binouze");


                RecyclerSimpleViewAdapter adapter = new RecyclerSimpleViewAdapter(items, android.R.layout.simple_list_item_1);
                recyclerView.setAdapter(adapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(SimpleListeItem.this));
            }
        }




}


