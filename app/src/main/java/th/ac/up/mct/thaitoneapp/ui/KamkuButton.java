package th.ac.up.mct.thaitoneapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamKu;

/**
 * Created by Win 8.1 on 25/1/2559.
 */
public class KamkuButton extends ImageButton {
    private KamKu kamkuactivity;

    public KamKu getKamkuactivity() {
        return kamkuactivity;
    }

    public void setKamkuactivity(KamKu kamkuactivity) {
        this.kamkuactivity = kamkuactivity;
    }

    public KamkuButton(Context context) {
        super(context);
    }

    public KamkuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamkuButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
