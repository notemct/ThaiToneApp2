package th.ac.up.mct.thaitoneapp.ui;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import th.ac.up.mct.thaitoneapp.domain.KamGroup;


/**
 * Created by Win 8.1 on 23/1/2559.
 */
public class KamGroupWordButton extends ImageButton {

    private KamGroup kamGroup;

    public KamGroup getKamGroup() {
        return kamGroup;
    }

    public void setKamGroup(KamGroup kamGroup) {
        this.kamGroup = kamGroup;
    }

    public KamGroupWordButton(Context context) {
        super(context);
    }

    public KamGroupWordButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KamGroupWordButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}