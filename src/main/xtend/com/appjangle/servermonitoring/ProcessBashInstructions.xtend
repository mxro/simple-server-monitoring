package com.appjangle.servermonitoring

import com.appjangle.servermonitoring.types.ServerMonitoringTypes
import io.nextweb.Node

class ProcessBashInstructions {
	  
    Node node;
    
    def now() {
    	var t = new ServerMonitoringTypes(node.session())
    	val bashInstructions = node.selectAll(t.bashInstruction).get();
    	
    	for (bashInstruction : bashInstructions.nodes) {
    		val String script = (String) bashInstruction.value()
    		
    	}
    	
    }
    
    new(Node node) {
        this.node = node;
    }
}