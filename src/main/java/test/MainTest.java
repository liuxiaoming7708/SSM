package test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MainTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setTemplateLoader(new ClassTemplateLoader(Test.class, "junit/framework"));
        try {
            Template template = configuration.getTemplate("temp.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> context = new HashMap<String, Object>();

            context.put("message", "我的第一个Maven_FreeMarker程序");

            template.process(context, writer);
            System.out.println(writer.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}