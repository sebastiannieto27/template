package co.com.core.commons.query;

import java.util.Iterator;
import java.util.Map;

import org.springframework.util.StringUtils;


public class QueryUtil {

	public static final String PROPERTY = "property";
	public static final String CONDITIONAL = ".conditional";//e.g like
	public static final String OPERATION = ".operation";//e.g and
	public static final String FUNCTION = ".function";//e.g sum
	public static final String VALUE= ".value";
	public static final String VALUE_2= ".value2";
	
	public static final String CONDITIONAL_WHERE = "where";
	public static final String WHITE_SPACE= " ";
	public static final String HQL_SEPARATOR= ":";

	public static final String OPERATOR_AND = "and";
	public static final String OPERATOR_OR = "or";
	
	public static final String LIKE = "like";
	public static final String EQUALS = "=";
	public static final String GREATER = ">";
	public static final String GREATER_EQUAL = ">=";
	public static final String LOWER = "<";
	public static final String LOWER_EQUAL = "<=";
	public static final String BETWEEN = "between";
	
	public static final String FUNCTION_UPPER = "upper";
	public static final String FUNCTION_LOWER = "lower";
	public static final String FUNCTION_SUM = "sum";
	public static final String FUNCTION_AVG = "avg";
	public static final String FUNCTION_MIN = "min";
	public static final String FUNCTION_MAX = "max";
	public static final String FUNCTION_COUNT = "count";
	
	public static final String PROPERTY_ONE = "property1";
	public static final String PROPERTY_TWO = "property2";

	public static final String STATEMENT= "statement";
	public static final String PARAMETER= "parameter";
	
	
	public static StringBuilder buildQUery(Map<String, Object> filters) {
		StringBuilder query = new StringBuilder();
		int propertyCounter = 0;
		
		if(filters.containsKey(CONDITIONAL_WHERE)) {
			query.append(WHITE_SPACE).append(CONDITIONAL_WHERE).append(WHITE_SPACE);
		}
		
		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			
			String filterProperty = it.next();
			
			String propKey = PROPERTY + propertyCounter;
			String property = "";
			String operation = "";
			String conditional = "";
			String function = "";
			Object value = null;
			Object value2 = null;
			
			if(filters.get(propKey)!=null) {
				property = (String) filters.get(propKey);
			}
			
			String operationKey = propKey + OPERATION;
			if(filters.get(operationKey)!=null) {
				operation = (String) filters.get(operationKey);
			}
			
			String conditionalKey = propKey + CONDITIONAL;
			if(filters.get(conditionalKey)!=null) {
				conditional = (String) filters.get(conditionalKey);
			}
			String functionKey = propKey + FUNCTION;
			if(filters.get(functionKey)!=null) {
				function = (String) filters.get(functionKey);
			}
			
			String valueKey = propKey + VALUE;
			if(filters.get(valueKey)!=null) {
				value = (Object) filters.get(valueKey);
			}
			
			String value2Key = propKey + VALUE_2;
			if(filters.get(value2Key)!=null) {
				value2 = (Object) filters.get(value2Key);
			}
			
			if(StringUtils.hasText(property)) {
				if(StringUtils.hasText(operation)) {
					query.append(setOperation(operation));
				}
				if(StringUtils.hasText(conditional)) {
					query.append(setConditional(conditional, property, value, value2, function));
				}
			}
			
			propertyCounter++;
		}
		return query;
	}
	
	public static final String setOperation(String operationKey) {
		StringBuilder operation = new StringBuilder();
		if(operationKey.equalsIgnoreCase(OPERATOR_AND)) {
			operation.append(WHITE_SPACE).append(OPERATOR_AND).append(WHITE_SPACE);
		} else if(operationKey.equalsIgnoreCase(OPERATOR_OR)) {
			operation.append(WHITE_SPACE).append(OPERATOR_OR).append(WHITE_SPACE);
		}
		
		return operation.toString();
	}
	
	public static final String setConditional(String conditionalKey, String field1, Object value1, Object value2, String function) {
		StringBuilder conditional =  new StringBuilder();
		
		String field = setFunction(function, field1);
		
		if(conditionalKey.equalsIgnoreCase(EQUALS)) {
			conditional.append(WHITE_SPACE).append(field).append(EQUALS).append(WHITE_SPACE).append(value1).append(WHITE_SPACE);
		} else if(conditionalKey.equalsIgnoreCase(GREATER)) {
			conditional.append(WHITE_SPACE).append(field).append(GREATER).append(WHITE_SPACE).append(value1).append(WHITE_SPACE);
		} else if(conditionalKey.equalsIgnoreCase(GREATER_EQUAL)) {
			conditional.append(WHITE_SPACE).append(field).append(GREATER_EQUAL).append(WHITE_SPACE).append(value1).append(WHITE_SPACE);
		} else if(conditionalKey.equalsIgnoreCase(LOWER)) {
			conditional.append(WHITE_SPACE).append(field).append(LOWER).append(WHITE_SPACE).append(value1).append(WHITE_SPACE);
		} else if(conditionalKey.equalsIgnoreCase(LOWER_EQUAL)) {
			conditional.append(WHITE_SPACE).append(field).append(LOWER_EQUAL).append(WHITE_SPACE).append(value1).append(WHITE_SPACE);
		} else if(conditionalKey.equalsIgnoreCase(LIKE)) {
			conditional.append(WHITE_SPACE).append(field).append(LIKE).append(WHITE_SPACE).append(value1).append(WHITE_SPACE);
		} else if(conditionalKey.equalsIgnoreCase(BETWEEN)) {
			conditional.append(WHITE_SPACE).append(field).append(BETWEEN).append(WHITE_SPACE).append(WHITE_SPACE)
			.append(value1).append(WHITE_SPACE).append(OPERATOR_AND).append(WHITE_SPACE).append(value2).append(WHITE_SPACE);
		}
		return conditional.toString();
	}
	
	public static final String setFunction(String functionKey, String field) {
		StringBuilder function =  new StringBuilder();
		if(functionKey.equalsIgnoreCase(FUNCTION_LOWER)) {
			function.append(WHITE_SPACE).append(FUNCTION_LOWER).append("(").append(field).append(")").append(WHITE_SPACE);
		} else if(functionKey.equalsIgnoreCase(FUNCTION_UPPER)) {
			function.append(WHITE_SPACE).append(FUNCTION_UPPER).append("(").append(field).append(")").append(WHITE_SPACE);
		} else if(functionKey.equalsIgnoreCase(FUNCTION_SUM)) {
			function.append(WHITE_SPACE).append(FUNCTION_SUM).append("(").append(field).append(")").append(WHITE_SPACE);
		} else if(functionKey.equalsIgnoreCase(FUNCTION_AVG)) {
			function.append(WHITE_SPACE).append(FUNCTION_AVG).append("(").append(field).append(")").append(WHITE_SPACE);
		} else if(functionKey.equalsIgnoreCase(FUNCTION_COUNT)) {
			function.append(WHITE_SPACE).append(FUNCTION_COUNT).append("(").append(field).append(")").append(WHITE_SPACE);
		} else if(functionKey.equalsIgnoreCase(FUNCTION_MAX)) {
			function.append(WHITE_SPACE).append(FUNCTION_MAX).append("(").append(field).append(")").append(WHITE_SPACE);
		} else if(functionKey.equalsIgnoreCase(FUNCTION_MIN)) {
			function.append(WHITE_SPACE).append(FUNCTION_MIN).append("(").append(field).append(")").append(WHITE_SPACE);
		} else {
			function.append(WHITE_SPACE).append(field).append(WHITE_SPACE);
		}
		return function.toString();
	}
}
