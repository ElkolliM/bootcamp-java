package com.stackroute.datamunger.query;

public class DataTypeDefinitions {
	String[] dataTypes;

	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */

	public DataTypeDefinitions(String[] dataTypes) {
		super();
		this.dataTypes = dataTypes;
	}


	public String[] getDataTypes() {

		return dataTypes ;
	}

	public void setDataTypes(String[] dataTypes) {
		this.dataTypes = dataTypes;
	}


}
