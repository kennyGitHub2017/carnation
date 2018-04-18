package com.sinco.carnation.sys.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.SysReminderTaskBO;
import com.sinco.carnation.sys.dao.SysKeyWordMapDao;
import com.sinco.carnation.sys.dao.SysReminderTaskDao;
import com.sinco.carnation.sys.model.SysKeyWordMap;
import com.sinco.carnation.sys.model.SysReminderTask;
import com.sinco.carnation.sys.vo.SysReminderTaskVO;
import com.sinco.carnation.user.bo.PhysicalKeyWordBO;
import com.sinco.carnation.user.dao.PhysicalKeyWordDao;
import com.sinco.carnation.user.model.PhysicalKeyWord;
import com.sinco.dal.common.MyPage;

/**
 * Created by zhoujianbo on 2016/2/24.
 */
@Service
@Transactional
public class TaskService {
	@Resource
	private SysReminderTaskDao sysReminderTaskDao;
	@Resource
	private SysKeyWordMapDao sysKeyWordMapDao;
	@Resource
	private PhysicalKeyWordDao physicalKeyWordDao;

	public void findPageByVo(SysReminderTaskVO vo, MyPage<SysReminderTaskBO> page) {
		List<SysReminderTaskBO> list = sysReminderTaskDao.findPageByVo(vo, page);
		for (SysReminderTaskBO bo : list) {
			loadKeyWord(bo);
		}
		page.setContent(list);
	}

	/**
	 * 保存任务并同时保存到keyWordMap表中
	 * 
	 * @param task
	 * @param keywordIds
	 *            关键字,用‘,’分隔
	 * 
	 * @return
	 */
	public SysReminderTask save(SysReminderTask task, String keywordIds) {
		String[] ids = keywordIds.trim().split(",");
		sysReminderTaskDao.save(task);
		// 先删除Map表中的关联关系，重新插入
		sysKeyWordMapDao.batchDeleteByTypeCodeAndIds(SysReminderTaskBO.TASK_TYPE_CODE,
				Arrays.asList(task.getId()));
		for (String id : ids) {
			Long keywordId = CommUtil.null2Long(id);
			if (keywordId > 0) {
				PhysicalKeyWordBO bo = physicalKeyWordDao.findOne(keywordId);
				if (bo == null) {
					throw new IllegalArgumentException("参数错误！");
				}
				SysKeyWordMap map = new SysKeyWordMap();
				map.setKeyWordId(keywordId);
				map.setTypeCode(2L);
				map.setTypeId(task.getId());
				sysKeyWordMapDao.save(map);
			}
		}
		return task;
	}

	public SysReminderTaskBO get(long id) {
		SysReminderTaskBO bo = sysReminderTaskDao.findOne(id);
		loadKeyWord(bo);
		return bo;
	}

	/**
	 * 加载关键字任务对应的关键字
	 * 
	 * @param bo
	 */
	private void loadKeyWord(SysReminderTaskBO bo) {
		List<PhysicalKeyWord> list = physicalKeyWordDao.findByTypeCodeAndId(SysReminderTaskBO.TASK_TYPE_CODE,
				bo.getId());
		bo.setKeyWords(list);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public void batchDelete(List ids) {
		sysReminderTaskDao.deleteByIds(ids);
		// 同步删除sys_key_word_map中的关联
		sysKeyWordMapDao.batchDeleteByTypeCodeAndIds(SysReminderTaskBO.TASK_TYPE_CODE, ids);
	}
}
