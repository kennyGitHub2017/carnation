package vc.thinker.b2b2c.model.elong.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.sinco.api.annotation.Param;

public class OrderSubmitRequestVO {
	@Param(desc = "酒店编号")
	@NotBlank(message = "酒店编号不能为空")
	private String hotelId;
	
	@Param(desc = "产品编号")
	@Range(min=1, message = "产品编号不能小于1")
	private int ratePlanId;
	
	@Param(desc = "房型编号")
	@NotBlank(message = "房型编号不能为空")
	private String roomTypeId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Param(desc = "入住时间")
	@NotNull(message = "入住时间不能为空")
    private Date arrivalDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Param(desc = "离店时间")
	@NotNull(message = "离店时间不能为空")
    private Date departureDate;
	
	@Param(desc = "支付方式")
	@NotBlank(message = "支付方式不能为空")
	private String paymentType;

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRatePlanId() {
		return ratePlanId;
	}

	public void setRatePlanId(int ratePlanId) {
		this.ratePlanId = ratePlanId;
	}

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
}
