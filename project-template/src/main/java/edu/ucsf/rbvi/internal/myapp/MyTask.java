package edu.ucsf.rbvi.myapp.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.ProvidesTitle;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyEdge;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualMappingFunction;
import org.cytoscape.view.vizmap.mappings.PassthroughMapping;
import java.util.List;


public class MyTask extends AbstractTask {
	@Tunable(description = "Num")
	public int f;
	
	private final CyNetworkFactory cnf;
	private final CyNetworkManager cnm;
	private final CyNetworkViewFactory cnvf;
	private final CyNetworkViewManager cnvm;
	private final VisualMappingManager vmm;
	private final VisualStyleFactory vsf;
	private final VisualMappingFunctionFactory vmff;

	
	
	
	public MyTask(CyNetworkFactory new_cnf, CyNetworkManager new_cnm,
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
	public void run(TaskMonitor taskMonitor) {
		CyNetwork newNetwork = cnf.createNetwork();
		cnm.addNetwork(newNetwork);
		for (int i = 0; i < f; ++i) {
			CyNode node = newNetwork.addNode();
			newNetwork.getRow(node).set("name", Integer.toString(i));
		}
		for (int i = 0; i < f/2; ++i) {
			List<CyNode> nodes = newNetwork.getNodeList();
			CyEdge edge = newNetwork.addEdge(nodes.get(i), nodes.get(i+1), false);
			newNetwork.getRow(edge).set("name", Integer.toString(i));
		}
		CyNetworkView view = cnvf.createNetworkView(newNetwork);
		VisualStyle networkVisStyle = vsf.createVisualStyle(vmm.getVisualStyle(view));
		PassthroughMapping nameToLabel = (PassthroughMapping)vmff.createVisualMappingFunction("name", String.class, BasicVisualLexicon.NODE_LABEL);
		networkVisStyle.addVisualMappingFunction(nameToLabel);
		int i = 0;
		for (CyNode node: newNetwork.getNodeList()) {
			View<CyNode> nodeView = view.getNodeView(node);
			nodeView.setVisualProperty(BasicVisualLexicon.NODE_SIZE, 20.0);
			nodeView.setVisualProperty(BasicVisualLexicon.NODE_X_LOCATION, 21.0 * i);
			nodeView.setVisualProperty(BasicVisualLexicon.NODE_Y_LOCATION, 21.0 * i);
			++i;
		}
		networkVisStyle.apply(view);
		view.updateView();
		cnvm.addNetworkView(view);
	}
	
	@ProvidesTitle
	public String getTitle() { return "Number of Nodes"; }
}
