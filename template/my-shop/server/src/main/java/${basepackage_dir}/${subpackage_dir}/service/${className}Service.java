<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage_dir}.service;

import com.srsj.common.service.IBaseService;
import ${basepackage}.${subpackage_dir}.model.${className};

<#include "/java_copyright.include">

public interface ${className}Service extends IBaseService<${className}> {

}

