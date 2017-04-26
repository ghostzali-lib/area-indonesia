package id.goindonesia.area.indonesia.setup.data;

import com.google.gson.annotations.SerializedName;
import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;

/**
 * Created by ghostzali on 25/04/17.
 */
public class DistrictImport {
    @SerializedName("code")
    private Integer code;
    @SerializedName("name")
    private String name;
    @SerializedName("regency")
    private Integer regency;

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

    public Integer getRegency() {
        return regency;
    }

    public void setRegency(Integer regency) {
        this.regency = regency;
    }

    public DistrictEntity create() {
        return DistrictEntity.create(null, code, name, RegencyEntity.create(regency), null);
    }
}
