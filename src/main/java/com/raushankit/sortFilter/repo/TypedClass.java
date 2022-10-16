package com.raushankit.sortFilter.repo;

import com.raushankit.sortFilter.repo.utils.FieldPath;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Map;

@Slf4j
public class TypedClass<T> {

    private final EntityManager em;

    private final Class<T> klass;

    private final Map<String, List<String>> pathMap;

    public TypedClass(EntityManager em, Class<T> klass) {
        this.em = em;
        this.klass = klass;
        FieldPath fieldPath = new FieldPath();
        this.pathMap = fieldPath.getTree(klass);
    }

    public void test() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(klass);
        Root<T> root = cq.from(klass);
        EntityType<T> T_ = root.getModel();
        cq.where(cb.equal(getPathFromFieldName(root, "commonName"), "India"));
        List<T> data = em.createQuery(cq).getResultList();
        log.warn("check: {}, data = {}, mp = {}", T_.getName(), data, T_.getPluralAttributes());
    }

    private Path<?> getPathFromFieldName(Root<T> root, String fieldName) {
        List<String> paths = pathMap.get(fieldName);
        log.warn("paths = {}", paths);
        if(paths == null || paths.isEmpty()){
            throw new IllegalArgumentException("unable to find column with name " + fieldName);
        }
        Path<?> path = root.get(paths.get(0));
        for(int i = 1;i < paths.size(); ++i) {
            path = path.get(paths.get(i));
        }
        return path;
    }

}
