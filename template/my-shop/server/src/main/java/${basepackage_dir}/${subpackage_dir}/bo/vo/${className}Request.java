<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage_dir}.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.srsj.common.bo.PageRequest;
import java.util.Date;

<#include "/java_copyright.include">

//public class ${className}Request extends PageRequest {
@ApiModel(value = "${table.tableAlias}Request", description = "${table.tableAlias}Request")
public class ${className}Request {

	<#list table.columns as column>
	// ${column.columnAlias}
	@ApiModelProperty(value = "${column.columnAlias}")
	@JsonProperty("${column.sqlName}")
	private ${column.simpleJavaType} ${column.columnNameLower};

	</#list>
		
	<#list table.columns as column>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</#list>
}
<#macro generateJavaColumns>
	<#list table.columns as column>
    <@generateBycondition column.sqlName>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</@generateBycondition>
	</#list>
</#macro>