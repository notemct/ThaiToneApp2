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

import th.ac.up.mct.thaitoneapp.domain.KamGroupSet;
import th.ac.up.mct.thaitoneapp.domain.KamKuSet;
import th.ac.up.mct.thaitoneapp.ui.KamGroupSetButton;
import th.ac.up.mct.thaitoneapp.ui.KamKuSetButton;

public class KamGroupSetActivity extends ActionBarActivity {

    LinearLayout kamgroupMainLayout;

    LayoutInflater inflater;
    List<KamGroupSetButton> kamGroupSetButtons = new ArrayList<KamGroupSetButton>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_group_set);

    inflater = LayoutInflater.from(this);
    kamgroupMainLayout = (LinearLayout) findViewById(R.id.KamgroupMainLayout);

        Intent intent = getIntent();
        long KamgroupSetID = intent.getLongExtra("KAMGROUPSET_ID", 0);

        KamGroupSet set = KamGroupSet.get(KamgroupSetID);
        List<KamGroupSet> kamGroupSets = set.getAll();
        View.OnClickListener kamgroupsetOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamGroupSetButton btn = (KamGroupSetButton) v;
                //
                Intent inttentkamgroupset = new Intent(KamGroupSetActivity.this, KamGroupWordsActivity.class);
                inttentkamgroupset.putExtra("KAMGROUPSET_ID", btn.getKamGroupSet().getId());
                startActivity(inttentkamgroupset);
            }
        };

        kamGroupSetButtons.add((KamGroupSetButton) findViewById(R.id.kamgroupsetImageBtn1));
        kamGroupSetButtons.add((KamGroupSetButton) findViewById(R.id.kamgroupsetImageBtn2));
        kamGroupSetButtons.add((KamGroupSetButton) findViewById(R.id.kamgroupsetImageBtn3));
        kamGroupSetButtons.add((KamGroupSetButton) findViewById(R.id.kamgroupsetImageBtn4));
        kamGroupSetButtons.add((KamGroupSetButton) findViewById(R.id.kamgroupsetImageBtn5));


        for (int i = 0; i < kamGroupSetButtons.size(); i++) {
            kamGroupSetButtons.get(i).setKamGroupSet(kamGroupSets.get(i));
            kamGroupSetButtons.get(i).setOnClickListener(kamgroupsetOnclickListener);
            int bid = getResources().getIdentifier(kamGroupSets.get(i).picture, "drawable", getPackageName());
            kamGroupSetButtons.get(i).setBackgroundResource(bid);
        }

    }

}

//    View.OnClickListener kamgroupsetOnclickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            KamGroupSetButton btn = (KamGroupSetButton)v;
//            //
//            Intent inttentkamgroup = new Intent(KamGroupSetActivity.this,KamGroupWordsActivity.class);
//            inttentkamgroup.putExtra("KAMGROUPSET_ID",btn.getKamGroupSet().getId());
//            startActivity(inttentkamgroup);
//
//        }
//    };
//
//    for (KamGroupSet k : kamGroupSetList) {
//        KamGroupSetButton kamgroupsetBn = new KamGroupSetButton(this);
//
//        int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
//        Log.i("ID", Integer.toString(id));
//        kamgroupsetBn.setBackgroundResource(id);
//        kamgroupsetBn.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        kamgroupsetBn.setKamGroupSet(k);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(450, 150);
//        params.setMargins(0, 0, 0, 20);
//        kamgroupsetBn.setLayoutParams(params);
//        kamgroupsetBn.setOnClickListener(kamgroupsetOnclickListener);
//        kamgroupMainLayout.addView(kamgroupsetBn);
//    }
//}
//
//
//}
