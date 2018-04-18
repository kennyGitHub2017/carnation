package com.sinco.dal.common.persistence;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.dal.utils.SpringUtil;
import com.sinco.mybatis.dal.core.StatementHandlerInterceptor;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
		@Signature(type = StatementHandler.class, method = "parameterize", args = {Statement.class})})
public class MyStatementHandlerInterceptor extends StatementHandlerInterceptor {

	private SqlSession session;

	private final Logger log = LoggerFactory.getLogger(MyStatementHandlerInterceptor.class);

	@Override
	public SqlSession getMybatisSession() {
		if (session == null) {
			log.debug("StatementHandlerInterceptor SqlSession create");
			session = (SqlSession) SpringUtil.getBean("sqlSession");
		}
		return session;
	}

}
