package th.ac.up.mct.thaitoneapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamKu;

/**
 * Created by Win 8.1 on 23/1/2559.
 */
public class KamKuWordButton extends ImageButton {
    private KamKu kamKu;

    public KamKu getKamKu() {
        return kamKu;
    }

    public void setKamKu(KamKu kamKu) {
        this.kamKu = kamKu;
    }

    public KamKuWordButton(Context context) {
        super(context);
    }

    public KamKuWordButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamKuWordButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
