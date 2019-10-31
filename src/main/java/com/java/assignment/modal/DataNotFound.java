package com.java.assignment.modal;

import io.swagger.annotations.ApiModelProperty;

public class DataNotFound extends ModalDao {
	
	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	public final String DATANOTFOUND = "Data not Found";

	public String getDATANOTFOUND() {
		return DATANOTFOUND;
	}

}
