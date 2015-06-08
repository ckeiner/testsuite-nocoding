package test.com.xceptance.xlt.common.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.xceptance.xlt.common.util.URLActionDataStore;
import com.xceptance.xlt.common.util.URLActionDataStoreBuilder;
import com.xceptance.xlt.common.util.bsh.ParameterInterpreter;

public class URLActionStoreBuilderTest
{
    ParameterInterpreter interpreter;
    String name;
    String selectionMode;
    String selectionContent;
    URLActionDataStoreBuilder storeBuilder;
   
    @Before
    public void setup(){
       interpreter = new ParameterInterpreter(null);
       name = "name";
       selectionMode = "XPath";
       selectionContent = "someXPath";
       storeBuilder = new URLActionDataStoreBuilder();
    }
    @Test
    public void testSettersAndGetters()
    {
        storeBuilder.setName(name);
        storeBuilder.setSelectionMode(selectionMode);
        storeBuilder.setSelectionContent(selectionContent);
        storeBuilder.setInterpreter(interpreter);
        
        Assert.assertEquals(name, storeBuilder.getName());
        Assert.assertEquals(selectionMode, storeBuilder.getSelectionMode());
        Assert.assertEquals(selectionContent, storeBuilder.getSelectionContent());

    }
    @Test
    public void testReset()
    {
        storeBuilder.setName(name);
        storeBuilder.setSelectionMode(selectionMode);
        storeBuilder.setSelectionContent(selectionContent);
        storeBuilder.setInterpreter(interpreter);
        
        Assert.assertEquals(name, storeBuilder.getName());
        Assert.assertEquals(selectionMode, storeBuilder.getSelectionMode());
        Assert.assertEquals(selectionContent, storeBuilder.getSelectionContent());
         
        storeBuilder.reset();
        
        Assert.assertNull(storeBuilder.getName());
        Assert.assertNull(storeBuilder.getSelectionContent());
        Assert.assertNull(storeBuilder.getSelectionMode());
        Assert.assertNull(storeBuilder.getInterpreter());

    }
    
    @Test
    public void testBuild()
    {
        storeBuilder.setName(name);
        storeBuilder.setSelectionMode(selectionMode);
        storeBuilder.setSelectionContent(selectionContent);
        storeBuilder.setInterpreter(interpreter);
        
        final URLActionDataStore store = storeBuilder.build();
        
        Assert.assertNotNull(store);
        
        Assert.assertNull(storeBuilder.getName());
        Assert.assertNull(storeBuilder.getSelectionContent());
        Assert.assertNull(storeBuilder.getSelectionMode());
        Assert.assertNull(storeBuilder.getInterpreter());
        
        Assert.assertEquals(name, store.getName());
        Assert.assertEquals(selectionMode, store.getSelectionMode());
        Assert.assertEquals(selectionContent, store.getSelectionContent());

    }
}
