package id.goindonesia.area.indonesia.setup.data;

import com.google.gson.annotations.SerializedName;
import id.goindonesia.area.indonesia.models.ProvinceEntity;

/**
 * Created by ghostzali on 25/04/17.
 */
public class ProvinceImport {
    @SerializedName("code")
    private Integer code;
    @SerializedName("name")
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceEntity create() {
        return ProvinceEntity.create(null, code, name, null);
    }
}
