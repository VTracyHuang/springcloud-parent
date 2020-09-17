package com.example.demo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 功能描述： 自定义DynamicDataSource
 *
 * @Author: Tracy
 * @Date: 2020/9/17 17:23
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    protected Object determineCurrentLookupKey() {
       // LOGGER.debug("数据源为：{}" , );
        return null;
    }
}
