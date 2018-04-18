package com.sinco.carnation.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.model.Role;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleDao roleDAO;

	public List<RoleBO> findByType(String... types) {
		return roleDAO.findByType(types);
	}

	public List<RoleBO> findByRoleCode(String roleCode) {
		return roleDAO.findByRoleCode(roleCode);
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		try {
			this.roleDAO.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Role getObjById(Long id) {
		// TODO Auto-generated method stub
		return this.roleDAO.get(id);
	}

//	public List<Role> query(String query, Map params, int begin, int max) {
//		// TODO Auto-generated method stub
//		return this.roleDAO.query(query, params, begin, max);
//	}

	public boolean save(Role role) {
		// TODO Auto-generated method stub
		try {
			this.roleDAO.save(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Role role) {
		// TODO Auto-generated method stub
		try {
			this.roleDAO.update(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * public List<RoleBO> findRolesByGroupId(Long groupId){ return roleDAO.findByGroupId(groupId); }
	 **/
//	public IPageList list(IQueryObject properties) {
//		// TODO Auto-generated method stub
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(Role.class, query,construct, params,
//				this.roleDAO);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(
//						pageObj.getCurrentPage() == null ? 0 : pageObj
//								.getCurrentPage(),
//						pageObj.getPageSize() == null ? 0 : pageObj
//								.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}
//
//	@Override
//	public Role getObjByProperty(String construct, String propertyName,
//			Object value) {
//		// TODO Auto-generated method stub
//		return this.roleDAO.getBy(construct, propertyName, value);
//	}

}
