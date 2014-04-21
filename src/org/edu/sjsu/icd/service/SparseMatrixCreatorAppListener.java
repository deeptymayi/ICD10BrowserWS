package org.edu.sjsu.icd.service;

import org.edu.sjsu.icd.dao.impl.SparseMatrixBuilderDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Deepti
 *
 */
public class SparseMatrixCreatorAppListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
		SparseMatrixBuilderDAO sparseMatrixBuilderDAO = (SparseMatrixBuilderDAO) applicationContext.getBean("sparseMatrixBuilderDAO");
		sparseMatrixBuilderDAO.generateSparseMatrix();
	}
}
