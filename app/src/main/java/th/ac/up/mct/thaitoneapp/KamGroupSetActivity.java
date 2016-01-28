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

import th.ac.up.mct.thaitoneapp.domain.KamGroupSet;
import th.ac.up.mct.thaitoneapp.domain.KamKuSet;
import th.ac.up.mct.thaitoneapp.ui.KamGroupSetButton;
import th.ac.up.mct.thaitoneapp.ui.KamKuSetButton;

public class KamGroupSetActivity extends ActionBarActivity {

    LinearLayout kamgroupMainLayout;

    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kam_group_set);

    inflater = LayoutInflater.from(this);

    kamgroupMainLayout = (LinearLayout) findViewById(R.id.KamgroupMainLayout);
    List<KamGroupSet> kamGroupSetList = KamGroupSet.getAll();

    View.OnClickListener kamgroupsetOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            KamGroupSetButton btn = (KamGroupSetButton)v;
            //
            Intent inttentkamgroup = new Intent(KamGroupSetActivity.this,KamGroupWordsActivity.class);
            inttentkamgroup.putExtra("KAMGROUPSET_ID",btn.getKamGroupSet().getId());
            startActivity(inttentkamgroup);

        }
    };

    for (KamGroupSet k : kamGroupSetList) {
        KamGroupSetButton kamgroupsetBn = new KamGroupSetButton(this);

        int id = getResources().getIdentifier(k.picture, "drawable", getPackageName());
        Log.i("ID", Integer.toString(id));
        kamgroupsetBn.setBackgroundResource(id);
        kamgroupsetBn.setKamGroupSet(k);
        kamgroupsetBn.setLayoutParams(new LinearLayout.LayoutParams(850, 300));
        kamgroupsetBn.setOnClickListener(kamgroupsetOnclickListener);
        kamgroupMainLayout.addView(kamgroupsetBn);
    }
}


}
