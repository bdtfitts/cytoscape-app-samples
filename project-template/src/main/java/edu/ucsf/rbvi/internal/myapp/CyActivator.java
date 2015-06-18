package edu.ucsf.rbvi.myapp.internal;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.work.ServiceProperties;
import java.util.Properties;
/**
 * {@code CyActivator} is a class that is a starting point for OSGi bundles.
 * 
 * A quick overview of OSGi: The common currency of OSGi is the <i>service</i>.
 * A service is merely a Java interface, along with objects that implement the
 * interface. OSGi establishes a system of <i>bundles</i>. Most bundles import
 * services. Some bundles export services. Some do both. When a bundle exports a
 * service, it provides an implementation to the service's interface. Bundles
 * import a service by asking OSGi for an implementation. The implementation is
 * provided by some other bundle.
 * 
 * When OSGi starts your bundle, it will invoke {@CyActivator}'s
 * {@code start} method. So, the {@code start} method is where
 * you put in all your code that sets up your app. This is where you import and
 * export services.
 * 
 * Your bundle's {@code Bundle-Activator} manifest entry has a fully-qualified
 * path to this class. It's not necessary to inherit from
 * {@code AbstractCyActivator}. However, we provide this class as a convenience
 * to make it easier to work with OSGi.
 *
 * Note: AbstractCyActivator already provides its own {@code stop} method, which
 * {@code unget}s any services we fetch using getService().
 */
public class CyActivator extends AbstractCyActivator {
	/**
	 * This is the {@code start} method, which sets up your app. The
	 * {@code BundleContext} object allows you to communicate with the OSGi
	 * environment. You use {@code BundleContext} to import services or ask OSGi
	 * about the status of some service.
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		Properties props = new Properties();
		CyNetworkFactory cnf = getService(context, CyNetworkFactory.class);
		CyNetworkManager cnm = getService(context, CyNetworkManager.class);
		CyNetworkViewFactory cnvf = getService(context, CyNetworkViewFactory.class);
		CyNetworkViewManager cnvm = getService(context, CyNetworkViewManager.class);
		VisualMappingManager vmm = getService(context, VisualMappingManager.class);
		VisualStyleFactory vsf = getService(context, VisualStyleFactory.class);
		VisualMappingFunctionFactory vmff = getService(context, VisualMappingFunctionFactory.class, "(mapping.type=passthrough)");
		MyTaskFactory myFactory = new MyTaskFactory(cnf, cnm, cnvf, cnvm, vmm, vsf, vmff);
		props.setProperty(ServiceProperties.PREFERRED_MENU, "Apps.myApp");
		props.setProperty(ServiceProperties.TITLE, "Hello World");
		props.setProperty(ServiceProperties.IN_MENU_BAR, "true");
		props.setProperty(ServiceProperties.COMMAND_NAMESPACE, "myapp");
		props.setProperty(ServiceProperties.COMMAND, "execute");
		registerService(context, myFactory, TaskFactory.class, props);
	}
}
