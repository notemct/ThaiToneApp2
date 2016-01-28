package th.ac.up.mct.thaitoneapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamGroupSet;

/**
 * Created by Win 8.1 on 20/1/2559.
 */
public class KamGroupSetButton extends ImageButton {
    private KamGroupSet kamGroupSet;

    public KamGroupSet getKamGroupSet() {
        return kamGroupSet;
    }

    public void setKamGroupSet(KamGroupSet kamGroupSet) {
        this.kamGroupSet = kamGroupSet;
    }

    public KamGroupSetButton(Context context) {
        super(context);
    }

    public KamGroupSetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamGroupSetButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
