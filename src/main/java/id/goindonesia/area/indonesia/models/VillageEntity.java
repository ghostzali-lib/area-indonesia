package id.goindonesia.area.indonesia.models;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ghostzali on 22/04/17.
 */
@Entity
@Indexed
@Table(name = "villages")
public class VillageEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Field(name = "code", index = Index.YES)
    @Column(name = "code", unique = true)
    private Long code;
    @Field(name = "name", index = Index.YES)
    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private DistrictEntity district;

    private VillageEntity() {
    }

    public VillageEntity(Long id, Long code, String name, DistrictEntity district) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.district = district;
    }

    public static VillageEntity create(Long code) {
        return new VillageEntity().setCode(code);
    }

    public static VillageEntity create(Long id, Long code, String name, DistrictEntity district) {
        return new VillageEntity()
                .setId(id)
                .setCode(code)
                .setName(name)
                .setDistrict(district);
    }

    public Long getId() {
        return id;
    }

    public VillageEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCode() {
        return code;
    }

    public VillageEntity setCode(Long code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public VillageEntity setName(String name) {
        this.name = name;
        return this;
    }

    public DistrictEntity getDistrict() {
        return district;
    }

    public VillageEntity setDistrict(DistrictEntity district) {
        this.district = district;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VillageEntity that = (VillageEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getCode().equals(that.getCode());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getCode().hashCode();
        return result;
    }
}
