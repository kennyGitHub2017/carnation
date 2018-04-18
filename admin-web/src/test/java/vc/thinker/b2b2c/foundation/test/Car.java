package vc.thinker.b2b2c.foundation.test;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Car {

	@Pattern(regexp = "a|b")
	private String manufacturer;

	@NotNull
	@Size(min = 2, max = 14)
	private String licensePlate;

	@Min(2)
	private Integer seatCount;

	public Car(String manufacturer, String licencePlate, int seatCount) {
		this.manufacturer = manufacturer;
		this.licensePlate = licencePlate;
		this.seatCount = seatCount;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	// getters and setters ...
}