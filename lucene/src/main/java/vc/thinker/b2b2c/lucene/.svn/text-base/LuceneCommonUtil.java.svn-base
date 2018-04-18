package vc.thinker.b2b2c.lucene;

import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * add by james
 * 
 * @author james
 * 
 */
public class LuceneCommonUtil {
	/**
	 * 将lucene对象转换为分页对象
	 * 
	 * @param pList
	 * @param mv
	 */
	public static void saveLucene2ModelAndView(LuceneResult pList, ModelAndView mv) {
		if (pList != null) {
			mv.addObject("objs", pList.getVo_list());
			mv.addObject("totalPage", pList.getPages());
			mv.addObject("pageSize", pList.getPageSize());
			mv.addObject("rows", pList.getRows());
			mv.addObject("currentPage", new Integer(pList.getCurrentPage()));
			mv.addObject("gotoPageFormHTML", CommUtil.showPageFormHtml(pList.getCurrentPage(),
					pList.getPages(), pList.getPageSize(), pList.getRows()));
		}
	}
}
