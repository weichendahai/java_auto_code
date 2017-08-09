<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage_dir}.dao;

import org.springframework.stereotype.Repository;

import com.srsj.common.dao.BaseDao;
import ${basepackage}.${subpackage_dir}.model.${className};

<#include "/java_copyright.include">

@Repository
public interface ${className}Dao extends BaseDao<${className}> {

}