<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage_dir}.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import ${basepackage}.${subpackage_dir}.bo.vo.${className}Request;
import ${basepackage}.${subpackage_dir}.bo.po.${className}Response;
import ${basepackage}.${subpackage_dir}.model.${className};

<#include "/java_copyright.include">

public interface ${className}Service extends IBaseService<${className}> {
	PageResponse<${className}Response> queryByObject (${className}Request ${classNameLower}Request);

	${className}Response assemble${className}(${className} ${classNameLower});

	${className} assemble${className}(${className}Request ${classNameLower}Request);
}