package id.goindonesia.area.indonesia.commons.component;

import java.util.List;

/**
 * Created by ghostzali on 25/04/17.
 */
public interface BaseSearchRepository<T> {
    List<T> search(String keyword);

    List<T> search(String keyword, String field);

    List<T> search(String keyword, String... fields);
}
