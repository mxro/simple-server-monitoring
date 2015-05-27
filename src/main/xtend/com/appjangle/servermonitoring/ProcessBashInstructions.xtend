package com.appjangle.servermonitoring

import io.nextweb.Node
import com.appjangle.servermonitoring.types.ServerMonitoringTypes

class ProcessBashInstructions {
	  
    Node node;
    
    def now() {
    	var t = new ServerMonitoringTypes(node.session())
    	val bashInstructions = node.selectAll(t.bashInstruction).get();
    	
    	for (bashInstruction : bashInstructions) {
    		
    	}
    	
    }
    
    new(Node node) {
        this.node = node;
    }
}