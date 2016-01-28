package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;
import th.ac.up.mct.thaitoneapp.domain.KamKu;
import th.ac.up.mct.thaitoneapp.ui.KamkuButton;

public class KamkuActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kamku);

        ImageView kamkuImage = (ImageView) findViewById(R.id.kamkuImage);

        Intent intent = getIntent();
        long kamkuId = intent.getLongExtra("KAMKU_ID", 0);
        KamKu kamKu = KamKu.get(kamkuId);
        int id = getResources().getIdentifier(kamKu.picture,"drawable",getPackageName());
        kamkuImage.setBackgroundResource(id);


    }
}