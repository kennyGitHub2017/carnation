/*package vc.thinker.b2b2c.action.healthCircle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.constants.ImageConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.DateFormatUtil;

import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.service.PostEvaluateService;
import com.sinco.carnation.healthcircle.service.PostService;
import com.sinco.carnation.sys.service.LabelService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

@Controller
public class PostController{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SysConfigService configService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private PostEvaluateService postEvaluateService;
	
	@Autowired
	private UserCustomerService userCustomerService;
	
	@Autowired
	private LabelService postLabelService;
	
	*//**
 * 根据id查询帖子详情/h5开发
 * @param Id
 * @param request
 * @return
 */
/*
@RequestMapping(value = "/post/page_post_detail", method = RequestMethod.GET)
public ModelAndView postDetail(HttpServletRequest request,
	HttpServletResponse response,Long Id,Long uid){
logger.info("============ 帖子详情 ============== ");
ModelAndView model =new JModelAndView("healthCircle/postDetail.html",
		configService.getSysConfig(),
		 1, request, response);
String result = "success";
if (Id == null) {
	result = "fail";
}
Post post=postService.selectById(Id,uid);
List<Post> list=new ArrayList();
 Date date=post.getAddTime();
 SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
if(post!=null){
 list.add(post);
 list=getImages(list);
 post=list.get(0);
 String addtimeFormat=DateFormatUtil.formatDisplayTime( todayDf.format(date), "yyyy-MM-dd HH:mm:ss");
 post.setAddtiemFormat(addtimeFormat);
 model.addObject("postBO",post);
}
//根据帖子id查询所有评论信息
MyPage<PostEvaluate> page=new MyPage<PostEvaluate>();
page.setPageNumber(1);
page.setPageSize(1000);
List<PostEvaluate> evaluatelist=postEvaluateService.selectPageByPostId(page,Long.valueOf(Id));
model.addObject("evaluateList", evaluatelist);
model.addObject("headImageSize", ImageConstants.USER_HEAD);
String webPath = CommUtil.getURL(request);
model.addObject("webPath", webPath);
model.addObject("result", result);
return model;
}

*//**
 * 帖子评论/h5开发
 * @param 帖子id
 * @param request
 * @return
 * @throws Exception 
 */
/*
@RequestMapping(value = "/post/post_postEvaluete", method = RequestMethod.POST)
public void uodate_postEvaluete(HttpServletRequest request,
	HttpServletResponse response,Long postId,String content,Long uid) throws Exception {
Map<String, Object> resp = new HashMap<>();
PostEvaluate eval=new PostEvaluate();
eval.setPostId(postId);
eval.setContent(content);
eval.setFromUserid(uid);
//eval.setToUserid(vo.getToUserId());
eval.setType(0);//评论
eval.setPid(Long.valueOf(-1));//评论时全为-1
int num=postService.updatePostEvaluete(eval);
eval.setAddtiemFormat("刚刚");
UserCustomerBO user=userCustomerService.searchCustomer(uid);
if(user!=null){
	eval.setHeadImgPath(user.getHeadImgPath());
}
resp.put("evalBO",eval);
response.setContentType("text/plain");
response.setHeader("Cache-Control", "no-cache");
response.setCharacterEncoding("UTF-8");
PrintWriter writer;
try {
	writer = response.getWriter();
	writer.print(Json.toJson(resp, JsonFormat.compact()));
} catch (IOException e) {
	e.printStackTrace();
}
}

*//**
 * 评论回复/h5开发
 * @param 帖子id
 * @param request
 * @return
 */
/*
@RequestMapping(value = "/post/post_replyEvaluete", method = RequestMethod.POST)
public void uodate_replyEvaluete(HttpServletRequest request,
	HttpServletResponse response,Long postId,String content,Long PID,Long uid) {
Map<String, Object> resp = new HashMap<>();
PostEvaluate eval=new PostEvaluate();
eval.setPostId(postId);
eval.setContent(content);
eval.setFromUserid(uid);
eval.setType(1);//回复
eval.setPid(PID);//回复某条评论的id
int num=postService.updateReplyEvaluete(eval);
eval.setAddtiemFormat("刚刚");
resp.put("evalBO",eval);
response.setContentType("text/plain");
response.setHeader("Cache-Control", "no-cache");
response.setCharacterEncoding("UTF-8");
PrintWriter writer;
try {
	writer = response.getWriter();
	writer.print(Json.toJson(resp, JsonFormat.compact()));
} catch (IOException e) {
	e.printStackTrace();
}	
}
*//**
 * 对图片字符串进行相应的处理
 */
/*
public List<Post> getImages(List<Post> list){
for(Post post:list){
	String[] images=null;
	String thumbnail=post.getThumbnail();
	if(StringUtils.isNotEmpty(thumbnail)){
		images = thumbnail.split("\\|");
		post.setImagesList(images);
	}		
}
return list;
}
}
*/