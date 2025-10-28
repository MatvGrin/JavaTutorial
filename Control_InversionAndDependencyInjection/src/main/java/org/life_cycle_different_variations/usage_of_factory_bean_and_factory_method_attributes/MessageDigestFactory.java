package org.life_cycle_different_variations.usage_of_factory_bean_and_factory_method_attributes;

import java.security.MessageDigest;

public class MessageDigestFactory {
    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception{
        return MessageDigest.getInstance(algorithmName);
    }
    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
}
