package com.sinco.carnation.elong.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.sinco.carnation.elong.model.elong.EnumLocal;
import com.sinco.carnation.elong.model.elong.HotelListCondition;

@XmlRootElement(name = "Condition")
@XmlSeeAlso({HotelListCondition.class})
public class BaseRequst<T> {

	@XmlElement(name = "Version")
	public double Version;
	
	@XmlElement(name = "Local")
    public EnumLocal Local;

	@XmlElement(name = "Request")
    public T Request;
	
}
