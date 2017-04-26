package id.goindonesia.area.indonesia.setup.data;

import com.google.gson.annotations.SerializedName;
import id.goindonesia.area.indonesia.models.ProvinceEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;

/**
 * Created by ghostzali on 25/04/17.
 */
public class RegencyImport {
    @SerializedName("code")
    private Integer code;
    @SerializedName("name")
    private String name;
    @SerializedName("province")
    private Integer province;

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

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public RegencyEntity create() {
        return RegencyEntity.create(null, code, name, ProvinceEntity.create(province), null);
    }
}
