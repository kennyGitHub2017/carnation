package com.sinco.carnation.sys.bo;

import com.sinco.carnation.sys.model.AdContent;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class AdContentBO extends AdContent {
			private String areaName;
			
			
			
	
			private String dname;
			private Long did;

			public Long getDid() {
				return did;
			}

			public void setDid(Long did) {
				this.did = did;
			}

			public String getDname() {
				return dname;
			}

			public void setDname(String dname) {
				this.dname = dname;
			}

			
			
			
			
			
			
			
				public String getAreaName() {
				return areaName;
			}
			public void setAreaName(String areaName) {
				this.areaName = areaName;
			}
	private static final long serialVersionUID = 1L;

	private String style;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}