package com.angelhacks.cultureshock;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Spicycurryman on 7/19/14.
 */
public class Country_Activity extends Activity {

    private Button gotocountrybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.country_list);

        addListenerOnButton();



    }





    public void addListenerOnButton() {

        final Context context = this;

        gotocountrybutton = (Button) findViewById(R.id.country_button);

        gotocountrybutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, DestinationList.class);
                startActivity(intent);

            }

        });

    }

}
