package vc.thinker.b2b2c.foundation.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void manufacturerIsNull() {
		Car car = new Car(null, "DD-AB-123", 4);

		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

		for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getMessage());
		}
	}

}