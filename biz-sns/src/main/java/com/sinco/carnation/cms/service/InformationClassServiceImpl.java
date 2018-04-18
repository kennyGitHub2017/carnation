package com.sinco.carnation.cms.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.InformationClassBO;
import com.sinco.carnation.sns.dao.InformationClassDao;
import com.sinco.carnation.sns.model.InformationClass;
import com.sinco.carnation.sns.vo.InformationClassVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class InformationClassServiceImpl {

	@Autowired
	private InformationClassDao informationClassDao;

	public List<InformationClassBO> findInformationClassByParentId(Long parentId) {
		return informationClassDao.findInformationClassByParentId(parentId);
	}

	public List<InformationClassBO> findInforClassByParentId(Long parentId) {
		List<InformationClassBO> list = informationClassDao.findInformationClassByParentId(parentId);
		for (InformationClassBO bo : list) {
			if (bo.getLevel().equals(2)) { // 第三级的元素
				bo.setParentParentId(this.getObjById(bo.getIcPid()).getIcPid());
			}
		}
		return list;
	}

	public boolean save(InformationClass informationClass) {
		/**
		 * init other field here
		 */
		try {
			this.informationClassDao.save(informationClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public InformationClass getObjById(Long id) {
		InformationClass informationClass = this.informationClassDao.get(id);
		if (informationClass != null) {
			return informationClass;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.informationClassDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> informationClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : informationClassIds) {
			delete((Long) id);
		}
		return true;
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(InformationClass.class,construct, query,
//				params, this.informationClassDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
//						.getCurrentPage(), pageObj.getPageSize() == null ? 0
//						: pageObj.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(InformationClass informationClass) {
		try {
			this.informationClassDao.update(informationClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<InformationClass> query(String query, Map params, int begin, int max){
//		return this.informationClassDao.query(query, params, begin, max);
//	}

	public List<InformationClassBO> findAll() {
		List<InformationClassBO> list = informationClassDao.selectAll();
		Map<String, InformationClassBO> map = new LinkedHashMap<String, InformationClassBO>();
		for (InformationClassBO informationClass : list) {
			map.put(informationClass.getId().toString(), informationClass);
		}

		for (InformationClassBO informationClass : list) {
			if (informationClass.getIcPid().longValue() != 0) {
				map.get(informationClass.getIcPid().toString()).getChilds().add(informationClass);
			}
		}

		List<InformationClassBO> newList = new ArrayList<InformationClassBO>();
		for (Map.Entry<String, InformationClassBO> entry : map.entrySet()) {
			if (entry.getValue().getIcPid().longValue() != 0) {
				continue;
			}
			newList.add(entry.getValue());
			addChildClass(newList, entry.getValue(), "");
		}
		return newList;
	}

	private List<InformationClassBO> addChildClass(List<InformationClassBO> list, InformationClassBO bo,
			String prefix) {
		if (bo.getChilds() != null && bo.getChilds().size() > 0) {
			bo.setIsParent("yes");
			StringBuffer prefixBuf = new StringBuffer();
			prefixBuf.append(prefix).append("\u3000");
			for (InformationClassBO informationClass : bo.getChilds()) {
				StringBuffer classNameBuf = new StringBuffer();
				informationClass.setIcName(classNameBuf.append(prefixBuf)
						.append(informationClass.getIcName()).toString());
				list.add(informationClass);
				addChildClass(list, informationClass, prefixBuf.toString());
			}
		}
		return list;
	}

	private List<Long> getChildsId(List<Long> list, InformationClassBO bo) {
		if (bo.getChilds() != null && bo.getChilds().size() > 0) {
			for (InformationClassBO informationClass : bo.getChilds()) {
				list.add(informationClass.getId());
				getChildsId(list, informationClass);
			}
		}
		return list;
	}

	public List<Long> getChildsByClassId(Long id) {
		List<Long> childsId = new ArrayList<Long>();
		List<InformationClassBO> list = informationClassDao.selectAll();
		Map<String, InformationClassBO> map = new LinkedHashMap<String, InformationClassBO>();
		for (InformationClassBO informationClass : list) {
			map.put(informationClass.getId().toString(), informationClass);
		}
		for (InformationClassBO checkClass : list) {
			if (checkClass.getIcPid().longValue() != 0) {
				map.get(checkClass.getIcPid().toString()).getChilds().add(checkClass);
			}
		}
		InformationClassBO bo = map.get(id.toString());
		if (null != bo) {
			childsId.add(bo.getId());
			childsId = getChildsId(childsId, bo);
		}
		return childsId;
	}

	public void findPageByVO(MyPage<InformationClassBO> page, InformationClassVO vo) {
		this.informationClassDao.findPageByVO(page, vo);
	}

	public void delete(Long... ids) {
		// 得到所有子集
		List<InformationClassBO> childs = this.informationClassDao.findAllChild(ids);

		List<Long> childIds = new ArrayList<Long>();
		for (InformationClassBO gc : childs) {
			childIds.add(gc.getId());
		}

		// 加上自己
		childIds.addAll(Lists.newArrayList(ids));

		this.informationClassDao.updateDeleteStatusByIds(childIds);

	}

	public List<InformationClassBO> selectInfomationClassList(Long parentId) {
		return informationClassDao.selectInfomationClassList(parentId);
	}
}
