package th.ac.up.mct.thaitoneapp.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;
import th.ac.up.mct.thaitoneapp.domain.KamDiaoSet;

/**
 * Created by chaow on 1/2/2016 AD.
 */
public class KamDiaoWordButton extends ImageButton {

    private KamDiao kamDiao;

    public KamDiao getKamDiao() {

        return kamDiao;
    }

    public void setKamDiao(KamDiao kamDiao) {

        this.kamDiao = kamDiao;
    }

    public KamDiaoWordButton(Context context) {

        super(context);
    }

    public KamDiaoWordButton(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public KamDiaoWordButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KamDiaoWordButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
