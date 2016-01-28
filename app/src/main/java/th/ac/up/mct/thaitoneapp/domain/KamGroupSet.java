package th.ac.up.mct.thaitoneapp.domain;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;

import java.util.List;
/**
 * Created by MooMee on 14/1/2559.
 */
public class KamGroupSet extends Model {


    @Column(name = "NAME")
    public String name;

    @Column(name = "Picture")
    public String picture;

    public List<KamGroup> kamgroups() {
        return getMany(KamGroup.class, "SET_ID");
    }

    public static List<KamGroupSet> getAll(){
        return new Select().from(KamGroupSet.class).execute();
    }

    public static KamGroupSet get(long id){
        return new Select().from(KamGroupSet.class).where("Id = ?",id).executeSingle();
    }
}
