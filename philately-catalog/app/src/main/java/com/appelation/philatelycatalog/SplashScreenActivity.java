package com.appelation.philatelycatalog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by kparthasarathy on 29-02-2016.
 * http://www.iconarchive.com/show/simple-cute-icons-by-tanitakawkaw/stamp-icon.html
 */
public class SplashScreenActivity extends Activity {
    Activity myActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        myActivity = this;
        Handler hdlr = new Handler();
        hdlr.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (myActivity != null) {
                    Intent intent = new Intent();
                    intent.setClass(myActivity, LoginActivity.class);
                    myActivity.startActivity(intent);
                    myActivity.finish();
                }
            }
        }, 5000);
    }

}
