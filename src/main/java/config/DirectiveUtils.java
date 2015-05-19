package config;

import java.util.Map;

import cn.org.rapid_framework.freemarker.directive.*;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import org.apache.commons.lang.StringUtils;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

/**
 * @author badqiu
 */
public class DirectiveUtils {

    public static String BLOCK = "__ftl_override__";
    public static String OVERRIDE_CURRENT_NODE = "__ftl_override_current_node";

    public static String getOverrideVariableName(String name) {
        return BLOCK + name;
    }

    public static void exposeRapidMacros(Configuration conf) {
        conf.setSharedVariable(cn.org.rapid_framework.freemarker.directive.BlockDirective.DIRECTIVE_NAME, new cn.org.rapid_framework.freemarker.directive.BlockDirective());
        conf.setSharedVariable(cn.org.rapid_framework.freemarker.directive.ExtendsDirective.DIRECTIVE_NAME, new ExtendsDirective());
        conf.setSharedVariable(cn.org.rapid_framework.freemarker.directive.OverrideDirective.DIRECTIVE_NAME, new OverrideDirective());
        conf.setSharedVariable(SuperDirective.DIRECTIVE_NAME, new SuperDirective());
    }

    static String getRequiredParam(Map params,String key) throws TemplateException {
        Object value = params.get(key);
        if(value == null || StringUtils.isEmpty(value.toString())) {
            throw new TemplateModelException("not found required parameter:"+key+" for directive");
        }
        return value.toString();
    }

    static String getParam(Map params,String key,String defaultValue) throws TemplateException {
        Object value = params.get(key);
        return value == null ? defaultValue : value.toString();
    }

    static config.OverrideDirective.TemplateDirectiveBodyOverrideWraper getOverrideBody(Environment env, String name) throws TemplateModelException {
        config.OverrideDirective.TemplateDirectiveBodyOverrideWraper value = (config.OverrideDirective.TemplateDirectiveBodyOverrideWraper)env.getVariable(DirectiveUtils.getOverrideVariableName(name));
        return value;
    }

    static void setTopBodyForParentBody(Environment env,
                                        config.OverrideDirective.TemplateDirectiveBodyOverrideWraper topBody,
                                        config.OverrideDirective.TemplateDirectiveBodyOverrideWraper overrideBody) {
        config.OverrideDirective.TemplateDirectiveBodyOverrideWraper parent = overrideBody;
        while(parent.parentBody != null) {
            parent = parent.parentBody;
        }
        parent.parentBody = topBody;
    }
}

