package com.mahesh.arquillian.arquillian;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreeterTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(Greeter.class,PhraseBuilder.class)
            .addAsResource("arquillian.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @Inject
    Greeter greeter;

    @Test
    public void should_create_greeting() {
    	System.out.println("Running test....");
        Assert.assertEquals("Hello, Earthling!",
            greeter.createGreeting("Earthling"));
        greeter.greet(System.out, "Earthling");
    }

}
