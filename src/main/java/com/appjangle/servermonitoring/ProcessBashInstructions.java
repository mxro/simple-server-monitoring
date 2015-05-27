package com.appjangle.servermonitoring;

import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import de.mxro.process.Spawn;
import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Query;
import io.nextweb.Session;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class ProcessBashInstructions {
  private Node node;
  
  public void now() {
    Session _session = this.node.session();
    ServerMonitoringTypes t = new ServerMonitoringTypes(_session);
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
        final String[] lines = script.split("\n");
        for (final String line : lines) {
          {
            InputOutput.<String>println(("Run: " + line));
            String res = Spawn.sh(line);
            Link _result = t.result();
            Query _select_1 = bashInstruction.select(_result);
            Query _setValueSafe = _select_1.setValueSafe(res);
            _setValueSafe.get();
          }
        }
      }
    }
  }
  
  public ProcessBashInstructions(final Node node) {
    this.node = node;
  }
}
