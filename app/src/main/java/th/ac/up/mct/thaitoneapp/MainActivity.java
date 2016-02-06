package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.activeandroid.ActiveAndroid;
import java.util.List;
import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;

public class MainActivity extends ActionBarActivity {
    private Handler Handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ActiveAndroid.initialize(this);

        Handler= new Handler();
        Handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent Intent = new Intent(MainActivity.this, Home.class);
                startActivity(Intent);
                finish();


            }
        }, 3000);

    }
}