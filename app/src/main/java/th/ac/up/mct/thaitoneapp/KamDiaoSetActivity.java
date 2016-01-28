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
import android.widget.LinearLayout;

import java.util.List;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;
import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;
import th.ac.up.mct.thaitoneapp.ui.KamDiaoSetButton;

public class KamDiaoSetActivity extends ActionBarActivity {

    LinearLayout kamdiaoMainLayout;

    LayoutInflater inflater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_diao_set);

        inflater = LayoutInflater.from(this);

        kamdiaoMainLayout = (LinearLayout) findViewById(R.id.KamdiaoMainLayout);



        List<KamDiaoSet> kamdiaoSets = KamDiaoSet.getAll();

        View.OnClickListener kamdiaosetOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamDiaoSetButton btn = (KamDiaoSetButton)v;
                //
                Intent inttentkamdiao = new Intent(KamDiaoSetActivity.this,KamDiaoWordsActivity.class);
                inttentkamdiao.putExtra("KAMDIAOSET_ID",btn.getKamDiaoSet().getId());
                startActivity(inttentkamdiao);

            }
        };

        // เอาค่าออกมาเป็นButton
        for(KamDiaoSet k : kamdiaoSets){
            KamDiaoSetButton kamdiaosetBn = new KamDiaoSetButton(this);
//            Log.i("K_PICTURE",k.getId().toString());
//            Log.i("K_PICTURE",k.picture);
            int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
            //int id=R.drawable.kamset_1_picture;
            Log.i("ID", Integer.toString(id));
            kamdiaosetBn.setBackgroundResource(id);
            kamdiaosetBn.setKamDiaoSet(k);
            kamdiaosetBn.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
            kamdiaosetBn.setOnClickListener(kamdiaosetOnclickListener);
            kamdiaoMainLayout.addView(kamdiaosetBn);
        }





    }

}
