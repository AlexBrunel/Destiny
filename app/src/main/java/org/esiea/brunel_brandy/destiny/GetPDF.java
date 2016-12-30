package org.esiea.brunel_brandy.destiny;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetPDF extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String GetPDF = "org.esiea.brunel_brandy.destiny.action.FOO";

    public GetPDF() {
        super("GetPDF");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionGetPDF(Context context) {
        Intent intent = new Intent(context, GetPDF.class);
        intent.setAction(GetPDF);
        context.startService(intent);
    }
    public ArrayList<String> biere;
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (GetPDF.equals(action)) {
                biere = handleActionGetPDF();


                Intent i = new Intent(SimpleListeItem.PDF_UPDATE);
                i.putExtra("ma_liste_de_binouze", biere);

                LocalBroadcastManager.getInstance(this).sendBroadcast(i);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private ArrayList<String> handleActionGetPDF() {
        // TODO: Handle action Foo
        Log.i("Logtest", "test");

        Log.d("TAG", " Thread service:" + Thread.currentThread().getName());
        URL url = null;
        try {
            url = new URL("http://binouze.fabrigli.fr/bieres.json");
            HttpURLConnection co = (HttpURLConnection) url.openConnection();
            co.connect();
            if (HttpURLConnection.HTTP_OK == co.getResponseCode()) {
                return copyInputStreamToFile(co.getInputStream(),
                        new File(getCacheDir(),"bieres.json"));

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return new ArrayList<String>();

    }
        private  ArrayList<String> copyInputStreamToFile(InputStream in, File file){

            ArrayList<String> mylist = new ArrayList<>();
            try{


                OutputStream out = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                StringBuilder sb = new StringBuilder();
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                    sb.append(new String(buf, 0, len));
                }
                Log.i("sb", sb.toString());

                JSONArray biere = new JSONArray(sb.toString());
                for (int i = 0; i < biere.length(); i++) {
                    JSONObject c = biere.getJSONObject(i);
                    String name = c.getString("name");
                    mylist.add(name);
                    Log.i("name : " , name);
                }

                out.close();
                in.close();
            }catch(Exception e){
                e.printStackTrace();
                Log.i("error : " , e.getMessage());
            }
            return mylist;
        }
    }


