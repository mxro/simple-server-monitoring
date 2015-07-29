package com.appjangle.servermonitoring.jre.instructions;

import com.appjangle.api.Client;
import com.appjangle.api.Link;
import com.appjangle.api.ListQuery;
import com.appjangle.api.Node;
import com.appjangle.api.NodeList;
import com.appjangle.api.Query;
import com.appjangle.api.engine.fn.IntegerResult;
import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import de.mxro.process.Spawn;
import java.util.List;

@SuppressWarnings("all")
public class ProcessBashInstructions {
  private Node node;
  
  public void now() {
    Client _client = this.node.client();
    ServerMonitoringTypes t = new ServerMonitoringTypes(_client);
    Link _bashInstruction = t.bashInstruction();
    ListQuery _selectAll = this.node.selectAll(_bashInstruction);
    final NodeList bashInstructions = _selectAll.get();
    List<Node> _nodes = bashInstructions.nodes();
    for (final Node bashInstruction : _nodes) {
      {
        Link _bashScript = t.bashScript();
        Query _select = bashInstruction.select(_bashScript);
        Node _get = _select.get();
        Object _value = _get.value();
        final String script = ((String) _value);
        final String res = Spawn.sh(script);
        Link _result = t.result();
        Query _select_1 = bashInstruction.select(_result);
        Query _setValueSafe = _select_1.setValueSafe(res);
        Node _get_1 = _setValueSafe.get();
        IntegerResult _clearVersions = _get_1.clearVersions(2);
        _clearVersions.get();
      }
    }
  }
  
  public ProcessBashInstructions(final Node node) {
    this.node = node;
  }
}
