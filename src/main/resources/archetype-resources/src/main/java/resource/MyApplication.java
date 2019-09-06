package ${package}.resource;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
	public MyApplication(@Context ServletConfig servletConfig) {
		packages(this.getClass().getPackage().getName())
        			.register(JacksonFeature.class)
        			.register(EncodingFilter.class)
        			.register(GZipEncoder.class)
        			.register(MultiPartFeature.class)
        			.register(DeflateEncoder.class)
        			.register(ApiListingResource.class)
					.register(SwaggerSerializers.class);
		
        BeanConfig beanConfig = new BeanConfig();
        
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("Swagger");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath(servletConfig.getServletContext().getContextPath() + "/api");
        beanConfig.setResourcePackage(this.getClass().getPackage().getName());
        beanConfig.setScan(true);
	}
}