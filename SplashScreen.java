package riaz.example.com.newzapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RIAZ on 1/11/17.
 */

public class SplashScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);

        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        },3000);
    }
}
