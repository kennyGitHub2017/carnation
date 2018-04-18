package com.sinco.carnation.elong.vo;

import com.sinco.carnation.elong.model.ElongOrder;

public class ElongOrderVO extends ElongOrder{
					
	private static final long serialVersionUID = 4412160555816504169L;
			private String mobile;
			private String name;
			private String beginTime;
			private String endTime;
			private Integer statusId;
			private String arrDate;
			private String depaDate;
			
			public String getArrDate() {
				return arrDate;
			}
			public void setArrDate(String arrDate) {
				this.arrDate = arrDate;
			}
			public String getDepaDate() {
				return depaDate;
			}
			public void setDepaDate(String depaDate) {
				this.depaDate = depaDate;
			}
			public String getBeginTime() {
				return beginTime;
			}
			public void setBeginTime(String beginTime) {
				this.beginTime = beginTime;
			}
			public String getEndTime() {
				return endTime;
			}
			public void setEndTime(String endTime) {
				this.endTime = endTime;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
			
		
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public Integer getStatusId() {
				return statusId;
			}
			public void setStatusId(Integer statusId) {
				this.statusId = statusId;
			}
			public ElongOrderVO(){
				
			}
			
			public ElongOrderVO(Integer statusId,String showStatus){
				this.statusId = statusId;
				this.setShowStatus(showStatus);
			}
	
		
}	
