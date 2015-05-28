package com.appjangle.servermonitoring.jre.instructions;

import com.appjangle.servermonitoring.types.ServerMonitoringTypes;
import de.mxro.process.Spawn;
import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.NodeList;
import io.nextweb.Query;
import io.nextweb.Session;
import io.nextweb.engine.fn.IntegerResult;
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
        String res = "";
        for (final String line : lines) {
          {
            InputOutput.<String>println(("Run: " + line));
            String _res = res;
            String _sh = Spawn.sh(line);
            String _plus = (_sh + "\n");
            res = (_res + _plus);
            InputOutput.<String>println(res);
          }
        }
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
