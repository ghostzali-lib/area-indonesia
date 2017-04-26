package id.goindonesia.area.indonesia.commons.component;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
public interface BaseReadService<T, C> {
    T findByCode(C code);

    List<T> findAll();

    List<T> findByKeyword(String keyword);

    List<T> findByKeywordFromField(String keyword, String field);

    List<T> findByKeywordFromFields(String keyword, String... fields);
}
