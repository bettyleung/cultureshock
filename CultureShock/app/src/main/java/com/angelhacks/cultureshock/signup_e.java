package com.angelhacks.cultureshock;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.view.View;
/**
 * Created by Spicycurryman on 7/19/14.
 */
public class signup_e extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.signup);



    }





    public void sendMsg(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DestinationList.class);
        startActivity(intent);
    }

}
