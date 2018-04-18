package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.DocumentBO;
import com.sinco.carnation.sys.dao.DocumentDao;
import com.sinco.carnation.sys.model.Document;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class DocumentService {
	@Autowired
	private DocumentDao documentDao;

	/**
	 * 根据标识查找
	 * 
	 * @param mark
	 * @return
	 */
	public DocumentBO findByMark(String mark) {
		return documentDao.findByMark(mark);
	}

	public Document getObjById(Long id) {
		Document document = this.documentDao.get(id);
		if (document != null) {
			return document;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.documentDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> documentIds) {
		// TODO Auto-generated method stub
		for (Serializable id : documentIds) {
			delete((Long) id);
		}
		return true;
	}

	public void queryDocumetAllList(MyPage<DocumentBO> page) {
		page.setContent(documentDao.queryDocumetAllList(page));
	}

	@Transactional(readOnly = false)
	public void saveDocument(Document document) {
		documentDao.save(document);
	}

	public Document queryDocumentById(Long id) {
		return documentDao.findOne(id);
	}
}
