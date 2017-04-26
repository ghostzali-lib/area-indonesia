package id.goindonesia.area.indonesia.setup.data;

import com.google.gson.annotations.SerializedName;
import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.VillageEntity;

/**
 * Created by ghostzali on 25/04/17.
 */
public class VillageImport {
    @SerializedName("code")
    private Long code;
    @SerializedName("name")
    private String name;
    @SerializedName("district")
    private Integer district;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public VillageEntity create() {
        return VillageEntity.create(null, code, name, DistrictEntity.create(district));
    }
}
