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

import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;
import th.ac.up.mct.thaitoneapp.domain.KamKuSet;
import th.ac.up.mct.thaitoneapp.ui.KamDiaoSetButton;
import th.ac.up.mct.thaitoneapp.ui.KamKuSetButton;

public class KamKuSetActivity extends ActionBarActivity {
    LinearLayout kamkuMainLayout;

    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_ku_set);

        inflater = LayoutInflater.from(this);

        kamkuMainLayout = (LinearLayout) findViewById(R.id.KamkuMainLayout);
        List<KamKuSet> kamKuSetList = KamKuSet.getAll();

        View.OnClickListener kamkusetOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamKuSetButton btn = (KamKuSetButton)v;
                Intent inttentkamku = new Intent(KamKuSetActivity.this,KamKuWordsActivity.class);
                inttentkamku.putExtra("KAMKUSET_ID",btn.getKamKuSet().getId());
                startActivity(inttentkamku);
            }
        };

        for (KamKuSet k : kamKuSetList) {
            KamKuSetButton kamkusetBn = new KamKuSetButton(this);

            int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
            kamkusetBn.setBackgroundResource(id);
            kamkusetBn.setKamKuSet(k);
            kamkusetBn.setLayoutParams(new LinearLayout.LayoutParams(850,300 ));
            kamkusetBn.setOnClickListener(kamkusetOnclickListener);
            kamkuMainLayout.addView(kamkusetBn);
        }
    }
}
