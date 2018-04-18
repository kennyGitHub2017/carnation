import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;


public class JsonTest {

	   static class PolymorphicType {
	        
	        private String foo;
	        private Object bar;
	        
	        public PolymorphicType() { }
	        public PolymorphicType(String foo, int bar) {
	            this.foo = foo;
	            this.bar = bar;
	        }
	        public String toString(){
	        	return foo+"="+bar;
	        }
	    }
	    
	    @Test
	    public void testBug() throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        
	        mapper.setVisibilityChecker(
	            VisibilityChecker.Std.defaultInstance()
	                .withFieldVisibility(Visibility.ANY)
	                .withGetterVisibility(Visibility.NONE)
	        );
	        
	        StringWriter writer = new StringWriter();
	        mapper.writeValue(writer, new PolymorphicType("hello", 2));
	       System.out.println(mapper.readValue(new StringReader("{\"fsdfsdf\":\"test\"}"), PolymorphicType.class)); 
	    }
	    
}
