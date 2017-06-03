<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameAllLower = table.classNameLowerCase>
package ${basepackage}.${subpackage_dir}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import ${basepackage}.common.bo.PageResponse;
import ${basepackage}.${subpackage_dir}.bo.${className}Request;
import ${basepackage}.${subpackage_dir}.model.${className};
import ${basepackage}.${subpackage_dir}.service.${className}Service;

<#include "/java_copyright.include">

@Controller
@RequestMapping("/api/${tableNameAllLower}")
public class ${className}Controller extends BaseController {

	@Autowired
	${className}Service ${classNameLower}Service;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	private String insert (${className} record) {
		int r = ${classNameLower}Service.insert(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	private String delete (Long id) {
		int r = ${classNameLower}Service.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	private String update (${className} record) {
		int r = ${classNameLower}Service.update(record);
		String str = callbackSuccess (r);
		return str;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	private String list (${className}Request clientRequest) {
		PageResponse<${className}> r = ${classNameLower}Service.queryForPage(clientRequest);
		String str = callbackSuccess (r);
		return str;
	}

}