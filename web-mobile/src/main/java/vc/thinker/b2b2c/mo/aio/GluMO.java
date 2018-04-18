package vc.thinker.b2b2c.mo.aio;


/**
 * 一体机血糖表
 * 
 * @author yuanming
 * 
 */
public class GluMO {
	private Long id;
	// 数据同步时间
	private String syncTime;
	// 用户身份证号码
	private String idCard;
	// 血糖
	private String glu;
	// 状态标志
	private String flag;
	// 测量的日期
	private String date;
	// 测量的时间
	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getGlu() {
		return glu;
	}

	public void setGlu(String glu) {
		this.glu = glu;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
