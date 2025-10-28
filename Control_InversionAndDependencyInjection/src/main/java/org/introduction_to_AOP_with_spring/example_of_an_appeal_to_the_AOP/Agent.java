package org.introduction_to_AOP_with_spring.example_of_an_appeal_to_the_AOP;

public class Agent {
    public void speak(){
        System.out.print("Bond");
    }
}
class AgentProxy extends Agent {

    @Override
    public void speak() {
        System.out.print("James ");
        super.speak();
        System.out.println("!");
    }
}
class Demo {
    public static void doSmth(Agent agent) {
        agent.speak();
    }

    public static void main(String[] args) {
        Agent agent = new AgentProxy();
        doSmth(agent);
    }
}