package com.monsanto.service.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.monsanto.service.GenericService;

@Service(GenericServiceImpl.SERVICE_NAME)
@Transactional(propagation=Propagation.REQUIRED)
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	/**
	 * Service Name
	 */
	public static final String SERVICE_NAME = "genericService";
	/**
	 * log variable.
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Is Debug Enabled variable.
	 */
	protected boolean isDebugEnabled = log.isDebugEnabled();
	/**
	 * Is Warn Enabled variable.
	 */
	protected boolean isWarnEnabled = log.isWarnEnabled();
	/**
	 * Is Error Enabled variable.
	 */
	protected boolean isErrorEnabled = log.isErrorEnabled();
	/**
	 * Is Info Enabled variable.
	 */
	protected boolean isInfoEnabled = log.isInfoEnabled();
	
}
