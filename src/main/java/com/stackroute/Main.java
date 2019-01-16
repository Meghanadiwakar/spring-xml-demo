package com.stackroute;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {


        //using bean factory
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Movie movie=(Movie) beanFactory.getBean("movie");
        Actor actor = movie.getActor();
        System.out.println(actor.getName()+" "+actor.getAge()+" "+actor.getGender());


        //using bean BeanDefinitionRegistry and  BeanDefinitionReader


        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie1 = ((DefaultListableBeanFactory) beanDefinitionRegistry).getBean(Movie.class);
        Actor actor1 = movie.getActor();
        System.out.println(actor1.getName()+" "+actor1.getAge()+" "+actor1.getGender());


//using application Context

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie2 = context.getBean(Movie.class);
        Actor actor2 = movie.getActor();
        System.out.println(actor2.getName()+" "+actor2.getAge()+" "+actor2.getGender());


    }
}