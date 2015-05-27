package com.appjangle.servermonitoring.jre

import io.nextweb.jre.Nextweb
import com.appjangle.servermonitoring.types.ServerMonitoringTypes
import com.appjangle.servermonitoring.ProcessBashInstructions

class ServerMonitoring {
	
	def static main(String[] args) {
		if (args.length != 2) {
			throw new RuntimeException("Supply two arguments: Node and Secret")
		}
		
		val uri = args.get(0)
		val secret = args.get(1)
		
		val session = Nextweb.createSession
		
		val t = new ServerMonitoringTypes(session)
		
		val root = session.link(uri, secret).get
		
		
		val groups = root.selectAll(t.instructionGroup).get
		
		for (group: groups.nodes) {
			
			new ProcessBashInstructions(group).now
			
		}
		
	}
	
}