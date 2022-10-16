package com.raushankit.sortFilter.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SortFilterPagingRepository<T, ID> extends CrudRepository<T, ID> {

}
