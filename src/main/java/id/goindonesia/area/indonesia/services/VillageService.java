package id.goindonesia.area.indonesia.services;

import id.goindonesia.area.indonesia.commons.component.BaseReadService;
import id.goindonesia.area.indonesia.commons.component.ChildReadService;
import id.goindonesia.area.indonesia.views.Area;

/**
 * Created by ghostzali on 26/04/17.
 */
public interface VillageService extends BaseReadService<Area, Long>, ChildReadService<Area, Integer> {
}
