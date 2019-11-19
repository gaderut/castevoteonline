package com.ovs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FingerPrint {
	String voterId;
	String fingerPrintPath;

	public FingerPrint(){
		
	}
	
	public FingerPrint(String voterId, String fingerPrintPath) {
		super();
		this.voterId = voterId;
		this.fingerPrintPath = fingerPrintPath;
	}

	@XmlElement(name = "voterId")
	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	@XmlElement(name = "fingerPrintPath")
	public String getFingerPrintPath() {
		return fingerPrintPath;
	}

	public void setFingerPrintPath(String fingerPrintPath) {
		this.fingerPrintPath = fingerPrintPath;
	}
}
