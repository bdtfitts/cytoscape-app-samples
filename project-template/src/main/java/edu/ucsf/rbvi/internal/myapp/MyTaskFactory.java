package edu.ucsf.rbvi.myapp.internal;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;

class MyTaskFactory extends AbstractTaskFactory {
	
	private final CyNetworkFactory cnf;
	private final CyNetworkManager cnm;
	private final CyNetworkViewFactory cnvf;
	private final CyNetworkViewManager cnvm;
	private final VisualMappingManager vmm;
	private final VisualMappingFunctionFactory vmff;
	private final VisualStyleFactory vsf;
	public MyTaskFactory(CyNetworkFactory new_cnf, CyNetworkManager new_cnm,
							CyNetworkViewFactory new_cnvf, CyNetworkViewManager new_cnvm,
							VisualMappingManager new_vmm, VisualStyleFactory new_vsf,
							VisualMappingFunctionFactory new_vmff) {
		super();
		cnf = new_cnf;
		cnm = new_cnm;
		cnvf = new_cnvf;
		cnvm = new_cnvm;
		vmm = new_vmm;
		vsf = new_vsf;
		vmff = new_vmff;
	}
	
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new MyTask(cnf, cnm, cnvf, cnvm, vmm, vsf, vmff));
	}
	
	public boolean isReady() { return true; }
}