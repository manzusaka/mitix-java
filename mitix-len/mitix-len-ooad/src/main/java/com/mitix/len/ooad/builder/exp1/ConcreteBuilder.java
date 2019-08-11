package com.mitix.len.ooad.builder.exp1;

import java.util.Properties;

/**
 * 创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();
    private Properties properties = new Properties();
    private String lala;


    public ConcreteBuilder setName(String name) {
        properties.setProperty("name", name);
        return this;
    }


    public ConcreteBuilder setDoot(String doot) {
        properties.setProperty("doot", doot);
        return this;
    }

    public ConcreteBuilder setLalaPro(String lala) {
        this.lala = lala;
        return this;
    }

    /*
     * (non-Javadoc)
     * @see Builder#buildPart1()
     */
    @Override
    public void buildPart1() {
        product.setName("oldflame");
        System.out.println("buildPart1");

    }

    /*
     * (non-Javadoc)
     * @see Builder#buildPart2()
     */
    @Override
    public void buildPart2() {
        product.setTodo("test builder");
        System.out.println("buildPart2");

    }

    @Override
    public Product retrieveResult() {
        System.out.println("this is use name pro " + this.properties.get("name") + "  lala proout" + this.lala);
        return product;
    }

}
