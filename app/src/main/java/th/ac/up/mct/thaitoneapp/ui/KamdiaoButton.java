package th.ac.up.mct.thaitoneapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;

/**
 * Created by Win 8.1 on 25/1/2559.
 */
public class KamdiaoButton extends ImageButton {

    private KamDiao kamdiaoactivity;

    public KamDiao getKamdiaoactivity() {
        return kamdiaoactivity;
    }

    public void setKamdiaoactivity(KamDiao kamdiaoactivity) {
        this.kamdiaoactivity = kamdiaoactivity;
    }

    public KamdiaoButton(Context context) {
        super(context);
    }

    public KamdiaoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamdiaoButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
