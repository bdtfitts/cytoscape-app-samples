package org.cytoscape.internal.tasks;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.write.ExportNetworkViewTaskFactory;
public class FileChooserTaskFactory extends AbstractTaskFactory {
	private CyApplicationManager cam;
	private ExportNetworkViewTaskFactory entf;
	public FileChooserTaskFactory(CyApplicationManager new_cam, ExportNetworkViewTaskFactory new_entf) {
		super();
		cam = new_cam;
		entf = new_entf;
	}
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new FileChooserTask(cam, entf));
	}
	public boolean isReady() { return true; }
}