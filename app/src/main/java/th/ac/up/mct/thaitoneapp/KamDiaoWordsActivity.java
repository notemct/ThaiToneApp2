package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;
import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;
import th.ac.up.mct.thaitoneapp.ui.KamDiaoWordButton;

public class KamDiaoWordsActivity extends ActionBarActivity {

    LinearLayout kamdiaoWordsMainLayout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_diao_words);

        inflater = LayoutInflater.from(this);
        kamdiaoWordsMainLayout = (LinearLayout)findViewById(R.id.KamdiaoWordsMainLayout);

        Intent intent = getIntent();
        long KamdiaoSetID = intent.getLongExtra("KAMDIAOSET_ID", 0);

        //Log.i("KamdiaoSetID", Long.toString(KamdiaoSetID));
        KamDiaoSet set = KamDiaoSet.get(KamdiaoSetID);

        View.OnClickListener kamWordOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamDiaoWordButton btn = (KamDiaoWordButton)v;
                //
                Intent inttentkamdiao = new Intent(KamDiaoWordsActivity.this,KamdiaoActivity.class);
                inttentkamdiao.putExtra("KAMDIAO_ID", btn.getKamDiao().getId());
                startActivity(inttentkamdiao);
            }
        };


        // เอาค่าออกมาเป็นButton
        for(KamDiao k : set.kamDiaos()){
            KamDiaoWordButton kamdiaowordbtn = new KamDiaoWordButton(this);
            int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
            Log.i("ID", Integer.toString(id));
            kamdiaowordbtn.setBackgroundResource(id);
            kamdiaowordbtn.setKamDiao(k);
            kamdiaowordbtn.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
            // kamdiaoBtn.setText(k.kamThai);
            kamdiaowordbtn.setOnClickListener(kamWordOnClickListener);
            kamdiaoWordsMainLayout.addView(kamdiaowordbtn);
        }
    }
}