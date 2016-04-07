package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;
import th.ac.up.mct.thaitoneapp.domain.KamKuSet;
import th.ac.up.mct.thaitoneapp.ui.KamDiaoSetButton;
import th.ac.up.mct.thaitoneapp.ui.KamKuSetButton;

public class KamKuSetActivity extends ActionBarActivity {
    LinearLayout kamkuMainLayout;
    LayoutInflater inflater;

    List<KamKuSetButton> kamKuSetButtons = new ArrayList<KamKuSetButton>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_ku_set);

        inflater = LayoutInflater.from(this);
        kamkuMainLayout = (LinearLayout) findViewById(R.id.KamkuMainLayout);

        Intent intent = getIntent();
        long KamkuSetID = intent.getLongExtra("KAMKUSET_ID", 0);

        KamKuSet set = KamKuSet.get(KamkuSetID);
        List<KamKuSet> kamKuSets = set.getAll();
        View.OnClickListener kamkusetOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamKuSetButton btn = (KamKuSetButton) v;
                //
                Intent inttentkamkuset = new Intent(KamKuSetActivity.this, KamKuWordsActivity.class);
                inttentkamkuset.putExtra("KAMKUSET_ID", btn.getKamKuSet().getId());
                startActivity(inttentkamkuset);
            }
        };

        kamKuSetButtons.add((KamKuSetButton) findViewById(R.id.kamkusetImageBtn1));
        kamKuSetButtons.add((KamKuSetButton) findViewById(R.id.kamkusetImageBtn2));
        kamKuSetButtons.add((KamKuSetButton) findViewById(R.id.kamkusetImageBtn3));


        for (int i = 0; i < kamKuSetButtons.size(); i++) {
            kamKuSetButtons.get(i).setKamKuSet(kamKuSets.get(i));
            kamKuSetButtons.get(i).setOnClickListener(kamkusetOnclickListener);
            int bid = getResources().getIdentifier(kamKuSets.get(i).picture, "drawable", getPackageName());
            kamKuSetButtons.get(i).setBackgroundResource(bid);
        }

    }

}



//        List<KamKuSet> kamKuSetList = KamKuSet.getAll();
//
//        View.OnClickListener kamkusetOnclickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                KamKuSetButton btn = (KamKuSetButton)v;
//                Intent inttentkamku = new Intent(KamKuSetActivity.this,KamKuWordsActivity.class);
//                inttentkamku.putExtra("KAMKUSET_ID",btn.getKamKuSet().getId());
//                startActivity(inttentkamku);
//            }
//        };
//
//        for (KamKuSet k : kamKuSetList) {
//            KamKuSetButton kamkusetBn = new KamKuSetButton(this);
//
//            int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
//            kamkusetBn.setBackgroundResource(id);
//            kamkusetBn.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            kamkusetBn.setKamKuSet(k);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(450, 150);
//            params.setMargins(0, 0, 0, 20);
//            kamkusetBn.setLayoutParams(params);
//            kamkusetBn.setOnClickListener(kamkusetOnclickListener);
//            kamkuMainLayout.addView(kamkusetBn);
//        }
