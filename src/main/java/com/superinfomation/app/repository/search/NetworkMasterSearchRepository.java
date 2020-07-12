package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.NetworkMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link NetworkMaster} entity.
 */
public interface NetworkMasterSearchRepository extends ElasticsearchRepository<NetworkMaster, Long> {
}
