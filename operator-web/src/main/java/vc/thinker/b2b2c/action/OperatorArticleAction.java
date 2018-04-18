package vc.thinker.b2b2c.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.dal.common.MyPage;

@Controller
public class OperatorArticleAction {

	@Autowired
	private ArticleService articleService;

	@SecurityMapping(title = "平台公告", value = "/operator/operator_article_list.htm*", rtype = "operator", rname = "平台公告", rcode = "operator_article_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_article_list.htm")
	public String operatorArticleList(Model model, MyPage<ArticleBO> page, Article vo) {
		articleService.findByParentMark("operatornotice", page);

		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("rebateConstants", new RebateConstants());
		return "operator_article_list.html";
	}

	@SecurityMapping(title = "平台公告查看", value = "/operator/operator_article_view.htm*", rtype = "operator", rname = "平台公告查看", rcode = "operator_article_view", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_article_view.htm")
	public String operatorArticleView(Model model, Long id) {
		Article article = articleService.getObjById(id);
		model.addAttribute("obj", article);
		return "operator_article_view.html";
	}

}
