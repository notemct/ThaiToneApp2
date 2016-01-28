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

import th.ac.up.mct.thaitoneapp.domain.KamGroup;
import th.ac.up.mct.thaitoneapp.domain.KamGroupSet;
import th.ac.up.mct.thaitoneapp.domain.KamKu;
import th.ac.up.mct.thaitoneapp.ui.KamGroupWordButton;


public class KamGroupWordsActivity extends ActionBarActivity {
    LinearLayout kamgroupWordsMainLayout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_group_words);

        inflater = LayoutInflater.from(this);
        kamgroupWordsMainLayout = (LinearLayout)findViewById(R.id.kamgroupWordMainLayout);

        Intent intent = getIntent();
        long KamgroupSetID = intent.getLongExtra("KAMGROUPSET_ID", 0);
        KamGroupSet set = KamGroupSet.get(KamgroupSetID);


        View.OnClickListener kamgroupWordOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KamGroupWordButton btn = (KamGroupWordButton)v;
                //
                Intent inttentkamgroup = new Intent(KamGroupWordsActivity.this,KamgroupActivity.class);
                inttentkamgroup.putExtra("KAMGROUP_ID", btn.getKamGroup().getId());
                startActivity(inttentkamgroup);
            }
        };

        for(KamGroup k : set.kamgroups()){
            KamGroupWordButton kamgroupwordbtn = new KamGroupWordButton(this);
            int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
            Log.i("ID", Integer.toString(id));
            kamgroupwordbtn.setBackgroundResource(id);
            kamgroupwordbtn.setKamGroup(k);
            kamgroupwordbtn.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
            // kamdiaoBtn.setText(k.kamThai);
            kamgroupwordbtn.setOnClickListener(kamgroupWordOnClickListener);
            kamgroupWordsMainLayout.addView(kamgroupwordbtn);
        }
    }

}
