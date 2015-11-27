package mails.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Roma on 19 Oct 2015.
 */

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TemplateCodes.class)
public @interface TemplateCode {
    int value();
}
