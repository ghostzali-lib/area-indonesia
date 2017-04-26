package id.goindonesia.area.indonesia.views;

import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.ProvinceEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;
import id.goindonesia.area.indonesia.models.VillageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
public class Area {
    private Number code;
    private String name;

    public Area() {    }

    public Area(Number code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Area create(Integer code, String name) {
        return new Area()
                .setCode(code)
                .setName(name);
    }

    public static Area create(ProvinceEntity entity) {
        return new Area()
                .setCode(entity.getCode())
                .setName(entity.getName());
    }

    public static List<Area> createListFromProvinces(List<ProvinceEntity> entities) {
        List<Area> ps = new ArrayList<>();
        entities.forEach(p -> ps.add(Area.create(p)));
        return ps;
    }

    public static Area create(RegencyEntity entity) {
        return new Area()
                .setCode(entity.getCode())
                .setName(entity.getName());
    }

    public static List<Area> createListFromRegencies(List<RegencyEntity> entities) {
        List<Area> ps = new ArrayList<>();
        entities.forEach(p -> ps.add(Area.create(p)));
        return ps;
    }

    public static Area create(DistrictEntity entity) {
        return new Area()
                .setCode(entity.getCode())
                .setName(entity.getName());
    }

    public static List<Area> createListFromDistricts(List<DistrictEntity> entities) {
        List<Area> ps = new ArrayList<>();
        entities.forEach(p -> ps.add(Area.create(p)));
        return ps;
    }

    public static Area create(VillageEntity entity) {
        return new Area()
                .setCode(entity.getCode())
                .setName(entity.getName());
    }

    public static List<Area> createListFromVillages(List<VillageEntity> entities) {
        List<Area> ps = new ArrayList<>();
        entities.forEach(p -> ps.add(Area.create(p)));
        return ps;
    }

    public Number getCode() {
        return code;
    }

    public Area setCode(Number code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }
}
