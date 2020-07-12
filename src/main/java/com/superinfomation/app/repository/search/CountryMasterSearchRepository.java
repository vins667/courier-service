package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.CountryMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link CountryMaster} entity.
 */
public interface CountryMasterSearchRepository extends ElasticsearchRepository<CountryMaster, Long> {
}
