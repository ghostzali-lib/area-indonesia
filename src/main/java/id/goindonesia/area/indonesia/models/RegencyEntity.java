package id.goindonesia.area.indonesia.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ghostzali on 22/04/17.
 */
@Entity
@Indexed
@Table(name = "regencies")
public class RegencyEntity implements Serializable {
    @IndexedEmbedded(includeEmbeddedObjectId = true, targetElement = DistrictEntity.class)
    @OneToMany(mappedBy = "regency")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<DistrictEntity> districts;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Field(name = "code", index = Index.YES)
    @Column(name = "code", unique = true)
    private Integer code;
    @Field(name = "name", index = Index.YES)
    @Column(name = "name", length = 100)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProvinceEntity province;

    private RegencyEntity() {
    }

    public RegencyEntity(Integer id, Integer code, String name, ProvinceEntity province, List<DistrictEntity> districts) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.province = province;
        this.districts = districts;
    }

    public static RegencyEntity create(Integer code) {
        return new RegencyEntity().setCode(code);
    }

    public static RegencyEntity create(Integer id, Integer code, String name, ProvinceEntity province, List<DistrictEntity> districts) {
        return new RegencyEntity()
                .setId(id)
                .setCode(code)
                .setName(name)
                .setProvince(province)
                .setDistricts(districts);
    }

    public Integer getId() {
        return id;
    }

    public RegencyEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public RegencyEntity setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegencyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public RegencyEntity setProvince(ProvinceEntity province) {
        this.province = province;
        return this;
    }

    public List<DistrictEntity> getDistricts() {
        return districts;
    }

    public RegencyEntity setDistricts(List<DistrictEntity> districts) {
        this.districts = districts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegencyEntity that = (RegencyEntity) o;

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
