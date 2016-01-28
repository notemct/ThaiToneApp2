package th.ac.up.mct.thaitoneapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamGroup;

/**
 * Created by Win 8.1 on 25/1/2559.
 */
public class KamgroupButton extends ImageButton {
    private KamGroup kamdroupactivity;

    public KamGroup getKamdroupactivity() {
        return kamdroupactivity;
    }

    public void setKamgroupactivity(KamGroup kamdroupactivity) {
        this.kamdroupactivity = kamdroupactivity;
    }

    public KamgroupButton(Context context) {
        super(context);
    }

    public KamgroupButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamgroupButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
