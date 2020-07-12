package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.CityMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link CityMaster} entity.
 */
public interface CityMasterSearchRepository extends ElasticsearchRepository<CityMaster, Long> {
}
