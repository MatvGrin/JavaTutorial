package org.life_cycle_different_variations.using_the_message_source_interface_for_internationalization;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-message-source.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");
        Locale ukrainian = new Locale("uk", "UA");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german) );
        System.out.println(ctx.getMessage("nameMsg", new Object[]{ "John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{ "John", "Mayer"}, german));

        System.out.println(ctx.getMessage("msg1", null, english));
        System.out.println(ctx.getMessage("msg1", null, ukrainian) );
        System.out.println(ctx.getMessage("nameMsg1", new Object[]{ "John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg1", new Object[]{ "Puk", "Pok"}, ukrainian));

        ctx.close();
    }
}
