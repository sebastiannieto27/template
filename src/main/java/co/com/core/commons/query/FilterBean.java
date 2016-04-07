package co.com.core.commons.query;

public class FilterBean {

	private String key;
	private String name;
	private String HQLName;
	private String conditional;
	private String function;
	private String operation;
	private Object value;
	private String valueType;
	private String queryParameter;
	private String queryParameterName;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHQLName() {
		return HQLName;
	}
	public void setHQLName(String hQLName) {
		HQLName = hQLName;
	}
	public String getConditional() {
		return conditional;
	}
	public void setConditional(String conditional) {
		this.conditional = conditional;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public String getQueryParameter() {
		return queryParameter;
	}
	public void setQueryParameter(String queryParameter) {
		this.queryParameter = queryParameter;
	}
	public String getQueryParameterName() {
		return queryParameterName;
	}
	public void setQueryParameterName(String queryParameterName) {
		this.queryParameterName = queryParameterName;
	}
	
}
