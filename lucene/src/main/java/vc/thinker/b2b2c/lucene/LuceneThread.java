package vc.thinker.b2b2c.lucene;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>
 * Title: LuceneThread.java
 * </p>
 * 
 * <p>
 * Description: lucene搜索工具类，该类使用线程处理索引的建立，默认每天凌晨更新一次商城索引文件
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class LuceneThread implements Runnable {
	@SuppressWarnings("unused")
	private String path;
	private List<LuceneVo> vo_list = new ArrayList<LuceneVo>();
	private LuceneUtil luceneUtil;

	public LuceneThread(LuceneUtil luceneUtil, String path, List<LuceneVo> vo_list) {
		super();
		this.path = path;
		this.vo_list = vo_list;
		this.luceneUtil = luceneUtil;
	}

	@Override
	public void run() {
		// LuceneUtil lucene = LuceneUtil.instance();
		// lucene.setIndex_path(this.path);
		// lucene.deleteAllIndex(true);
		// lucene.writeIndex(vo_list);
		for (LuceneVo vo : vo_list) {
			luceneUtil.update(vo.getVo_id().toString(), vo);
		}
	}
}
