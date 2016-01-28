package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.List;

import th.ac.up.mct.thaitoneapp.domain.KamKu;
import th.ac.up.mct.thaitoneapp.domain.KamKuSet;
import th.ac.up.mct.thaitoneapp.ui.KamKuWordButton;

public class KamKuWordsActivity extends ActionBarActivity {

    LinearLayout kamkuWordsMainLayout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_ku_words);

        inflater = LayoutInflater.from(this);
        kamkuWordsMainLayout = (LinearLayout)findViewById(R.id.kamkuWordMainLayout);

        Intent intent = getIntent();
        long KamkuSetID = intent.getLongExtra("KAMKUSET_ID", 0);
        KamKuSet set = KamKuSet.get(KamkuSetID);

        View.OnClickListener kamkuWordOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamKuWordButton btn = (KamKuWordButton)v;
                //
                Intent inttentkamku = new Intent(KamKuWordsActivity.this,KamkuActivity.class);
                inttentkamku.putExtra("KAMKU_ID", btn.getKamKu().getId());
                startActivity(inttentkamku);
            }
        };

        for(KamKu k : set.kamkus()){
            KamKuWordButton kamkuwordbtn = new KamKuWordButton(this);
            int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
            Log.i("ID", Integer.toString(id));
            kamkuwordbtn.setBackgroundResource(id);
            kamkuwordbtn.setKamKu(k);
            kamkuwordbtn.setLayoutParams(new LinearLayout.LayoutParams(850, 300));
            // kamdiaoBtn.setText(k.kamThai);
            kamkuwordbtn.setOnClickListener(kamkuWordOnClickListener);
            kamkuWordsMainLayout.addView(kamkuwordbtn);
        }
    }

}
