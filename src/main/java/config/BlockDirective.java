package config;
import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author //
 */
public class BlockDirective implements TemplateDirectiveModel{
    public final static String DIRECTIVE_NAME = "block";

    public void execute(Environment env,
                        Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        String name = DirectiveUtils.getRequiredParam(params, "name");
        OverrideDirective.TemplateDirectiveBodyOverrideWraper overrideBody = DirectiveUtils.getOverrideBody(env, name);
        if(overrideBody == null) {
            if(body != null) {
                body.render(env.getOut());
            }
        }else {
            DirectiveUtils.setTopBodyForParentBody(env, new OverrideDirective.TemplateDirectiveBodyOverrideWraper(body,env), overrideBody);
            overrideBody.render(env.getOut());
        }
    }

}