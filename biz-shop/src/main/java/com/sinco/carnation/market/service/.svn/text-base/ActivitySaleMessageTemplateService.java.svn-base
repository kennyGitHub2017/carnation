package com.sinco.carnation.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.market.bo.ActivitySaleMessageTemplateBO;
import com.sinco.carnation.market.dao.ActivitySaleMessageTemplateDao;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplate;
import com.sinco.carnation.market.vo.ActivitySaleMessageTemplateVO;
import com.sinco.dal.common.MyPage;

/**
 * app弹框消息模板service
 * 
 */
@Service
public class ActivitySaleMessageTemplateService {

//	private final static Logger log = LoggerFactory.getLogger(ActivitySaleMessageTemplateService.class);

	@Autowired
	ActivitySaleMessageTemplateDao activitySaleMessageTemplateDao;

	/**
	 * 根据vo查询分页
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<ActivitySaleMessageTemplateBO> findAllByPage(ActivitySaleMessageTemplateVO vo,
			MyPage<ActivitySaleMessageTemplateBO> page) {
		return this.activitySaleMessageTemplateDao.findAllByPage(vo, page);
	}

	/**
	 * 添加模板
	 * 
	 * @param vo
	 * @return
	 */
	public ActivitySaleMessageTemplate save(ActivitySaleMessageTemplateVO vo) {
		return this.activitySaleMessageTemplateDao.save(vo);
	}

	/**
	 * 删除模板
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		if (null == id) {
			return;
		}
		this.activitySaleMessageTemplateDao.delete(id);
	}

	/** 根据id精确查询 **/
	public ActivitySaleMessageTemplate findOne(Long id) {
		if (id == null) {
			return null;
		}
		return this.activitySaleMessageTemplateDao.findOne(id);
	}

	public ActivitySaleMessageTemplateBO getById(Long templateId) {
		if (templateId == null) {
			return null;
		}
		return this.activitySaleMessageTemplateDao.findOne(templateId);
	}

}
