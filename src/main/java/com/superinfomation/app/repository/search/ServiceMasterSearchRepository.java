package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.ServiceMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link ServiceMaster} entity.
 */
public interface ServiceMasterSearchRepository extends ElasticsearchRepository<ServiceMaster, Long> {
}
