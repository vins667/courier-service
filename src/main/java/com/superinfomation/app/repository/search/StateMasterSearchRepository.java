package com.superinfomation.app.repository.search;

import com.superinfomation.app.domain.StateMaster;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link StateMaster} entity.
 */
public interface StateMasterSearchRepository extends ElasticsearchRepository<StateMaster, Long> {
}
