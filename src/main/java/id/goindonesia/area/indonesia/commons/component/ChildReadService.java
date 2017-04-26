package id.goindonesia.area.indonesia.commons.component;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
public interface ChildReadService<T, P> {
    List<T> findByParent(P parentCode);
}
