package com.appjangle.servermonitoring.jre

import com.appjangle.servermonitoring.jre.instructions.ProcessBashInstructions
import com.appjangle.servermonitoring.types.ServerMonitoringTypes
import java.util.Timer
import java.util.TimerTask
import com.appjangle.api.jre.AppjangleApi

class ServerMonitoring {
	
	def static void main(String[] args) {
		if (args.length != 2) {
			throw new RuntimeException("Supply two arguments: Node and Secret")
		}
		
		val timer = new Timer()
		timer.schedule(new TimerTask() {
			
			override run() {
				println("Operations not completed within timeout.")
				System.exit(0)
			}
			
		}, 1000*60*3
			
		)
		
		val uri = args.get(0)
		val secret = args.get(1)
		
		val session = AppjangleApi.createClient
		
		val t = new ServerMonitoringTypes(session)
		
		val root = session.link(uri, secret).get
		
		println("Loaded instructions: "+root.uri())
		
		val groups = root.selectAll(t.instructionGroup).get
		
		for (group: groups.nodes) {
			
			println("Processing group: "+group.uri())
			new ProcessBashInstructions(group).now
			
		}
		session.close.get
		
		timer.cancel
		
	}
	
}