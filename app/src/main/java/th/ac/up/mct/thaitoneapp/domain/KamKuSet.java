package th.ac.up.mct.thaitoneapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by MooMee on 14/1/2559.
 */
public class KamKuSet extends Model {


    @Column(name = "NAME")
    public String name;

    @Column(name = "Picture")
    public String picture;

    public List<KamKu> kamkus() {
        return getMany(KamKu.class, "SET_ID");
    }

    public static List<KamKuSet> getAll(){
        return new Select().from(KamKuSet.class).execute();
    }

    public static KamKuSet get(long id){
        return new Select().from(KamKuSet.class).where("Id = ?",id).executeSingle();
    }

}
