package com.dealio.client;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn = (Button) findViewById(R.id.goBtn);

        if (networkStatus() == NetworkInfo.State.CONNECTED) {
            btn.setEnabled(true);
        }

    }



    public NetworkInfo.State networkStatus() {
        ConnectivityManager cMgr = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cMgr.getActiveNetworkInfo();

        return netInfo.getState();
    }
}
