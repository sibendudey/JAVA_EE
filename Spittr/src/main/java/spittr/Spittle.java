package spittr;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spittle {
	
	private final Long ID;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public Spittle(String message , Date time)	{
		this(message , time , null , null);
	}
	
	public Spittle(String message , Date time , Double latitude , Double longitude){
		this.ID = null;	
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getID() {
		return ID;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}
	
	/*
	@Override
	public boolean equals(Object that) {
	return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}
	@Override
	public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}*/
}
