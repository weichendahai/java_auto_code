<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage_dir}.service.impl;

import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import ${basepackage}.${subpackage_dir}.model.${className};
import ${basepackage}.${subpackage_dir}.dao.${className}Dao;
import ${basepackage}.${subpackage_dir}.service.${className}Service;

<#include "/java_copyright.include">

@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Dao,${className}> implements ${className}Service {

}
