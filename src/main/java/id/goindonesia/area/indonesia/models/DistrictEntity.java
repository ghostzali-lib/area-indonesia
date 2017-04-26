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
@Table(name = "districts")
public class DistrictEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code", unique = true)
    private Integer code;
    @Field(name = "name", index = Index.YES)
    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private RegencyEntity regency;

    @IndexedEmbedded(includeEmbeddedObjectId = true, targetElement = VillageEntity.class)
    @OneToMany(mappedBy = "district")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VillageEntity> villages;

    private DistrictEntity() {
    }

    public DistrictEntity(Integer id, Integer code, String name, RegencyEntity regency, List<VillageEntity> villages) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.regency = regency;
        this.villages = villages;
    }

    public static DistrictEntity create(Integer code) {
        return new DistrictEntity().setCode(code);
    }

    public static DistrictEntity create(Integer id, Integer code, String name, RegencyEntity regency, List<VillageEntity> villages) {
        return new DistrictEntity()
                .setId(id)
                .setCode(code)
                .setName(name)
                .setRegency(regency)
                .setVillages(villages);
    }

    public Integer getId() {
        return id;
    }

    public DistrictEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public DistrictEntity setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public DistrictEntity setName(String name) {
        this.name = name;
        return this;
    }

    public RegencyEntity getRegency() {
        return regency;
    }

    public DistrictEntity setRegency(RegencyEntity regency) {
        this.regency = regency;
        return this;
    }

    public List<VillageEntity> getVillages() {
        return villages;
    }

    public DistrictEntity setVillages(List<VillageEntity> villages) {
        this.villages = villages;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistrictEntity that = (DistrictEntity) o;

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
