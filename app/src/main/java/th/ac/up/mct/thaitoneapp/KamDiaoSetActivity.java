package th.ac.up.mct.thaitoneapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;
import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;
import th.ac.up.mct.thaitoneapp.ui.KamDiaoSetButton;

public class KamDiaoSetActivity extends ActionBarActivity {

    LinearLayout KamdiaosetMainLayout;

    LayoutInflater inflater;
    List<KamDiaoSetButton> kamDiaosetButtons = new ArrayList<KamDiaoSetButton>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_diao_set);

        inflater = LayoutInflater.from(this);
        KamdiaosetMainLayout = (LinearLayout) findViewById(R.id.KamdiaosetMainLayout);

        Intent intent = getIntent();
        long KamdiaoSetID = intent.getLongExtra("KAMDIAOSET_ID", 0);

        KamDiaoSet set = KamDiaoSet.get(KamdiaoSetID);
        List<KamDiaoSet> kamDiaoSets = set.getAll();
        View.OnClickListener kamdiaosetOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamDiaoSetButton btn = (KamDiaoSetButton) v;
                //
                Intent inttentkamdiaoset = new Intent(KamDiaoSetActivity.this, KamDiaoWordsActivity.class);
                inttentkamdiaoset.putExtra("KAMDIAOSET_ID", btn.getKamDiaoSet().getId());
                startActivity(inttentkamdiaoset);
            }
        };

        kamDiaosetButtons.add((KamDiaoSetButton) findViewById(R.id.kamdiaosetImageBtn1));
        kamDiaosetButtons.add((KamDiaoSetButton) findViewById(R.id.kamdiaosetImageBtn2));
        kamDiaosetButtons.add((KamDiaoSetButton) findViewById(R.id.kamdiaosetImageBtn3));


        for (int i = 0; i < kamDiaosetButtons.size(); i++) {
            kamDiaosetButtons.get(i).setKamDiaoSet(kamDiaoSets.get(i));
            kamDiaosetButtons.get(i).setOnClickListener(kamdiaosetOnClickListener);
            int bid = getResources().getIdentifier(kamDiaoSets.get(i).picture, "drawable", getPackageName());
            kamDiaosetButtons.get(i).setBackgroundResource(bid);
        }

    }

}


