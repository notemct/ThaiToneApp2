package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.activeandroid.ActiveAndroid;


public class Home extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        ActiveAndroid.initialize(this);

       // Intent intent = new Intent(this,Home.class);
       // startActivity(intent);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClickKamdiao(View v){
        Intent i = new Intent(getApplicationContext(),KamDiaoSetActivity.class);
        startActivity(i);
    }
    public void onClickKamku(View v){
        Intent i = new Intent(getApplicationContext(),KamKuSetActivity.class);
        startActivity(i);
    }
    public void onClickKamgroup(View v){
        Intent i = new Intent(getApplicationContext(),KamGroupSetActivity.class);
        startActivity(i);
    }
    public void onClickSymbol(View v){
        Intent i = new Intent(getApplicationContext(),SymbolSetActivity.class);
        startActivity(i);
    }
}



