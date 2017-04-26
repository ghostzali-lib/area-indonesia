package id.goindonesia.area.indonesia.services;

import id.goindonesia.area.indonesia.views.Area;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
public interface MergedSearchService {
    List<Area> searchFromAll(String keyword);
}
