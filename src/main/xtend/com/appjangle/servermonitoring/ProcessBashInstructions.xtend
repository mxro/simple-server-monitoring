package com.appjangle.servermonitoring

import com.appjangle.servermonitoring.types.ServerMonitoringTypes
import de.mxro.process.Spawn
import io.nextweb.Node

class ProcessBashInstructions {
	  
    Node node;
    
    def now() {
    	var t = new ServerMonitoringTypes(node.session())
    	val bashInstructions = node.selectAll(t.bashInstruction).get();
    	
    	for (bashInstruction : bashInstructions.nodes) {
    		val String script = bashInstruction.select(t.bashScript).get().value() as String
    		
    		val lines = script.split("\n")
 
    		for (line : lines) {
    			println("Run: "+line)
    			var res = Spawn.sh(line);
    			
    			bashInstruction.select(t.result).setValueSafe(res).get()
    			
    		}
    	}
    	
    }
    
    new(Node node) {
        this.node = node;
    }
}