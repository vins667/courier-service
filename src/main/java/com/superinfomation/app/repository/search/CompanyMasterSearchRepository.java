package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.CompanyMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link CompanyMaster} entity.
 */
public interface CompanyMasterSearchRepository extends ElasticsearchRepository<CompanyMaster, Long> {
}
