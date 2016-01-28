package th.ac.up.mct.thaitoneapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamKuSet;

/**
 * Created by Win 8.1 on 20/1/2559.
 */
public class KamKuSetButton extends ImageButton {

    private KamKuSet kamKuSet;

    public KamKuSet getKamKuSet() {
        return kamKuSet;
    }

    public void setKamKuSet(KamKuSet kamKuSet) {
        this.kamKuSet = kamKuSet;
    }

    public KamKuSetButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public KamKuSetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamKuSetButton(Context context) {
        super(context);
    }
}
