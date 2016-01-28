package th.ac.up.mct.thaitoneapp.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;

/**
 * Created by chaow on 1/2/2016 AD.
 */
public class KamDiaoSetButton extends ImageButton {

    private KamDiaoSet kamDiaoSet;

    public KamDiaoSet getKamDiaoSet() {

        return kamDiaoSet;
    }

    public void setKamDiaoSet(KamDiaoSet kamDiaoSet) {

        this.kamDiaoSet = kamDiaoSet;
    }

    public KamDiaoSetButton(Context context) {

        super(context);
    }

    public KamDiaoSetButton(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public KamDiaoSetButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KamDiaoSetButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
