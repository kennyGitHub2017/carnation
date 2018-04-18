package vc.thinker.b2b2c.model.elong.vo;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.sinco.api.annotation.DateFormatValidate;
import com.sinco.api.annotation.Param;
import com.sinco.carnation.elong.model.h5.viewmodel.order.CustomerInfo;

public class OrderCreateRequestVO extends OrderSubmitRequestVO {
	@Param(desc = "最晚到店时间")
	@NotBlank(message = "最晚到店时间不能为空")
	@DateFormatValidate(format = "yyyy-MM-dd HH:mm:ss", message = "最晚到店时间格式错误")
	private String latestArrivalTimeString;
	
	@Param(desc = "房间数量")
	@Min(value = 1, message = "房间数量不能小于1")
	private int numberOfRooms;
	
	@Param(desc = "联系人")
	@NotNull(message = "联系人不能为空")
	private CustomerInfo contact;
	
	@Param(desc = "入住人")
	@NotEmpty(message = "入住人信息不能为空")
	private List<CustomerInfo> guesterList;
	
	public String getLatestArrivalTimeString() {
		return latestArrivalTimeString;
	}
	public void setLatestArrivalTimeString(String latestArrivalTimeString) {
		this.latestArrivalTimeString = latestArrivalTimeString;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public CustomerInfo getContact() {
		return contact;
	}
	public void setContact(CustomerInfo contact) {
		this.contact = contact;
	}
	public List<CustomerInfo> getGuesterList() {
		return guesterList;
	}
	public void setGuesterList(List<CustomerInfo> guesterList) {
		this.guesterList = guesterList;
	}
}
