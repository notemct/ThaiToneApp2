package th.ac.up.mct.thaitoneapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by MooMee on 14/1/2559.
 */
public class KamKu extends Model {


    @Column(name = "Word1")
    public String word1;

    @Column(name = "Word2")
    public String Word12;

    @Column(name = "IPA1")
    public String ipa1;

    @Column(name = "IPA2")
    public String ipa2;

    @Column(name = "SentenceTH")
    public String sentenceTH;

    @Column(name = "SentenceEN")
    public String SentenceEN;

    @Column(name = "SentenceIPA")
    public String sentenceIPA;

    @Column(name = "SET_ID")
    public KamKuSet kamKuSet;

    @Column(name = "Picture")
    public String picture;

    @Column(name = "PictureWord")
    public String pictureword;


    public static List<KamKu> getAll(){
        return new Select().from(KamKu.class).execute();
    }

    public static KamKu get(long id){
        return new Select().from(KamKu.class).where("Id = ?",id).executeSingle();
    }


}
