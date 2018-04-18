package com.sinco.carnation.sys.service;

import com.sinco.carnation.sys.bo.ActApplyBO;
import com.sinco.carnation.sys.dao.ActApplyDao;
import com.sinco.carnation.sys.model.ActApply;
import com.sinco.carnation.sys.vo.ActApplyVO;
import com.sinco.dal.common.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 招商页面
 * 
 * @author Administrator
 * 
 */
@Service
@Transactional
public class ActApplyService {
	@Autowired
	private ActApplyDao actApplyDao;

	/**
	 * 提交申请保存入数据库
	 * 
	 * @param actApply
	 * @return
	 */
	public boolean save(ActApply actApply) {
		// TODO Auto-generated method stub
		try {
			this.actApplyDao.save(actApply);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ActApplyBO> selectListByVo(ActApplyVO vo, MyPage<ActApplyBO> page) {
		return actApplyDao.selectListByVo(vo, page);
	}

	public ActApplyBO findOne(Long id) {
		return actApplyDao.findOne(id);
	}

}
