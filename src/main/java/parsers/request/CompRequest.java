package parsers.request;

import parsers.expression.Expression;
import parsers.expression.Node;

import java.util.List;

public class CompRequest extends TokenizedRequest {

  private final ComputationKind computationKind;
  private final ValuesKind valuesKind;
  private final List<VariableValue> variableValues;
  private final List<Expression> expressions;

  protected CompRequest(String req, List<String> tokens, ComputationKind computationKind, ValuesKind valuesKind, List<VariableValue> variableValues, List<Node> expressions) {
    super(req, tokens, RequestType.COMP);
    this.computationKind = computationKind;
    this.valuesKind = valuesKind;
    this.variableValues = variableValues;
    this.expressions = expressions.parallelStream().map(Expression::new).toList();
  }

  public ComputationKind computationKind() {
    return computationKind;
  }

  public ValuesKind valuesKind() {
    return valuesKind;
  }

  public List<VariableValue> variableValues() {
    return variableValues;
  }

  public List<Expression> expressions() {
    return expressions;
  }

  public enum ComputationKind {
    MAX,
    MIN,
    AVG,
    COUNT
  }

  public enum ValuesKind {
    GRID,
    LIST
  }

  public record VariableValue(String name, Double startingVal, Double step, Double finalVal) {
    public VariableValue {
      if(step <= 0){
        throw new IllegalArgumentException("Step value for " + name + " must be >= 0");
      }
      if(finalVal < startingVal){
        throw new IllegalArgumentException("End of the range of " + name + " cannot be smaller than the start of the range");
      }
    }
  }
}
