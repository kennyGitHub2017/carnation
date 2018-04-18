package com.sinco.carnation.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.bo.StoreGradeBO;
import com.sinco.carnation.store.dao.StoreGradeDao;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.vo.StoreGradeVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class StoreGradeService {
	@Autowired
	private StoreGradeDao storeGradeDao;

	@Transactional(readOnly = false)
	public void save(StoreGrade storeGrade) {
		storeGradeDao.save(storeGrade);
	}

	public StoreGrade getObjById(Long id) {
		StoreGrade storeGrade = this.storeGradeDao.get(id);
		if (storeGrade != null) {
			return storeGrade;
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		storeGradeDao.remove(id);
	}

	@Transactional(readOnly = false)
	public void batchDelete(List<Long> storeGradeIds) {
		for (Long id : storeGradeIds) {
			delete(id);
		}
	}

	@Transactional(readOnly = false)
	public void update(StoreGrade storeGrade) {
		storeGradeDao.update(storeGrade);
	}

	public List<StoreGradeBO> findList() {
		return this.storeGradeDao.findAll();
	}

	public void findPageByVo(MyPage<StoreGradeBO> page, StoreGradeVO vo) {
		List<StoreGradeBO> content = this.storeGradeDao.findPageByVo(vo);
		page.setContent(content);
	}

	public List<StoreGradeBO> queryStoreGradePageList() {
		return storeGradeDao.queryStoreGradePageList();
	}

	public List<StoreGrade> findAllList() {
		return this.storeGradeDao.findAllList();
	}
}
