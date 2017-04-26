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
@Table(name = "provinces")
public class ProvinceEntity implements Serializable {
    @IndexedEmbedded(includeEmbeddedObjectId = true, targetElement = RegencyEntity.class)
    @OneToMany(mappedBy = "province")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<RegencyEntity> regencies;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Field(name = "code", index = Index.YES)
    @Column(name = "code", unique = true)
    private Integer code;
    @Field(name = "name", index = Index.YES)
    @Column(name = "name", length = 100)
    private String name;

    private ProvinceEntity() {
    }

    public ProvinceEntity(Integer id, Integer code, String name, List<RegencyEntity> regencies) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.regencies = regencies;
    }

    public static ProvinceEntity create(Integer code) {
        return new ProvinceEntity().setCode(code);
    }

    public static ProvinceEntity create(Integer id, Integer code, String name, List<RegencyEntity> regencies) {
        return new ProvinceEntity()
                .setId(id)
                .setCode(code)
                .setName(name)
                .setRegencies(regencies);
    }

    public Integer getId() {
        return id;
    }

    public ProvinceEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ProvinceEntity setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProvinceEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<RegencyEntity> getRegencies() {
        return regencies;
    }

    public ProvinceEntity setRegencies(List<RegencyEntity> regencies) {
        this.regencies = regencies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinceEntity that = (ProvinceEntity) o;

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
