package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.query.support.IPageList;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.IpAddressByDetails;

import com.sinco.carnation.sns.bo.SnsActivityBO;
import com.sinco.carnation.sns.dao.SnsActivityDao;
import com.sinco.carnation.sns.model.SnsActivity;
import com.sinco.carnation.sns.vo.SnsActivityVO;
import com.sinco.carnation.sys.bo.AreaBO;
import com.sinco.carnation.sys.dao.AreaDao;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

/**
 * 招商页面
 * 
 * @author Administrator
 * 
 */
@Service
@Transactional
public class SnsActivityService {

	@Autowired
	private SnsActivityDao snsActivityDao;
	@Autowired
	private AreaDao areaDao;

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public SnsActivityBO findOne(java.lang.Long id) {
		return snsActivityDao.findOne(id);
	}

	/**
	 * 查找 活动列表 count条记录
	 * 
	 * @param id
	 * @param count
	 *            查询数目
	 * @return
	 */
	public List<SnsActivityBO> findTopAc(Long count, Integer isdel) {
		return snsActivityDao.findTopAc(count, null, isdel);
	}

	/**
	 * 根据条件查询活动列表
	 * 
	 * @param vo
	 *            ActivityVO
	 * @param page
	 * @return
	 */
	public List<SnsActivityBO> selectListByVo(SnsActivityVO vo, MyPage<SnsActivityBO> page) {
		return snsActivityDao.selectListByVo(vo, page);
	}

	/**
	 * 根据条件查询 活动列表
	 * 
	 * @param vo
	 * @param page
	 * @param provinceAreaid
	 *            省
	 * @param cityAreaid
	 *            市
	 * @param countyAreaid
	 *            区
	 * @param count
	 *            限制查询条数
	 * @return
	 */
	public List<SnsActivityBO> findbyVO(SnsActivityVO vo, MyPage<SnsActivityBO> page, String provinceAreaid,
			String cityAreaid, String countyAreaid, Integer count, Integer isdel) {
		List<SnsActivityBO> listbo = snsActivityDao.findbyVO(vo, page, count, isdel);
		if (listbo == null) {
			return null;
		}
		Long pid = null;
		Long cid = null;
		Long countyid = null;
		if (StringUtils.isNotBlank(provinceAreaid)) {
			pid = Long.parseLong(provinceAreaid);
		}
		if (StringUtils.isNotBlank(cityAreaid)) {
			cid = Long.parseLong(cityAreaid);
		}
		if (StringUtils.isNotBlank(countyAreaid)) {
			countyid = Long.parseLong(countyAreaid);
		}
		List<SnsActivityBO> list = new ArrayList<SnsActivityBO>();
		for (SnsActivityBO snsActivityBO : listbo) {
			if (snsActivityBO.getAreaId().equals(countyid) && snsActivityBO.getAreaId() != null) {
				// 区
				list.add(snsActivityBO);
				page.getResult();
			} else if (snsActivityBO.getCid().equals(cid) && snsActivityBO.getAreaId() != null
					&& countyid == null) {
				// 市
				list.add(snsActivityBO);

			} else if (snsActivityBO.getPid().equals(pid) && snsActivityBO.getAreaId() != null
					&& countyid == null && cid == null) {
				// 省
				list.add(snsActivityBO);

			}
		}
		return list;
	}

	/**
	 * 根据条件查询 准备 活动列表
	 * 
	 * @param vo
	 * @param page
	 * @param provinceAreaid
	 *            省
	 * @param cityAreaid
	 *            市
	 * @param countyAreaid
	 *            区
	 * @param count
	 *            限制查询条数
	 * @return
	 */
	public List<SnsActivityBO> findbyVORead(SnsActivityVO vo, MyPage<SnsActivityBO> page,
			String provinceAreaid, String cityAreaid, String countyAreaid, Integer count, Integer isdel) {
		List<SnsActivityBO> listbo = snsActivityDao.findbyVO(vo, page, count, isdel);
		if (listbo == null) {
			return null;
		}
		Long pid = null;
		Long cid = null;
		Long countyid = null;
		if (StringUtils.isNotBlank(provinceAreaid)) {
			pid = Long.parseLong(provinceAreaid);
		}
		if (StringUtils.isNotBlank(cityAreaid)) {
			cid = Long.parseLong(cityAreaid);
		}
		if (StringUtils.isNotBlank(countyAreaid)) {
			countyid = Long.parseLong(countyAreaid);
		}
		List<SnsActivityBO> listRead = new ArrayList<SnsActivityBO>();
		for (SnsActivityBO snsActivityBO : listbo) {
			if (snsActivityBO.getAreaId().equals(countyid) && snsActivityBO.getAreaId() != null) {
				if (new Date().before(snsActivityBO.getActBg())) {
					// 准备中
					listRead.add(snsActivityBO);
				}
			} else if (snsActivityBO.getCid().equals(cid) && snsActivityBO.getAreaId() != null
					&& countyid == null) {
				if (new Date().before(snsActivityBO.getActBg())) {
					// 准备中
					listRead.add(snsActivityBO);
				}

			} else if (snsActivityBO.getPid().equals(pid) && snsActivityBO.getAreaId() != null
					&& countyid == null && cid == null) {
				if (new Date().before(snsActivityBO.getActBg())) {
					// 准备中
					listRead.add(snsActivityBO);
				}

			}
		}
		return listRead;
	}

	/**
	 * 根据条件查询 开始 活动列表
	 * 
	 * @param vo
	 *            ActivityVO
	 * @param page
	 * @return
	 */
	public List<SnsActivityBO> findbyVOBg(SnsActivityVO vo, MyPage<SnsActivityBO> page,
			String provinceAreaid, String cityAreaid, String countyAreaid, Integer count, Integer isdel) {
		List<SnsActivityBO> listbo = snsActivityDao.findbyVO(vo, page, count, isdel);
		if (listbo == null) {
			return null;
		}
		Long pid = null;
		Long cid = null;
		Long id = null;
		if (StringUtils.isNotBlank(provinceAreaid)) {
			pid = Long.parseLong(provinceAreaid);
		}
		if (StringUtils.isNotBlank(cityAreaid)) {
			cid = Long.parseLong(cityAreaid);
		}
		if (StringUtils.isNotBlank(countyAreaid)) {
			id = Long.parseLong(countyAreaid);
		}
		List<SnsActivityBO> listBg = new ArrayList<SnsActivityBO>();
		for (SnsActivityBO snsActivityBO : listbo) {
			if (snsActivityBO.getAreaId().equals(id) && snsActivityBO.getAreaId() != null) {
				if ((new Date().after(snsActivityBO.getActBg()) && new Date().before(snsActivityBO
						.getActEnd()))
						|| new Date().equals(snsActivityBO.getActBg())
						|| new Date().equals(snsActivityBO.getActEnd())) {
					// 进行中
					listBg.add(snsActivityBO);
				}
			} else if (snsActivityBO.getCid().equals(cid) && snsActivityBO.getAreaId() != null && id == null) {
				if ((new Date().after(snsActivityBO.getActBg()) && new Date().before(snsActivityBO
						.getActEnd()))
						|| new Date().equals(snsActivityBO.getActBg())
						|| new Date().equals(snsActivityBO.getActEnd())) {
					// 进行中
					listBg.add(snsActivityBO);
				}
			} else if (snsActivityBO.getPid().equals(pid) && snsActivityBO.getAreaId() != null && id == null
					&& cid == null) {
				if ((new Date().after(snsActivityBO.getActBg()) && new Date().before(snsActivityBO
						.getActEnd()))
						|| new Date().equals(snsActivityBO.getActBg())
						|| new Date().equals(snsActivityBO.getActEnd())) {
					// 进行中
					listBg.add(snsActivityBO);
				}
			}
		}
		return listBg;
	}

	/**
	 * 根据条件查询 结束 活动列表
	 * 
	 * @param vo
	 *            ActivityVO
	 * @param page
	 * @return
	 */
	public List<SnsActivityBO> findbyVOEnd(SnsActivityVO vo, MyPage<SnsActivityBO> page,
			String provinceAreaid, String cityAreaid, String countyAreaid, Integer count, Integer isdel) {
		List<SnsActivityBO> listbo = snsActivityDao.findbyVO(vo, page, count, isdel);
		if (listbo == null) {
			return null;
		}
		Long pid = null;
		Long cid = null;
		Long id = null;
		if (StringUtils.isNotBlank(provinceAreaid)) {
			pid = Long.parseLong(provinceAreaid);
		}
		if (StringUtils.isNotBlank(cityAreaid)) {
			cid = Long.parseLong(cityAreaid);
		}
		if (StringUtils.isNotBlank(countyAreaid)) {
			id = Long.parseLong(countyAreaid);
		}
		List<SnsActivityBO> listEnd = new ArrayList<SnsActivityBO>();
		for (SnsActivityBO snsActivityBO : listbo) {
			if (snsActivityBO.getAreaId().equals(id) && snsActivityBO.getAreaId() != null) {
				if (new Date().after(snsActivityBO.getActEnd())) {
					// 已完成
					listEnd.add(snsActivityBO);
				}
			} else if (snsActivityBO.getCid().equals(cid) && snsActivityBO.getAreaId() != null && id == null) {
				if (new Date().after(snsActivityBO.getActEnd())) {
					// 已完成
					listEnd.add(snsActivityBO);
				}

			} else if (snsActivityBO.getPid().equals(pid) && snsActivityBO.getAreaId() != null && id == null
					&& cid == null) {
				if (new Date().after(snsActivityBO.getActEnd())) {
					// 已完成
					listEnd.add(snsActivityBO);
				}
			}
		}
		return listEnd;
	}

	/** generate code begin **/
	public List<SnsActivityBO> findSnsActivityAll() {
		return snsActivityDao.findAll();

	}

	public boolean save(SnsActivity snsActivity) {
		this.snsActivityDao.save(snsActivity);
		return true;
	}

	public String redIpFind(HttpServletRequest request, HttpServletResponse response, String ip) {
		String ipdetail = "[---IP地址不正确!----]";
		if (ip != null && !ip.equals("") && ip.indexOf("0:0:0:0") < 0) {
			String[] split = ip.trim().split(",");
			ipdetail = IpAddressByDetails.GetAddressByIp(split[0].trim());
			System.out.println("ipdetail:" + ipdetail);
		}
		String ctys[] = ipdetail.split("--");
		String city = ctys[2];
		return city;
	}

	/**
	 * 根据ID查找一条记录
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	public SnsActivityBO findByIdOne(Long id, Integer isdel) {
		List<SnsActivityBO> list = snsActivityDao.findTopAc(null, 1, isdel);
		List<SnsActivityBO> listrt = new ArrayList<SnsActivityBO>();
		String arName = "地址获取失败";
		for (SnsActivityBO snsActivityBO : list) {
			if (snsActivityBO.getId() == id) {
				if (snsActivityBO.getAreaId() != null) {
					AreaBO areaBO = areaDao.selectNameByAreaId(snsActivityBO.getAreaId());
					arName = areaBO.getProvinceName() + "—" + areaBO.getCityName() + "—"
							+ areaBO.getCityName();
					snsActivityBO.setAreaname(arName);
					return snsActivityBO;
				}
			}
		}
		return null;
	}

	/**
	 * 根据ID查找下一条记录
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	public SnsActivityBO findByIdNext(Long id, Integer isdel) {
		List<SnsActivityBO> list = snsActivityDao.findTopAc(null, 1, isdel);
		List<SnsActivityBO> listrt = new ArrayList<SnsActivityBO>();
		for (SnsActivityBO snsActivityBO : list) {
			System.out.println("findByIdNext id " + snsActivityBO.getId());
			if (snsActivityBO.getId() > id) {
				return snsActivityBO;
			}
		}
		return null;
	}

	/**
	 * 根据ID查找上一条记录
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	public SnsActivityBO findByIdPrevious(Long id, Integer isdel) {
		List<SnsActivityBO> list = snsActivityDao.findTopAc(null, 2, isdel);
		List<SnsActivityBO> listrt = new ArrayList<SnsActivityBO>();
		for (SnsActivityBO snsActivityBO : list) {
			System.out.println("findByIdPrevious id " + snsActivityBO.getId());
			if (snsActivityBO.getId() < id) {
				return snsActivityBO;
			}
		}
		return null;
	}

	/**
	 * 将分页信息封装到ModelAndView中
	 * 
	 * @param url
	 *            分页url
	 * @param staticURL
	 *            静态分页URL，使用urlrewrite实现伪静态
	 * @param params
	 *            非静态URL的参数
	 * @param pList
	 *            分页数据查询结果
	 * @param mv
	 *            输出的视图
	 */
	@SuppressWarnings("rawtypes")
	public static void saveIPageList2ModelAndView(String url, String staticURL, String params,
			IPageList pList, ModelAndView mv, List list) {
		if (list != null) {
			mv.addObject("objs", list);
			mv.addObject("totalPage", new Integer(pList.getPages()));
			mv.addObject("pageSize", pList.getPageSize());
			mv.addObject("rows", new Integer(pList.getRowCount()));
			mv.addObject("currentPage", new Integer(pList.getCurrentPage()));
			mv.addObject("gotoPageHTML",
					CommUtil.showPageHtml(url, params, pList.getCurrentPage(), pList.getPages()));
			mv.addObject("gotoPageFormHTML", CommUtil.showPageFormHtml(pList.getCurrentPage(),
					pList.getPages(), pList.getPageSize(), new Integer(pList.getRowCount())));
			mv.addObject(
					"gotoPageStaticHTML",
					CommUtil.showPageStaticHtml(staticURL, pList.getCurrentPage(), pList.getPages(),
							pList.getPageSize(), pList.getRowCount()));
			mv.addObject(
					"gotoPageAjaxHTML",
					CommUtil.showPageAjaxHtml(url, params, pList.getCurrentPage(), pList.getPages(),
							pList.getPageSize(), pList.getRowCount()));
		}
	}

}
