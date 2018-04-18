package com.sinco.carnation.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.config.dao.ConfigSetDao;

@Service
@Transactional
public class ConfigSetService {
	@Autowired
	private ConfigSetDao cfDao;

	public ConfigSetDao getCfDao() {
		return cfDao;
	}

	public void setCfDao(ConfigSetDao cfDao) {
		this.cfDao = cfDao;
	}

}
