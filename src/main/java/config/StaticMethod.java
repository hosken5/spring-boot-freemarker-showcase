package config;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * Created by hongpf on 15/5/4.
 */
public class StaticMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if(arguments.size()!=1)
            throw new TemplateModelException("arguments only take 1 ");
        return (arguments.get(0)).toString();
        //(SimpleScalar)
    }
}
