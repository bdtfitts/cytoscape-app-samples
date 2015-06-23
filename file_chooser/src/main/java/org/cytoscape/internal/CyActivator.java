package org.cytoscape.internal;

import org.cytoscape.internal.tasks.FileChooserTaskFactory;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.ServiceProperties;
import org.osgi.framework.BundleContext;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.write.ExportNetworkViewTaskFactory;
import java.util.Properties;
public class CyActivator extends AbstractCyActivator {
	@Override
	public void start(BundleContext context) throws Exception {
		CyApplicationManager cam = getService(context, CyApplicationManager.class);
		ExportNetworkViewTaskFactory entf = getService(context, ExportNetworkViewTaskFactory.class);
		Properties props = new Properties();
		props.setProperty(ServiceProperties.IN_MENU_BAR, "true");
		props.setProperty(ServiceProperties.PREFERRED_MENU, "Apps.FileC");
		props.setProperty(ServiceProperties.TITLE, "Export current Network");
		FileChooserTaskFactory fctfRef = new FileChooserTaskFactory(cam, entf);
		registerService(context, fctfRef, TaskFactory.class, props);
	}
}