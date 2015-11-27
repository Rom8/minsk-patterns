package mails.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Roma on 19 Oct 2015.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface TemplateCodes {
    TemplateCode[] value();
}
