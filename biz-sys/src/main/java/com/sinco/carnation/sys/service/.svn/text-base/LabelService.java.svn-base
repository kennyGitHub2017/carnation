package com.sinco.carnation.sys.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.label.bo.LabelBO;
import com.sinco.carnation.label.dao.LabelDao;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.label.vo.LabelVO;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class LabelService {
	@Autowired
	private LabelDao labelDao;

	public List<Label> selectList(LabelVO labelvo) {
		// TODO Auto-generated method stub
		return labelDao.selectList(labelvo);
	}

	/**
	 * 用户自定义标签
	 * 
	 * @param label
	 * @return
	 */
	public int save(Label label) {
		String labelName = label.getLabelName();// 用户自定义标签名字
		if (!StringUtils.isNotEmpty(labelName)) {
			return 400;// 标签名为空
		} else {
			LabelVO labelvo = new LabelVO();
			labelvo.setLabelName(labelName.trim());
			List<Label> selectList = this.selectList(labelvo);
			if (selectList != null && selectList.size() > 0 && label.getId() == null) {
				return 300;// 已存在该标签
			} else {
				labelDao.save(label);
			}
			return 100;
		}
	}

	public List<LabelBO> findByPage(MyPage<LabelBO> page, String name) {
		return labelDao.findByPage(page, name);
	}

	public Label getObjById(long parseLong) {
		// TODO Auto-generated method stub
		return labelDao.getObjById(parseLong);
	}

	public void batchDelete(List<Long> idList) {
		this.labelDao.deleteByIds(idList);

	}

	public List<Label> getIdNameMap() {
		// TODO Auto-generated method stub
		return this.labelDao.getIdNameMap();
	}

}
