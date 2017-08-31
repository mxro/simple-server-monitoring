package com.appjangle.servermonitoring.jre.instructions;

import com.appjangle.api.Client;
import com.appjangle.api.Node;
import com.appjangle.api.NodeList;
import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import de.mxro.process.Spawn;
import java.util.List;

@SuppressWarnings("all")
public class ProcessBashInstructions {
  private Node node;
  
  public void now() {
    Client _client = this.node.client();
    ServerMonitoringTypes t = new ServerMonitoringTypes(_client);
    final NodeList bashInstructions = this.node.selectAll(t.bashInstruction()).get();
    List<Node> _nodes = bashInstructions.nodes();
    for (final Node bashInstruction : _nodes) {
      {
        Object _value = bashInstruction.select(t.bashScript()).get().value();
        final String script = ((String) _value);
        final String res = Spawn.sh(script);
        bashInstruction.select(t.result()).setValueSafe(res).get().clearVersions(2).get();
      }
    }
  }
  
  public ProcessBashInstructions(final Node node) {
    this.node = node;
  }
}
