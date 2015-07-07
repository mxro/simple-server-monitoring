package com.appjangle.servermonitoring.jre.instructions

import com.appjangle.api.Node
import com.appjangle.servermonitoring.types.ServerMonitoringTypes
import de.mxro.process.Spawn

class ProcessBashInstructions {

	Node node;

	def now() {
		var t = new ServerMonitoringTypes(node.session())
		val bashInstructions = node.selectAll(t.bashInstruction).get();


		for (bashInstruction : bashInstructions.nodes) {
			val String script = bashInstruction.select(t.bashScript).get().value() as String

			val res = Spawn.sh(script);

			bashInstruction.select(t.result).setValueSafe(res).get.clearVersions(2).get

		}

	}

	new(Node node) {
		this.node = node;
	}
}
