package org.cytoscape.internal.tasks;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.task.write.ExportNetworkViewTaskFactory;
import org.cytoscape.work.TaskIterator;
import java.io.File;
public class FileChooserTask extends AbstractTask {
	
	private CyApplicationManager cam;
	private ExportNetworkViewTaskFactory entf;
	
	@Tunable(description="Export as dot file", params="input=false;fileCategory=unspecified")
	public File output = null;
	
	public FileChooserTask(CyApplicationManager new_cam, ExportNetworkViewTaskFactory new_entf) {
		super();
		cam = new_cam;
		entf = new_entf;
	}
	public void run(TaskMonitor taskMonitor) {
		taskMonitor.setStatusMessage(output.getName());
		CyNetworkView currNetworkView = cam.getCurrentNetworkView();
		TaskIterator ti = entf.createTaskIterator(currNetworkView, output);
		this.insertTasksAfterCurrentTask(ti);
	}
}