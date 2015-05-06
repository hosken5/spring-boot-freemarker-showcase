package config;

import freemarker.template.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hongpf on 15/5/4.
 */

@Component
public class IndexOfMethod implements TemplateMethodModel {

    public TemplateModel exec(List args) throws TemplateModelException {
        if (args.size() != 2) {
            throw new TemplateModelException("Wrong arguments");
        }
        return new SimpleNumber(
                ((String) args.get(1)).indexOf((String) args.get(0)));
    }
}
