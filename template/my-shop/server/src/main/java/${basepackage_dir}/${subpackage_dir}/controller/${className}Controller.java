<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameAllLower = table.classNameLowerCase>
package ${basepackage}.${subpackage_dir}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
//import com.srsj.common.bo.PageResponse;
import ${basepackage}.${subpackage_dir}.bo.vo.${className}Request;
import ${basepackage}.${subpackage_dir}.bo.po.${className}Response;
import ${basepackage}.${subpackage_dir}.model.${className};
import ${basepackage}.${subpackage_dir}.service.${className}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

<#include "/java_copyright.include">

@Api(value = "API - ${className}Controller", description = "${className}模块接口详情")
@Controller
@RequestMapping("/api/${tableNameAllLower}")
public class ${className}Controller extends BaseController {

	@Autowired
	${className}Service ${classNameLower}Service;

	@ApiOperation(value = "${className} 添加", notes = "此接口描述xxxx<<br>支持html标签<hr/>", response = ${className}Response.class)
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String insert (@RequestBody ${className}Request params) {
		${className} ${classNameLower} = assemble${className}(params);
		int r = ${classNameLower}Service.insert(${classNameLower});
		String str = callbackSuccess (r);
		return str;
	}

	@ApiOperation(value = "${className} 删除", notes = "此接口描述xxxx<<br>支持html标签<hr/>", response = ${className}Response.class)
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String delete (@RequestBody Long id) {
		int r = ${classNameLower}Service.delete(id);
		String str = callbackSuccess (r);
		return str;
	}
	@ApiOperation(value = "${className} 修改", notes = "此接口描述xxxx<<br>支持html标签<hr/>", response = ${className}Response.class)
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String update (@RequestBody ${className}Request params) {
		${className} ${classNameLower} = assemble${className}(params);
		int r = ${classNameLower}Service.update(${classNameLower});
		String str = callbackSuccess (r);
		return str;
	}

	@ApiOperation(value = "${className} 列表", notes = "此接口描述xxxx<<br>支持html标签<hr/>", response = ${className}Response.class)
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String list (@RequestBody ${className}Request params) {
//		PageResponse<${className}> r = ${classNameLower}Service.queryForPage(clientRequest);
//		String str = callbackSuccess (r);
//		return str;
		String str = callbackSuccess ("list");
		return str;
	}

	/**
	 * 数据库查询成功后； ${className} 转换为 ${className}Response
	 * @param ${classNameLower}
	 * @return
	 */
	private static ${className}Response assemble${className} (${className} ${classNameLower} ){

		${className}Response ${classNameLower}Response = new ${className}Response();
		<#list table.columns as column>
		${classNameLower}Response.set${column.columnName}(${classNameLower}.get${column.columnName}());
		</#list>
		return ${classNameLower}Response;
	}

	/**
	 * 客户端请求 ${className}Request 转换为 ${className}
	 * @param ${classNameLower}Request
	 * @return
	 */
	private static ${className} assemble${className} (${className}Request ${classNameLower}Request ){
		${className} ${classNameLower} = new ${className}();
		<#list table.columns as column>
		${classNameLower}.set${column.columnName}(${classNameLower}Request.get${column.columnName}());
		</#list>
		return ${classNameLower};
	}
}