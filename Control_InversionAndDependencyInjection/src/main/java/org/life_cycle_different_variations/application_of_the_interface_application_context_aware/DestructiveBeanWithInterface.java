package org.life_cycle_different_variations.application_of_the_interface_application_context_aware;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.life_cycle_different_variations.annotation_predestroy.DestructiveBeanWithJSR250;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBeanWithInterface {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithInterface.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");
        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotation-shut_down_hook_bean.xml");
        ctx.registerShutdownHook();
        ctx.refresh();
        ctx.getBean("destructiveBean", DestructiveBeanWithInterface.class);
    }
}
