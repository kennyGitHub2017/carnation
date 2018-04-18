package com.sinco.carnation.check.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sns.bo.CheckClassBO;
import com.sinco.carnation.sns.dao.CheckClassDao;
import com.sinco.carnation.sns.model.CheckClass;
import com.sinco.carnation.sns.vo.CheckClassVO;
import com.sinco.dal.common.MyPage;

@Service
public class CheckClassService {

	@Autowired
	private CheckClassDao checkClassDao;

	public List<CheckClassBO> findAll() {
		List<CheckClassBO> list = checkClassDao.findAll();
		Map<String, CheckClassBO> map = new LinkedHashMap<String, CheckClassBO>();
		for (CheckClassBO checkClass : list) {
			map.put(checkClass.getId().toString(), checkClass);
		}

		for (CheckClassBO checkClass : list) {
			if (checkClass.getParentId().longValue() != 0
					&& map.get(checkClass.getParentId().toString()) != null) {
				if (map.get(checkClass.getParentId().toString()).getChilds() == null) {
					map.get(checkClass.getParentId().toString()).setChilds(new ArrayList<CheckClassBO>());
				}
				map.get(checkClass.getParentId().toString()).getChilds().add(checkClass);
			}
		}

		List<CheckClassBO> newList = new ArrayList<CheckClassBO>();
		for (Map.Entry<String, CheckClassBO> entry : map.entrySet()) {
			if (entry.getValue().getParentId().longValue() != 0) {
				continue;
			}
			newList.add(entry.getValue());
			addChildClass(newList, entry.getValue(), "");
		}
		return newList;
	}

	private List<CheckClassBO> addChildClass(List<CheckClassBO> list, CheckClassBO bo, String prefix) {
		if (bo.getChilds() != null && bo.getChilds().size() > 0) {
			bo.setIsParent("yes");
			StringBuffer prefixBuf = new StringBuffer();
			prefixBuf.append(prefix).append("\u3000");
			for (CheckClassBO checkClass : bo.getChilds()) {
				StringBuffer classNameBuf = new StringBuffer();
				checkClass.setClassName(classNameBuf.append(prefixBuf).append(checkClass.getClassName())
						.toString());
				list.add(checkClass);
				addChildClass(list, checkClass, prefixBuf.toString());
			}
		}
		return list;
	}

	private List<Long> getChildsId(List<Long> list, CheckClassBO bo) {
		if (bo.getChilds() != null && bo.getChilds().size() > 0) {
			for (CheckClassBO checkClass : bo.getChilds()) {
				list.add(checkClass.getId());
				getChildsId(list, checkClass);
			}
		}
		return list;
	}

	public List<Long> getChildsByClassId(Long id) {
		List<Long> childsId = new ArrayList<Long>();
		List<CheckClassBO> list = checkClassDao.findAll();
		Map<String, CheckClassBO> map = new LinkedHashMap<String, CheckClassBO>();
		for (CheckClassBO checkClass : list) {
			map.put(checkClass.getId().toString(), checkClass);
		}
		for (CheckClassBO checkClass : list) {
			if (checkClass.getParentId() != null && checkClass.getParentId().longValue() != 0) {
				// map.get(checkClass.getParentId().toString()).getChilds().add(checkClass);
				CheckClassBO bo = map.get(checkClass.getParentId().toString());
				if (bo != null) {
					List<CheckClassBO> mapList = bo.getChilds();
					mapList.add(checkClass);
				}
			}
		}
		CheckClassBO bo = map.get(id.toString());
		if (null != bo) {
			childsId.add(bo.getId());
			childsId = getChildsId(childsId, bo);
		}
		return childsId;
	}

	public List<CheckClassBO> findPageByVO(MyPage<CheckClassBO> page, CheckClassVO vo) {
		return this.checkClassDao.findPageByVO(page, vo);
	}

	/**
	 * 根据父id来查询所有子元素
	 * 
	 * @param pid
	 * @return
	 */
	public List<CheckClass> findListByParentId(Long pid) {
		return this.checkClassDao.findListByParentId(pid);
	}

	/**
	 * 根据id来查询对象
	 * 
	 * @param id
	 * @return
	 */
	public CheckClass getById(Long id) {
		return this.checkClassDao.getById(id);
	}

	public void update(CheckClass gc) {
		this.checkClassDao.update(gc);
	}

	public void save(CheckClass cc) {
		this.checkClassDao.save(cc);
	}

	public int countByName(String className, Long id, Long pid) {
		List<CheckClass> result = this.checkClassDao.countByName(className, id, pid);
		return result == null ? 0 : result.size();
	}

	public void delete(Long... ids) {
		List<CheckClass> allList = this.checkClassDao.findByIds(ids);

		List<Long> allListWithChildren = new ArrayList<Long>();
		for (CheckClass cc : allList) {
			allListWithChildren.add(cc.getId());

			if (cc.getParentId().equals(new Long(0))) {
				List<CheckClass> children = this.checkClassDao.findListByParentId(cc.getId());
				for (CheckClass ccc : children) {
					allListWithChildren.add(ccc.getId());
				}
			}
		}

		this.checkClassDao.updateDeleteStatusByIds(allListWithChildren);
	}

	public List<CheckClassBO> selectCheckClaaaList(Long parentId) {
		return checkClassDao.selectCheckClaaaList(parentId);
	}
}
